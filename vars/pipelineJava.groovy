def call() {
  pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
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
