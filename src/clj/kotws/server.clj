(ns kotws.server
  "Server main entry main entry point."
  (:require [kotws.handler :refer [handler]]
            [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(defn -main
  "The `port` environment variable is could be used to change the port."
  []
  (run-jetty #'handler {:port 8080, :join? false}))
