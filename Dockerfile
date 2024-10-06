FROM alpine:edge AS base

ENV APP_DIR /usr/share/app

EXPOSE 8080

RUN apk --no-cache add openjdk17-jre=17.0.12_p7-r0 && \
    adduser -D franchise && \
    mkdir -p "$APP_DIR" && \
    chown -R franchise "$APP_DIR"
    
COPY build/libs/*jar $APP_DIR/app.jar

USER franchise

WORKDIR $APP_DIR

ENTRYPOINT ["java","-jar","app.jar"]

HEALTHCHECK CMD curl --fail http://localhost:8080/actuator/health || exit 1