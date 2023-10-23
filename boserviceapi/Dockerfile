FROM amazoncorretto:11-alpine

RUN apk add --update ttf-dejavu && rm -rf /var/cache/apk/*
RUN apk --no-cache add msttcorefonts-installer fontconfig && \
    update-ms-fonts && \
    fc-cache -f

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","/application.jar"]