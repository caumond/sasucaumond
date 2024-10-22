(ns kotws.server
  "Server main entry main entry point."
  (:require [kotws.handler :refer [handler]]
            [config.core :refer [env]]
            [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(defn -main
  "The `port` environment variable is could be used to change the port."
  []
  (let [env-port (get env :port 3000)]
    (run-jetty #'handler
               {:port (if (int? env-port) env-port (Integer/parseInt env-port)),
                :join? false})))
