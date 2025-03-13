# Etapa 1: Imagem base do OpenJDK
FROM openjdk:17-jdk-slim as build

# Definir o diretório de trabalho
WORKDIR /app

# Copiar os arquivos de build do Maven ou Gradle
COPY target/menu-system.jar app.jar

# Expor a porta em que o Spring Boot estará ouvindo
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
