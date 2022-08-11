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
        parallel {
          stage('validate') {
            steps {
              echo 'Validate..'
            }
          }
          stage('Test') {
            steps {
              echo 'Testing..'
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
