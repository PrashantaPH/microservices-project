# Use Maven to build the project
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use a lightweight Java runtime for execution
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Install Netcat (for health checks)
RUN apt-get update && apt-get install -y netcat-openbsd && rm -rf /var/lib/apt/lists/*

# Copy built JAR files
COPY --from=build /app/jwt-authentication-svc/target/*.jar jwt-authentication-svc.jar
COPY --from=build /app/api-gateway/target/*.jar api-gateway.jar
COPY --from=build /app/clientmanagement-svc/target/*.jar clientmanagement-svc.jar
COPY --from=build /app/discovery-server/target/*.jar discovery-server.jar
COPY --from=build /app/config-server/target/*.jar config-server.jar

# Copy the entry script
COPY entry.sh /app/entry.sh

# Give execute permissions
RUN chmod +x /app/entry.sh

# Expose necessary ports
EXPOSE 8761 8089 8888 8081 8084

# Use ENTRYPOINT instead of CMD
ENTRYPOINT ["/bin/bash", "/app/entry.sh"]

# # Start required microservices (modify as per your needs)
# CMD java -jar discovery-server.jar & \
#     java -jar config-server.jar & \
#     java -jar api-gateway.jar & \
#     java -jar clientmanagement-svc.jar & \
#     java -jar jwt-authentication-svc.jar & \
#     tail -f /dev/null
