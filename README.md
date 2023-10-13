# Launch the KeyCloak
Start the container:
``docker run -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:22
.0.0 start-dev``

# Launch Zipkin
Start the container:
``docker run -p 9411:9411 openzipkin/zipkin``
