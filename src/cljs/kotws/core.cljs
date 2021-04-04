(ns kotws.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as rf]
   [kotws.events :as events]
   [kotws.routes :as routes]
   [kotws.views :as views]
   [kotws.config :as config]
   [breaking-point.core :as bp]
   ))

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (rf/clear-subscription-cache!)
  (let [app-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node app-el)
    (rdom/render [views/panel] app-el)
    ))

(defn init []
  (routes/app-routes)
  (rf/dispatch-sync [::events/initialize-db])
  (rf/dispatch-sync [::bp/set-breakpoints
                           {;; required
                            :breakpoints [ :small-screen
                                          640
                                          :large-screen]
                            ;; optional
                            :debounce-ms 166
                            }])
  (dev-setup)
  (mount-root)
  )
