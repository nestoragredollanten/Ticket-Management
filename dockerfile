# Etapa de construcción
FROM gradle:7.6-jdk17 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar los archivos build.gradle y el código fuente a la imagen
COPY build.gradle settings.gradle ./
COPY src ./src

# Construir el archivo JAR de la aplicación utilizando Gradle
RUN gradle clean build -x test

# Etapa de ejecución
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR desde la etapa de construcción
COPY --from=build /app/build/libs/Ticket-Management-0.0.1-SNAPSHOT.jar /app/app.jar

# Exponer el puerto en el que la aplicación escuchará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]