# Build
custom_build (
    # Container name
    ref='order-service',
    # Command to build container image
    command='./gradlew bootImageBuild --imageName $EXPECTED_REF',
    # Files to watch that trigger a new build.
    deps=['build.gradle', 'src']
)
# Deploy
k8s_yaml(['k8s/deployment.yml', 'k8s/service.yml'])

# Manage
k8s_resource('order-service', port_forwards=['9002'])