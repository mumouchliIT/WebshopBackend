FROM openjdk:21
EXPOSE 8080
ADD target/updated_mouchli_webshop_dockerhub_image.jar updated_mouchli_webshop_dockerhub_image.jar
ENTRYPOINT ["java", "-jar", "updated_mouchli_webshop_dockerhub_image.jar"]