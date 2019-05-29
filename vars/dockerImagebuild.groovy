def call(String[] FILE_ARRAY) {
    
     echo FILE_ARRAY[0];
     for (file in FILE_ARRAY) {
     
      file=file.split("-")
      println file[1]
  
     }



}
