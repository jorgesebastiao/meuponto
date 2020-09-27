FROM alpine:edge
MAINTAINER jorgenes1@hotmail.com
RUN apk add --no-cache openjdk11
ARG JAR_FILE=meuponto-distribution/build/libs/*.jar
COPY ${JAR_FILE} /tmp/meuponto-distribution.jar
WORKDIR /tmp
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/tmp/meuponto-distribution.jar"]
EXPOSE 8080