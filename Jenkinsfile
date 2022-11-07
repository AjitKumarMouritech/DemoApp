pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
               bat "rmdir  /s /q JenkinsPro"
                bat "git clone https://github.com/AjitKumarMouritech/DemoApp.git"
                bat "mvn clean -f JenkinsPro"
            }
        }
        stage('install') {
            steps {
                bat "mvn install -f JenkinsPro"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f JenkinsPro"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f JenkinsPro"
            }
        }
    }
}
