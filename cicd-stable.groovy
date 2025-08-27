node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/alternativesport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/alternativesport.git'), string(name: 'PORT_DESCRIPTION', value: 'A system tool for maintaining the /etc/rc*.d hierarchy' ), string(name: 'BUILD_LINE', value: 'STABLE') ]
  }
}
