FROM caumond:alpine-reframe:latest
COPY . /usr/src/app
WORKDIR /usr/src/app

RUN lein with-profile prod uberjar
CMD java -DPORT=8080 -jar /usr/src/app/target/kotws.jar
# CMD lein dev
