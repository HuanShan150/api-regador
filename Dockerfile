# Etapa de build
FROM openjdk:17-jdk-slim AS build

# Definir variável de ambiente para desabilitar o Gradle Daemon
ENV GRADLE_OPTS="-Dorg.gradle.daemon=false"

WORKDIR /home/app

# Copiar arquivos necessários
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Dar permissão de execução ao gradlew
RUN chmod +x ./gradlew

# Garantir que estamos usando a versão correta do Gradle
RUN ./gradlew wrapper --gradle-version=7.5 --distribution-type=bin

# Construir o aplicativo
RUN ./gradlew clean build -x test --no-daemon

# Etapa final
FROM openjdk:17-jdk-slim

WORKDIR /home/app

# Copiar o JAR compilado da etapa de build
COPY --from=build /home/app/build/libs/*.jar app.jar

# Expor a porta (ajuste se necessário)
EXPOSE 8080

# Executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
