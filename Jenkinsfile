pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh './store-webapp-sample/gradlew clean build -p store-webapp-sample'                   
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh './store-webapp-sample/gradlew test -p store-webapp-sample'
                sh './store-webapp-sample/gradlew jacocoTestReport -p store-webapp-sample'   

                // Publish the JUnit test Report
                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'store-webapp-sample/build/reports/tests/test',
                    reportFiles: 'index.html',
                    reportName: 'JUnit Report'
                  ]

                // Publish the Java Code Coverage Report
                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'store-webapp-sample/build/jacocoHtml',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Report'
                  ]                              
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh './store-webapp-sample/gradlew jar -p store-webapp-sample'                
            }
        }
    }

    post {
        always {            
            archiveArtifacts artifacts: 'store-webapp-sample/build/libs/**/*.jar', fingerprint: true
            archiveArtifacts artifacts: 'store-webapp-sample/build/libs/**/*.war', fingerprint: true
            junit 'store-webapp-sample/build/test-results/**/*.xml'
        }
    }
}
