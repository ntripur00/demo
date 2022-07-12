# FROM gradle:6.3-jdk8-alpine AS build
# COPY --chown=gradle:gradle . /home/gradle/src
# WORKDIR /home/gradle/src
# RUN gradle build --no-daemon
#
# FROM openjdk-jre:11
# EXPOSE 8090:8090
#
# RUN mkdir /app
#
# COPY --from=build /home/gradle/src/build/libs/*.jar /app/demo.jar
#
# ENTRYPOINT ["java", "-XX:+UnlockEx5.perimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/demo.jar"]


FROM openjdk:11
EXPOSE 8090:8090

RUN mkdir /app
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/demo.jar"]
