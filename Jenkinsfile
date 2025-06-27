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
                git branch: 'master', url: 'https://github.com/praveentripathi001/Selenium_Automation_TestNG.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Generate Reports') {
            steps {
                bat 'mvn verify'
            }
        }
        

        stage('Publish TestNG Results') {
            steps {
               junit 'target/surefire-reports/testng-results.xml'
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
