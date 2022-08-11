def call() {
  pipeline {
    agent any
    environment {
        BUZZ = 'FIZZ'
    }
    stages {
        stage('Build') {
          stage('Compile') {
            steps {
              echo 'Compile..'
            }
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
