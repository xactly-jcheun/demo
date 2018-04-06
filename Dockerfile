FROM openjdk:8-jre-alpine

ARG artifactId
ARG version
ARG packaging

ENV JAR ${artifactId}-${version}.${packaging}

RUN addgroup -g 26049 Xactly && \
    adduser -D -u 20022 -G Xactly xactly && \
    mkdir /usr/local/xactly && \
    chown xactly:Xactly /usr/local/xactly

USER xactly

WORKDIR /usr/local/xactly

COPY target/${JAR} ${JAR}

EXPOSE 8080 8081

CMD java -Xmx128m -Xss256k -jar -Dspring.profiles.active=default ${JAR}
