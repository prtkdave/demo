def call(String[] FILE_ARRAY, String NEXUS_REGISTRY, String IMAGE_TAG) {
    for (file in FILE_ARRAY) { 
      imagename=file.split("-")
      
      println "Building image "+imagename[1]
      sh "docker build -f ${file} -t ${imagename[1]}:${IMAGE_TAG} ."
      
      println "Tag Image "+imagename[1]
      sh "docker tag ${imagename[1]}:${IMAGE_TAG} ${NEXUS_REGISTRY}/${imagename[1]}:${IMAGE_TAG}"

      println "Login to NEXUS Registry"
      withCredentials([usernamePassword(
                       credentialsId: 'nexuscred',
                       passwordVariable: 'nexuspass',
                       usernameVariable: 'nexususer')]) {
                       sh "docker login -u '$nexususer' -p '$nexuspass' ${NEXUS_REGISTRY}"
             }
      
      println "Push to NEXUS REPO"
      sh "docker push ${NEXUS_REGISTRY}/${imagename[1]}:${IMAGE_TAG}"
         
     }

}
