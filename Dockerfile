FROM openjdk:21
EXPOSE 8080
ADD target/mouchli_webshop_dockerhub_image.jar mouchli_webshop_dockerhub_image.jar
ENTRYPOINT ["java", "-jar", "/mouchli_webshop_dockerhub_image.jar"]