pipeline {
    agent any
    options {
        skipDefaultCheckout(true)
        timestamps()
        disableConcurrentBuilds()
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Compile') {
                    steps {
                        sh 'chmod +x mvnw'
                        sh './mvnw -B -DskipTests compile'
                    }
                }
        stage('Tests') {
            steps {
                sh './mvnw -B test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Package') {
            steps {
                sh './mvnw -B -DskipTests package'
                archiveArtifacts 'target/*.jar'
            }
        }
        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                echo 'Deploying Spring Boot JAR...'
            }
        }
        stage('Smoke Test') {
            when {
                branch 'main'
            }
            steps {
                sh 'sleep 5'
                sh 'curl -f http://127.0.0.1:8081/api/health'
            }
        }
    }
    post {
        success {
            echo 'SPRING PIPELINE SUCCESSFUL'
        }
        failure {
            echo 'SPRING PIPELINE FAILED'
        }
    }
}