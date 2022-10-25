FROM debian:stable-slim

ENV DEBIAN_FRONTEND=noninteractive

ARG LOCAL_ENTRY_POINT=./docker/entrypoint.sh
ENV ENTRY_POINT=./entrypoint.sh
ARG LOCAL_JAR_FILE=./target/cruddemo-0.0.1-SNAPSHOT.jar
ARG JAR_FILE=./cruddemo-0.0.1-SNAPSHOT.jar

RUN mkdir -p /usr/share/man/man1 /usr/share/man/man2

RUN apt-get update && \
apt-get install -y --no-install-recommends \
        openjdk-17-jre

RUN java --version

COPY ${LOCAL_JAR_FILE} ${JAR_FILE}
COPY ${LOCAL_ENTRY_POINT} ${ENTRY_POINT}

RUN chmod +x ${ENTRY_POINT}

ENTRYPOINT ${ENTRY_POINT}

