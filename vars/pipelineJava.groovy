def call() {
  pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    environment {
        BUZZ = 'FIZZ'
    }
    stages {
        stage('Build') {
            agent any
            steps {
                echo 'Build..'
            }
        }
        stage('Code Metrics') {
            agent any
            steps {
                echo 'Code Metrics..'
            }
        }
        stage('Deploy') {
            agent any
            steps {
                echo 'Deploying....'
            }
        }
    }
  }
}
