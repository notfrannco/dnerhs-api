FROM registrynexus.lab.data.com.py/maven:3.8.1-openjdk-8-slim as build-step
WORKDIR /app
COPY . /app
RUN mvn clean package install -DskipTests

FROM registrynexus.lab.data.com.py/openjdk:8u302-slim
COPY --from=build-step /app/target/dnerhs-api-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","dnerhs-api-0.0.1-SNAPSHOT.jar"]
