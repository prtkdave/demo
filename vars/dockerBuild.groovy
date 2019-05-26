def call(String project, String hubUser) {
    sh "docker image build -t ${hubUser}/${project}:beta-${env.BRANCH_NAME}-${env.BUILD_NUMBER} ."
    withCredentials([usernamePassword(
            credentialsId: "docker",
            usernameVariable: "dockeruser",
           passwordVariable: "dockerpass"
    )]) {
        sh "docker login -u '$dockeruser' -p '$dockerpass'"
    }
    sh "docker image push ${hubUser}/${project}:beta-${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
}
