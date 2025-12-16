def call(String credId, String imageName){
  withCredentials([usernamePassword(
    credntialsId:"$credId",
    usernameVariable:"dockerhubuser",
    passwordVariable:"dockerhubpass"
    
  )]){
    sh " docker login -u ${env.dockerhubuser} -p ${env.dockerhubpass}"
    sh " docker image tag ${imageName} ${env.dockerhubuser}/${imageName}"
    sh " docker push ${env.dockerhubuser}/${imageName}:latest"
  }



}
