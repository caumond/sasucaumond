FROM clojure:tools-deps

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY deps.edn /usr/src/app/
RUN clj -X:deps prep
COPY . /usr/src/app
EXPOSE 8080
CMD clj -X:prod
