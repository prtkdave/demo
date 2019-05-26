def call(String imageName, String buildId) { 

	def scriptFileContent = libraryResource( 'com/linagora/analyze-dockerfile.sh' )
	sh scriptFileContent
	sh 'echo "imageName: ${imageName}" >> /tmp/gov.results.txt'
	sh 'echo "imageVersion: ${buildId}" >> /tmp/gov.results.txt'
	sh 'curl --data-binary "@/tmp/gov.results.txt" -X POST...'
	sh 'rm -rf /tmp/gov.results.txt'
}
