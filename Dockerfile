FROM ztdev/java:1.8

LABEL maintainer="zhaotian"

WORKDIR /project

ADD @project.build.finalName@.tar.gz ./

WORKDIR ${project.build.finalName}

EXPOSE 8081

# ARG JAVA_OPTS
# ENV JAVA_OPTS=$JAVA_OPTS

# ENTRYPOINT [ "/bin/sh" "-c", "java", "${JAVA_OPTS}", "-jar", "boot2-demo-0.0.1-SNAPSHOT.jar" ]
ENTRYPOINT [ "bin/start.sh" ]