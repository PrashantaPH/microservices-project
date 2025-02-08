#!/bin/bash

echo "Starting Eureka Discovery Server..."
java -jar discovery-server.jar &

echo "Waiting for Discovery Server to start..."
while ! nc -z localhost 8761; do sleep 3; done

echo "Starting Config Server..."
java -jar config-server.jar &

echo "Waiting for Config Server to start..."
while ! nc -z localhost 8089; do sleep 3; done

echo "Starting API Gateway..."
java -jar api-gateway.jar &

echo "Starting Client Management Service..."
java -jar clientmanagement-svc.jar &

echo "Starting JWT Authentication Service..."
java -jar jwt-authentication-svc.jar &

# Keep container running
tail -f /dev/null
