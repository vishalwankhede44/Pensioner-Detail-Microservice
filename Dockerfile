FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8000
ADD target/*jar app.jar
ADD src/main/resources/data.csv data.csv
ENTRYPOINT ["java","-jar","/app.jar"]