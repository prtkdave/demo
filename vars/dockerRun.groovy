def call(String DOCKER_PORT, String HOST_PORT, String IMAGE_NAME, String IMAGE_TAG, String DOCKER_NAME) {
      
      println "Running Container "+DOCKER_NAME
      sh "docker run -d -p ${DOCKER_PORT}:${HOST_PORT} --name ${DOCKER_NAME} ${IMAGE_NAME}:${IMAGE_TAG}"
     }

}
