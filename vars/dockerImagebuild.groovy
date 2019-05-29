def call(String[] FILE_ARRAY, String NEXUS_REGISTRY) {
    
     echo FILE_ARRAY[0];
     for (file in FILE_ARRAY) {
     
      imagename=file.split("-")
      
      println "Building image "+imagename[1]
      sh "docker build -f ${file} -t ${imagename[1]}:latest ."
      
      println "Tag Image "+imagename[1]
      sh "docker tag ${imagename[1]}:latest ${NEXUS_REGISTRY}/${imagename[1]}:latest"

      println "Login to NEXUS Registry"
      withCredentials([usernamePassword(
                       credentialsId: 'nexuscred',
                       passwordVariable: 'nexuspass',
                       usernameVariable: 'nexususer')]) {
                       sh "docker login -u '$nexususer' -p '$nexuspass' ${NEXUS_REGISTRY}"
             }
      
      println "Push to NEXUS REPO"
      sh "docker push ${NEXUS_REGISTRY}/${imagename[1]}:latest"
         
     }

}
