pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                sh 'make build'
            }
            post {
                always {
                    echo 'Build complete'
                }
                failure {
                    echo 'Build failed'
                    sendMail subject: 'Build failed', body: 'Build failed'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                sh './test-output/junitreports/.xml test'
                junit 'src/test/java/models/*.java'
            }
            post {
                always {
                    junit 'test-output/junitreports/*.xml'
                }
                success {
                    echo 'Tests passed'
                }
                failure {
                    echo 'Test failed'
                    sendMail subject: 'Test failed', body: 'Test failed'
                }
            }
        }
        stage('Deploy') {
            when {
                expression {
                    currentBuild.result == 'SUCCESS'
                }
            }
            steps {
                echo 'Deploying...'
                sh 'make publish'
            }
            post {
                success {
                    echo 'Deployment complete'
                }
                failure {
                    echo 'Deploy failed'
                    sendMail subject: 'Deploy failed', body: 'Deploy failed'
                }
            }
        }
    }
}
