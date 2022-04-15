pipeline {
    agent any

    stages {
        stage('continuous download') {
            steps {
                git 'https://github.com/kapilanarayana/DemoATR.git'
            }
        }
         stage('continuous build') {
            steps {
                sh 'mvn install'
            }
        }
         stage('continuous deploy') {
            steps {
                sh 'sshpass -p "karthik" scp target/DemoATR.war karthik@172.17.0.3:/opt/apache-tomcat-9.0.60/webapps'
            }
        }
    }
}
