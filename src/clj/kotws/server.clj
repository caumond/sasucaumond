(ns kotws.server
  "Server main entry main entry point."
  (:require [kotws.handler :refer [handler]]
            [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(defn -main
  "The `port` environment variable is could be used to change the port."
  [{:keys [port], :or {port 8080}}]
  (let [port (Integer/parseInt port)]
    (run-jetty #'handler {:port port, :join? false})))
