pipeline {
    agent any

    tools {
        maven "MAVEN_HOME"
        jdk 'JAVA_HOME'        // or the JDK configured in Jenkins
    }

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/praveentripathi001/Selenium_Automation_TestNG.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Generate Reports') {
            steps {
                sh 'mvn verify'
            }
        }

        stage('Publish TestNG Results') {
            steps {
                publishTestNG testResultsPattern: 'test-output/testng-results.xml'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
