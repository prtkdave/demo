def call(String[] FILE_ARRAY) {
    
     echo FILE_ARRAY[0];
     for (file in FILE_ARRAY) {
     
      imagename=file.split("-")
      println "Building image"+imagename[1]

      sh "docker build -f ${file} -t ${imagename[1]}:latst ."
   
     }



}
