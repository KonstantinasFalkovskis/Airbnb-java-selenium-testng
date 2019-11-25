node {
   
   def mvnHome
   
    stage('SCM Checkout') { // for display purposes
      git branch: 'qa', credentialsId: '1a95d5c2-06a5-4972-866a-51a87849f98f', url: 'https://github.com/KonstantinasFalkovskis/Airbnb-java-selenium-testng.git'
      mvnHome = tool 'M3'
   }
   
   stage('Build') {
      // Run the maven build
      sh "mvn clean build"
      }
   
    stage('Smoke') {
        try {
            sh "mvn clean verify -Dtags='type:smoke'"
        } catch (err) {
            
        } finally {
            publishHTML (target: [
            reportDir: 'test-out/',
            reportFiles: 'seb_report.html',
            reportName: "Smoke tests report"
            ])
        }
   }
   stage('Functional') {
        try {
            sh "mvn clean verify -Dtags='type:functional'"
        } catch (err) {
            
        } finally {
            publishHTML (target: [
            reportDir: 'test-out/',
            reportFiles: 'seb_report.html',
            reportName: "Functional tests report"
            ])
        }
   }
   stage('UI Regression') {
        try {
            sh "mvn verify -Dtags='type:regression'"
        } catch (err) {
            
        } finally {
            publishHTML (target: [
            reportDir: 'test-out/',
            reportFiles: 'seb_report.html',
            reportName: "Regression tests report"
            ])
        }
   }
   stage('TestNG Results') {
      testng '**/test-output/testng-results.xml'
   }
   stage('Extends Reports Results') {
      test '**/test-output/seb_report.html'
      archiveArtifacts 'target/*.jar'
   }
   }
}