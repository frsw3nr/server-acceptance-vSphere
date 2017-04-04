package InfraTestSpec

import groovy.util.logging.Slf4j
import groovy.transform.InheritConstructors
import org.apache.commons.io.FileUtils.*
import static groovy.json.JsonOutput.*
import org.hidetake.groovy.ssh.Ssh
import jp.co.toshiba.ITInfra.acceptance.InfraTestSpec.*
import jp.co.toshiba.ITInfra.acceptance.*

@Slf4j
@InheritConstructors
class vSphereSpec extends VMHostSpecBase {

    def init() {
        super.init()
    }

    def finish() {
        super.finish()
    }

    def license(test_item) {
        def command = """\
            |\$vSphereLicInfo = @()
            |\$ServiceInstance = Get-View ServiceInstance -Server $vm
            |Foreach (\$LicenseMan in Get-View (\$ServiceInstance | Select -First 1).Content.LicenseManager) {
            |    Foreach (\$License in (\$LicenseMan | Select -ExpandProperty Licenses)) {
            |        \$Details = "" |Select VC, Name, Key, Total, Used
            |        \$Details.VC    = ([Uri]\$LicenseMan.Client.ServiceUrl).Host
            |        \$Details.Name  = \$License.Name
            |        \$Details.Key   = \$License.LicenseKey
            |        \$Details.Total = \$License.Total
            |        \$Details.Used  = \$License.Used
            |        \$vSphereLicInfo += \$Details
            |    }
            |}
            |\$vSphereLicInfo | FL
        """.stripMargin()

        run_script(command) {
            def lines = exec('license') {
                new File("${local_dir}/license")
            }
            def csv  = []
            def keys = [:]
            def res  = [:].withDefault{[:]}
            def row  = 0
            lines.eachLine {
                (it =~  /^(VC|Name|Key|Total|Used)\s+:\s(.*)$/).each {
                    m0, m1, m2 ->
                    res[row][m1] = m2 ?: 'Unkown'
                    if (m1 == 'Used') {
                        csv << [
                            res[row]['VC'], res[row]['Name'], res[row]['Key'],
                            res[row]['Total'], res[row]['Used']
                        ]
                        keys[res[row]['Name']] = res[row]['Key']
                        row ++
                    }
                }
            }
            def headers = ['VC', 'Name', 'Domain', 'Description', 'Server']
            test_item.devices(csv, headers)
            test_item.results(keys.toString())
        }
    }

}
