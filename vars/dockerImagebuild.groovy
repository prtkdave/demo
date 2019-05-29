def call(String[] FILE_ARRAY, String NEXUS_URL) {
    
     echo FILE_ARRAY[0];
     for (file in FILE_ARRAY) {
     
      imagename=file.split("-")
      
      println "Building image "+imagename[1]
      sh "docker build -f ${file} -t ${imagename[1]}:latst ."
      
      println "Tag Image "+imagename[1]
      sh "docker tag ${imagename[1]}:latst ${NEXUS_URL}/${imagename[1]}:latst"

     }

}
