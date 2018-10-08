node
{
    stage ('git checkout')
       {
           git 'https://github.com/akshaytiwari29/FinalCalci.git'

       }
        stage('MVN Package')
         {  
                sh "mvn clean package"
         }
         
          stage('Build Docker Image'){
       sh 'docker build -t 9730597302/my-app:0.0.1 .'
  }
  
    stage('Upload Image to DockerHub')
    {
   
    withCredentials([string(credentialsId: 'docker-hubpwd', variable: 'dockerHubpwd')]) {
          sh "docker login -u 9730597302 -p ${dockerHubpwd}"

}



    sh 'docker push 9730597302/my-app:0.0.1'
  }
  
      stage ('deploy container to dev')
         {
             sh 'docker run  --rm -p 8888:8080 --name my-app 9730597302/my-app:0.0.1'
         }
       
}
