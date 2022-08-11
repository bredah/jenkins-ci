def call() {
  pipeline {
    agent any
    environment {
        BUZZ = 'FIZZ'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Build..'
            }
        }
        stage('Code Metrics') {
            steps {
                echo 'Code Metrics..'
            }
        }
        stage('Test') {
            parallel {
                stage('Back-End') {
                    steps {
                        echo 'Testing..'
                    }
                }
                stage('Front-End') {
                    steps {
                        echo 'Testing..'
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
  }
}
