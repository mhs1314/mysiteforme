FROM frolvlad/alpine-oraclejdk8:slim
VOLUME ["/tmp/bs80/data"]
ADD target/demo-0.0.1-SNAPSHOT.jar app.jar
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=dev"]
EXPOSE 9092