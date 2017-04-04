// �����d�l�V�[�g��`

evidence.source = './vSphere�`�F�b�N�V�[�g.xlsx'
evidence.sheet_name_server = '�`�F�b�N�Ώ�'
evidence.sheet_name_rule = '�������[��'
evidence.sheet_name_spec = [
    'vSphere': '�Q�X�gOS�`�F�b�N�V�[�g(vSphere)'
]

// �������ʃt�@�C���o�͐�

evidence.target='./build/vSphere�`�F�b�N�V�[�g_<date>.xlsx'

// �������ʃ��O�f�B���N�g��

evidence.staging_dir='./build/log'

// CSV�ϊ��}�b�v

evidence.csv_item_map = [
    '�T�[�o��' :            'server_name',
    'IP�A�h���X' :          'ip',
    'Platform' :            'platform',
    'OS�A�J�E���gID' :      'os_account_id',
    'vCenter�A�J�E���gID' : 'remote_account_id',
    'VM�G�C���A�X��' :      'remote_alias',
    '����ID' :              'verify_id',
    '��r�ΏۃT�[�o��' :    'compare_server',
    'CPU��' :               'NumCpu',
    '��������' :            'MemoryGB',
    'ESXi��' :              'ESXiHost',
    'HDD' :                 'HDDtype',
]

// ���񉻂��Ȃ��^�X�N
// ����x���w������Ă��A�w�肵���h���C���^�X�N�̓V���A���Ɏ��s����

test.serialization.tasks = ['vSphere']

// DryRun���[�h���O�ۑ���

test.dry_run_staging_dir = './src/test/resources/log/'

// �R�}���h�̎�̃^�C���A�E�g
// Windows,vCenter�̏ꍇ�A�S�R�}���h���܂Ƃ߂��o�b�`�X�N���v�g�̃^�C���A�E�g�l

test.vSphere.timeout  = 300

// �R�}���h�̎�̃f�o�b�O���[�h

// test.Linux.debug   = false
// test.Windows.debug = false
// test.VMHost.debug  = false
// test.vSphere.debug = false

 // vSphere session

account.vSphere.Test.user      = 'administrator@vsphere.localhost'
account.vSphere.Test.password  = 'P@ssword'
