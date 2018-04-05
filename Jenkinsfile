node {

   stage('JJ Checkout SCM') {
       echo 'Test checkout scm verb'
       checkout scm
       echo 'Done Test checkout scm verb'   
   }



   def mvnHome
   
   def act = load "../actions.groovy"
   
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
   stage('Identify M3') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
	 bat(/"${mvnHome}\bin\mvn" -version/)
      }
   }
   stage('Build with M3') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
	 bat(/"${mvnHome}\bin\mvn" -e -f C:\Apps\CLOUD\git\spring-cloud-microservice-example\pom.xml -Dmaven.test.failure.ignore clean compile/)
      }
   }
//   stage('Results') {
//      junit '**/target/surefire-reports/TEST-*.xml'
//      archive 'target/*.jar'
//   }
}