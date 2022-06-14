FROM openjdk:8
COPY build/libs/*.jar Main.jar
ENTRYPOINT java -jar Main.jar
