pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'make check'
                junit 'test-output/junitreports/*.xml'
                selenium 'test-output/testng-results.xml'
            }
        }
        stage('Deploy') {
            when {
                expression{
                    currentBuild.result == 'SUCCESS'
                }
            }
            steps {
                bat 'make publish'
            }
        }
    }
}