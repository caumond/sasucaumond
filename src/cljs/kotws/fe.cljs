(ns kotws.fe
  (:require [reagent.dom :as rdom]
            [re-frame.core :as rf]
            [kotws.events :as events]
            [kotws.routes :as routes]
            [kotws.app-view :as app-view]
            [kotws.config :as config]))

(defn- dev-warning
  "Warn in console if the dev mode setup?"
  []
  (when config/debug? (println "dev mode")))

(defn mount-root
  []
  (rf/clear-subscription-cache!)
  (let [app-el (.getElementById js/document "app-view")
        header-el (.getElementById js/document "header")
        footer-el (.getElementById js/document "footer")]
    (rdom/unmount-component-at-node app-el)
    (rdom/unmount-component-at-node header-el)
    (rdom/unmount-component-at-node footer-el)
    (rdom/render [app-view/header-el] header-el)
    (rdom/render [app-view/panel-el] app-el)
    (rdom/render [app-view/footer-el] footer-el)))

(defn- update-page [] (routes/setup!) (dev-warning) (mount-root))

(defn refresh-page [] (println "Shadow refresh") (update-page))

(defn init
  []
  (println "Init shadow")
  ;; Initialization should be done before `routes/setup!` so current `url`
  ;; can be turned into current route.
  (rf/dispatch-sync [::events/initialize-db])
  (update-page))
