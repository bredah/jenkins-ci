def call() {
  pipeline {
    agent any
    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '5')
    }
    environment {
        BUZZ = 'FIZZ'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Build..'
            }
        }
        stage('Test') {
            parallel {
                stage('Unit Test') {
                    steps {
                        echo 'Unit Tests..'
                    }
                    post {
                        always {
                            echo 'After Unit Tests..'
                        }
                    }
                }
                stage('Component Tests') {
                    steps {
                        echo 'Component Tests..'
                    }
                    post {
                        always {
                            echo 'After Component Tests..'
                        }
                    }
                }
                stage('Integration Tests') {
                    steps {
                        echo 'Integration Tests..'
                    }
                    post {
                        always {
                            echo 'After Integration Tests..'
                        }
                    }
                }
            }
        }
        stage('Code Metrics') {
            steps {
                echo 'Code Metrics..'
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
