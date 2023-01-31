pipeline {
    agent any
    tools {
        maven 'Maven 3.8.6'
    }
    stages {
        stage('Build') {
            steps {
                bat label: 'Build Project', script: '''
                    @echo off
                    echo Building...
                    mvn package -Dmaven.test.skip=true
                '''
            }
            post {
                always {
                    echo 'Build complete'
                }
                failure {
                    echo 'Build failed'
                    emailext body: 'Build has failed', subject: 'Build Failed', to: 'jarvisgan@gmail.com'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*xml'
                }
                success {
                    echo 'Tests passed'
                }
                failure {
                    echo 'Test failed'
                    emailext body: 'Test has failed', subject: 'Test Failed', to: 'jarvisgan@gmail.com'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                deploy adapters: [tomcat9(credentialsId: '8bfbcc6e-5475-4c02-9441-f7000bf29ae4', path: '', url: 'http://localhost:8090')], contextPath: 'Inventory_manager', onFailure: false, war: 'target/*.war'
            }
            post {
                success {
                    echo 'Deployment complete'
                }
                failure {
                    echo 'Deploy failed'
                    emailext body: 'Deplyment has failed', subject: 'Deplyment Failed', to: 'jarvisgan@gmail.com'
                }
            }
        }
    }
}
