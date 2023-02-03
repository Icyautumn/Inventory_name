pipeline {
    agent any
    tools {
        maven 'Maven 3.8.6'
    }
    stages {
        stage('Build & SonarQube Analysis') {
            steps {
                bat label: 'Build Project', script: '''
                    @echo off
                    echo Building...
                    mvn clean package sonar:sonar
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
        stage('Quality Gate') {
            steps {
                echo 'Quality Gate...'
                waitForQualityGate abortPipeline: true
            }
            post {
                success {
                    echo 'Quality Gate passed'
                }
                failure {
                    echo 'Quality Gate failed'
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
                deploy adapters: [tomcat9(credentialsId: '1db651fb-13cd-4076-9bdd-4a750fea95ef', path: '', url: 'http://localhost:8090')], contextPath: 'Inventory_manager', onFailure: false, war: 'target/*.war'
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
