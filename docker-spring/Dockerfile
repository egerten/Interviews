FROM openjdk:8
ADD target/docker-spring-0.0.1-SNAPSHOT.jar docker-spring-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","docker-spring-0.0.1-SNAPSHOT.jar"]

FROM redis
COPY redis.conf /usr/local/etc/redis/redis.conf
CMD [ "redis-server", "/usr/local/etc/redis/redis.conf" ]
EXPOSE 6379