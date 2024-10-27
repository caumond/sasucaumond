(ns kotws.server
  "Server main entry main entry point."
  (:require [kotws.handler :refer [handler]]
            [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(defn -main
  "The `port` environment variable is could be used to change the port."
  [& _]
  (let [port (Integer/parseInt (or (System/getenv "port") "8080"))]
    (println "start HTTP webserver on port:" port)
    (run-jetty #'handler {:port port, :join? false})))
