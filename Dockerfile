FROM openjdk:17
ADD target/*.jar api_e_commerce.jar
ENTRYPOINT ["java","-jar","api_e_commerce.jar"]