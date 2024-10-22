(ns kotws.core
  (:require [kotws.server :refer [-main]]
            [cider.nrepl :refer (cider-nrepl-handler)]
            [nrepl.server :refer [start-server stop-server]]))

(def port 8000)

(defonce server (start-server :port port :handler cider-nrepl-handler))

(comment
  (stop-server server)
  ;
)

(defn start [& _args] (println "REPL started on port " port) (-main))
