(ns kotws.core
  (:require [kotws.server :refer [-main]]
            [cider.nrepl :refer (cider-nrepl-handler)]
            [nrepl.server :refer [start-server stop-server]]))

(def port 8000)

(defn repl-server [port] (start-server :port port :handler cider-nrepl-handler))

(defn start
  [& _args]
  (println "REPL started on port " port)
  (def server (repl-server port))
  (-main))

(comment
  (stop-server server)
  ;
)
