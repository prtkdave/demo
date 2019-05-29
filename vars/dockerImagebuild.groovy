def call(String[] FILE_ARRAY, String NEXUS_REGISTRY) {
    
     echo FILE_ARRAY[0];
     for (file in FILE_ARRAY) {
     
      imagename=file.split("-")
      
      println "Building image "+imagename[1]
      sh "docker build -f ${file} -t ${imagename[1]}:latst ."
      
      println "Tag Image "+imagename[1]
      sh "docker tag ${imagename[1]}:latst ${NEXUS_REGISTRY}/${imagename[1]}:latst"

      println "Login to NEXUS Registry"
           withCredentials([usernamePassword(
                       credentialsId: 'nexuscred',
                       passwordVariable: 'nexuspass',
                       usernameVariable: 'nexususer')]) {
					   sh "echo $nexususer"
					   sh "echo $nexuspass"
                    
                       sh "docker login -u $nexususer -p $nexuspass $NEXUS_REGISTRY"
             }

     }

}
