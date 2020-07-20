(ns kotws.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [re-pressed.core :as rp]
   [kotws.events :as events]
   [kotws.routes :as routes]
   [kotws.views :as views]
   [kotws.config :as config]
   [kotws.pages.footer :as footer]
   [kotws.pages.header :as header]
   [kotws.pages.left-panel :as left-panel]
   ))

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")
        left-panel-el (.getElementById js/document "left-panel")
        header-el (.getElementById js/document "header")
        footer-el (.getElementById js/document "footer")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel] root-el)

    (rdom/unmount-component-at-node left-panel-el)
    (rdom/render [left-panel/panel] left-panel-el)
    
    (rdom/unmount-component-at-node header-el)
    (rdom/render [header/header] header-el)

    (rdom/unmount-component-at-node footer-el)
    (rdom/render [footer/footer] footer-el)
    ))

(defn init []
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (re-frame/dispatch-sync [::rp/add-keyboard-event-listener "keydown"])
  (dev-setup)
  (mount-root))
