node {
    stage 'Building image'
    git 'https://github.com/voidp34r/backend-challenge' // checks out Dockerfile
    def myEnv = docker.build 'invilla:snapshot'
    myEnv.inside {
        sh 'mvn clean package'
    }
}
