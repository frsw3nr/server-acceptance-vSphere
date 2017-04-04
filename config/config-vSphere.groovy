// 検査仕様シート定義

evidence.source = './vSphereチェックシート.xlsx'
evidence.sheet_name_server = 'チェック対象'
evidence.sheet_name_rule = '検査ルール'
evidence.sheet_name_spec = [
    'vSphere': 'ゲストOSチェックシート(vSphere)'
]

// 検査結果ファイル出力先

evidence.target='./build/vSphereチェックシート_<date>.xlsx'

// 検査結果ログディレクトリ

evidence.staging_dir='./build/log'

// CSV変換マップ

evidence.csv_item_map = [
    'サーバ名' :            'server_name',
    'IPアドレス' :          'ip',
    'Platform' :            'platform',
    'OSアカウントID' :      'os_account_id',
    'vCenterアカウントID' : 'remote_account_id',
    'VMエイリアス名' :      'remote_alias',
    '検査ID' :              'verify_id',
    '比較対象サーバ名' :    'compare_server',
    'CPU数' :               'NumCpu',
    'メモリ量' :            'MemoryGB',
    'ESXi名' :              'ESXiHost',
    'HDD' :                 'HDDtype',
]

// 並列化しないタスク
// 並列度を指定をしても、指定したドメインタスクはシリアルに実行する

test.serialization.tasks = ['vSphere']

// DryRunモードログ保存先

test.dry_run_staging_dir = './src/test/resources/log/'

// コマンド採取のタイムアウト
// Windows,vCenterの場合、全コマンドをまとめたバッチスクリプトのタイムアウト値

test.vSphere.timeout  = 300

// コマンド採取のデバッグモード

// test.Linux.debug   = false
// test.Windows.debug = false
// test.VMHost.debug  = false
// test.vSphere.debug = false

 // vSphere session

account.vSphere.Test.user      = 'administrator@vsphere.localhost'
account.vSphere.Test.password  = 'P@ssword'
