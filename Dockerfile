FROM openjdk:11.0.4-jre-slim
RUN adduser --system --group steve
USER steve:steve
COPY target/phoneService-0.0.1-SNAPSHOT.jar phone-service.jar
ENTRYPOINT ["java","-jar","/phone-service.jar"]