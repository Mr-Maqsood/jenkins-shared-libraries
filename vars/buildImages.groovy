def call(String backendPath, String frontendPath, String imageTag) {
    env.BACKEND_TAG_DH  = "${env.DOCKERHUB_USER}/three-tier-app-backend:${imageTag}"
    env.FRONTEND_TAG_DH = "${env.DOCKERHUB_USER}/three-tier-app-frontend:${imageTag}"

    sh """
        echo "🚀 Building Backend Docker Image..."
        docker build -t ${BACKEND_TAG_DH} ${backendPath}

        echo "🚀 Building Frontend Docker Image..."
        docker build -t ${FRONTEND_TAG_DH} ${frontendPath}
    """
}
