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

        stage("Sonar Analysis"){
            steps{
                withSonarQubeEnv("Test_SonarQube"){
                    bat "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:4.0.0.4121:sonar"
                }
            }
        }

        stage("Publish to Artifactory"){
            steps{
                rtMavenDeployer(
                    id: 'deployer',
                    serverId: '022590@artifactory',
                    releaseRepo: 'nagp.test.2024',
                    snapshotRepo: 'nagp.test.2024'
                )
                rtMavenRun(
                    pom: 'pom.xml',
                    goals: 'clean install',
                    deployerId: 'deployer'
                )
                rePublishBuildInfo(
                    serverId: '022590@artifactory'
                )
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
