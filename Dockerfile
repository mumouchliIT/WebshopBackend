FROM openjdk:8
EXPOSE 8080
ADD target/webshop_image.jar webshop_image.jar
ENTRYPOINT["java", "-jar", "/webshop_image.jar"]