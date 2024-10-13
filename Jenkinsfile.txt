pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{
                echo 'Cloning the repository'
                git branch: 'master', url: 'https://github.com/rahusingh1/SeleniumAssignment.git'
            }
        }
        
        stage('Test'){
            steps{
                echo 'Testing the automation code from jenkins'
                bat 'mvn clean test'
            }
        }
    }
    post{
        always{
            echo 'Pipeline build completed'
        }
        success{
            echo 'Build Success'
        }
        failure{
            echo 'Build Failure'
        }
    }
}