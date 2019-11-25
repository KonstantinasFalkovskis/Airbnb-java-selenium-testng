#!groovy
node {
	stage('Git checkout') { 
		git branch: 'qa', credentialsId: '1a95d5c2-06a5-4972-866a-51a87849f98f', url:'https://github.com/BushnevYuri/e2e-automation-pipeline.git'
	}
	stage('Smoke') {
		try {
			sh "mvn clean verify -Dtags='type:smoke'"
		} catch (err) {

		} finally {
			publishHTML (target: [
					reportDir: 'test-output/',
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
					reportDir: 'test-output/',
					reportFiles: 'seb_report.html',
					reportName: "Functional tests report"
			])
		}
	}
	stage('Regression') {
		try {
			sh "mvn clean verify -Dtags='type:regression'"
		} catch (err) {

		} finally {
			publishHTML (target: [
					reportDir: 'test-output/',
					reportFiles: 'seb_report.html',
					reportName: "Regression tests report"
			])
		}
	}
	stage('Results') {
		testng '**/test-output/*.xml'
	}
}