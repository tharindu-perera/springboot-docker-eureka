FROM anapsix/alpine-java:8_jdk
LABEL maintainer="tharindu" \
version="v1"
LABEL support-email="support@mycompany.com" support-phone="(123) 456-7890"
#WORKDIR test
#COPY ./hello.sh .
COPY ./build/libs/gs-spring-boot-docker-initial-0.1.0.jar app.jar
#ENV appName=env-demo
#ARG appName123=arg-demo1
#ADD https://github.com/docker-library/hello-world/raw/master/amd64/hello-world/hello app.jar
#RUN chmod +x hello

CMD java -jar app.jar
#RUN mkdir /myvol
#RUN echo $appName123
#VOLUME /myvol
#RUN ["/bin/sh", "-c", "echo $appName123"]
#CMD ["./hello.sh"]
#CMD echo "How many words are in this echo command"

