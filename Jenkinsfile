pipeline {
    agent any

    stages {
        stage('continuous download') {
            steps {
                git 'https://github.com/kapilanarayana/war-web-project.git'
            }
        }
         stage('continuous build') {
            steps {
                sh 'mvn install'
            }
        }
         stage('continuous deploy') {
            steps {
                sh 'cp target/wwp-1.0.0.war /opt/apache-tomcat-9.0.62/webapps'
            }
        }
    }
}
