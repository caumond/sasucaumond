(ns kotws.server
  (:require [kotws.handler :refer [handler]]
            [config.core :refer [env]]
            [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

 (defn -main [& _args]
   (let [env-port (env :port)
         port (if (int? env-port)
                env-port
                (Integer/parseInt (or env-port "3000"))
                )]
     (run-jetty handler {:port port :join? false})))
