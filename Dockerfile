FROM clojure:lein-alpine

RUN apk --no-cache add --update git
RUN apk --no-cache add --update nodejs npm

COPY . /usr/src/app
WORKDIR /usr/src/app

RUN lein with-profile prod uberjar
CMD java -DPORT=8080 -jar /usr/src/app/target/kotws-0.1.0-SNAPSHOT-standalone.jar
# CMD lein dev
