# Etapa 1: Build da aplicação
FROM gradle:8.11.1-jdk21 AS builder

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos de configuração do Gradle e o código fonte
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle ./gradle
COPY src ./src

# Permissão de execução para o script gradlew
RUN chmod +x ./gradlew

# Realiza o build da aplicação
RUN ./gradlew clean build -x test -x detekt

# Etapa 2: Criação da imagem final
FROM eclipse-temurin:21-jdk

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado na etapa de build
COPY --from=builder /app/build/libs/*.jar app.jar

# Expõe a porta que a aplicação utiliza
EXPOSE 8080

# Define o comando de entrada para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]