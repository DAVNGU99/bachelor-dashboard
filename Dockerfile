# ---------- build stage ----------
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy Maven wrapper + pom first for caching
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Download deps (cached layer)
RUN ./mvnw -q -DskipTests dependency:go-offline

# Copy source and build
COPY src/ src/
RUN ./mvnw -DskipTests package

# ---------- runtime stage ----------
FROM eclipse-temurin:21-jre
WORKDIR /app

# Render runs as root-less sometimes; this is generally fine either way.
COPY --from=build /app/target/*.jar /app/app.jar

# Render provides PORT env var; Spring will use it via application.properties
EXPOSE 8080

# Helpful defaults (optional)
ENV JAVA_OPTS="-XX:MaxRAMPercentage=75.0"

CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
