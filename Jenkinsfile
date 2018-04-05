def internalFunction_sendMessage(msgtosend) {

    echo "JJ DEBUG - In internalFunction_sendMessage"
    echo msgtosend

}


node {

   stage('JJ Checkout SCM') {
       internalFunction_sendMessage('Begin checkout scm')
       checkout scm
       internalFunction_sendMessage('Done checkout scm')
   }



   def mvnHome
   
   def extFunction = load "jenkins/actions.groovy"
   def cfg = load "jenkins/config.groovy"
   
   stage('Preparation M3') { // for display purposes
      echo 'Setup Maven from Global tools'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
   }
   stage('Preparation SourceCode') { // for display purposes
         // Get some code from a GitHub repository
         echo 'Access GIT source code'
        //git 'https://github.com/johnclasheski/IRRMA.git'
        git 'file:///C:/Apps/CLOUD/git/IRRMA_APP'

         echo 'Done - got git code'

   }
   stage('Build with Ant') {
      //run with ant
      echo 'MY TRY AT RUNNING WITH ANT'
      withAnt(installation: 'Ant', jdk: 'My JDK C:\\Oracle\\Middleware\\Oracle_Home\\oracle_common\\jdk') {
          // bat (/"ant" -buildfile C:\Tools\CMSDownloads\IRRMAOnline\IRRMA_APP_DEV\IRRMA_APP_DEV\IRRMA_APP\source\build.xml release/)
          bat (/"ant" -buildfile source\build.xml release/)
      }
   } 
   
   stage('Test Groovy call') {
      internalFunction_sendMessage('MY TRY AT CALLING GROOVY 1')
      extFunction.handle_success('JJJJ')
      internalFunction_sendMessage('MY TRY AT CALLING GROOVY 2')
      extFunction.test_call(cfg)

      internalFunction_sendMessage('START Test Ansible Deploy')
      extFunction.ansible_deploy(cfg)
      internalFunction_sendMessage('END Test Ansible Deploy')
   }   
   
   
//these two stages are good   
//   stage('Identify M3') {
//      // Run the maven build
//      if (isUnix()) {
//         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
//      } else {
//	 bat(/"${mvnHome}\bin\mvn" -version/)
//      }
//   }
//   stage('Build with M3') {
//      // Run the maven build
//      if (isUnix()) {
//         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
//      } else {
//	 bat(/"${mvnHome}\bin\mvn" -e -f C:\Apps\CLOUD\git\spring-cloud-microservice-example\pom.xml -Dmaven.test.failure.ignore clean compile/)
//      }
//   }


//i never tested this below stage
//   stage('Results') {
//      junit '**/target/surefire-reports/TEST-*.xml'
//      archive 'target/*.jar'
//   }

}