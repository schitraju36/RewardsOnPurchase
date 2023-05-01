FROM java8:10-jdk-alpine

COPY /target/RewardsOnPurchase-0.0.1-SNAPSHOT.jar /app

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "RewardsOnPurchase-0.0.1-SNAPSHOT.jar"]