(ns kotws.handler
  (:require
   [compojure.core :refer [GET defroutes]]
   [compojure.route :refer [resources]]
   [ring.util.response :refer [resource-response]]
   [ring.middleware.reload :refer [wrap-reload]]
   [selmer.parser :as selm]
   [shadow.http.push-state :as push-state]))

(defroutes routes
  (GET "/" [req] (selm/render (resource-response "XXindex2.html" {:root "public"})
                              {:language "XX"}
                              ))
  (resources "/"))

(def dev-handler (-> #'routes wrap-reload push-state/handle))

(def handler routes)
