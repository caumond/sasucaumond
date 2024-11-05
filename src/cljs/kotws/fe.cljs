(ns kotws.fe
  (:require [reagent.dom :as rdom]
            [re-frame.core :as rf]
            [kotws.events :as events]
            [kotws.routes :as routes]
            [kotws.app-view :refer [c-header-el c-footer-el c-panel-el]]
            [kotws.config :as config]))

(defn- dev-warning
  "Warn in console if the dev mode setup?"
  []
  (when config/debug? (js/console.log "dev mode")))

(defn mount-root
  []
  (rf/clear-subscription-cache!)
  (let [app-el (.getElementById js/document "app-view")
        header-el (.getElementById js/document "header")
        footer-el (.getElementById js/document "footer")]
    (rdom/unmount-component-at-node app-el)
    (rdom/unmount-component-at-node header-el)
    (rdom/unmount-component-at-node footer-el)
    (rdom/render [c-header-el] header-el)
    (rdom/render [c-panel-el] app-el)
    (rdom/render [c-footer-el] footer-el)))

(defn- update-page [] (routes/setup!) (dev-warning) (mount-root))

(defn refresh-page [] (js/console.log "Shadow refresh") (update-page))

(defn init
  []
  (js/console.log "Init frontend")
  ;; DB initialization should be done before `routes/setup!` so current
  ;; `url` can be turned into current route.
  (rf/dispatch-sync [::events/initialize-db])
  (update-page))
