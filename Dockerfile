# Usa una imagen oficial de Java para construir y correr el JAR
FROM openjdk:17-jdk-slim

# Crea un directorio para la app
WORKDIR /app

# Copia el JAR que genera Spring Boot
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expón el puerto de la aplicación
EXPOSE 8080

# Comando para correr el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
