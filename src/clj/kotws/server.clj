(ns kotws.server
  (:require [kotws.handler :refer [handler]]
            [config.core :refer [env]]
            [taoensso.tempura :as tempura]
            [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(defn wrap-i18n [handler]
  (tempura/wrap-ring-request handler {:tr-opts {}}))

 (defn -main [& _args]
   (let [env-port (env :port)
         port (if (int? env-port)
                env-port
                (Integer/parseInt (or env-port "3000")))]
     (run-jetty (wrap-i18n handler) {:port port :join? false})))
