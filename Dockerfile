FROM ztdev/java:1.8

ARG commit

LABEL maintainer="zhaotian"
LABEL commmit=${commit}
LABEL name={{project.build.finalName}}

WORKDIR /project

ADD {{project.build.finalName}}.tar.gz ./

WORKDIR {{project.build.finalName}}

EXPOSE {{server.port}}

# ARG JAVA_OPTS
# ENV JAVA_OPTS=$JAVA_OPTS

ENTRYPOINT [ "java", "-jar", "lib/{{project.build.finalName}}.{{project.packaging}}" ]
# ENTRYPOINT [ "bin/start.sh" ]