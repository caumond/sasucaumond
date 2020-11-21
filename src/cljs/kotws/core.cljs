(ns kotws.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as rf]
   [re-pressed.core :as rp]
   [kotws.events :as events]
   [kotws.routes :as routes]
   [kotws.views :as views]
   [kotws.config :as config]
   [kotws.pages.footer :as footer]
   [kotws.pages.header :as header]
   [kotws.pages.overlay :as overlay]
   [kotws.pages.left-panel :as left-panel]
   ))

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (rf/clear-subscription-cache!)
  (let [views-el (.getElementById js/document "views")
        left-panel-el (.getElementById js/document "left-panel")
        overlay-el (.getElementById js/document "overlay")
        header-el (.getElementById js/document "header")
        footer-el (.getElementById js/document "footer")]
    (rdom/unmount-component-at-node views-el)
    (rdom/render [views/panel] views-el)

    (rdom/unmount-component-at-node left-panel-el)
    (rdom/render [left-panel/panel] left-panel-el)

    (rdom/unmount-component-at-node overlay-el)
    (rdom/render [overlay/panel] overlay-el)

    (rdom/unmount-component-at-node header-el)
    (rdom/render [header/header] header-el)

    (rdom/unmount-component-at-node footer-el)
    (rdom/render [footer/footer] footer-el)
    ))

(defn init []
  (routes/app-routes)
  (rf/dispatch-sync [::events/initialize-db])
  (rf/dispatch-sync [::rp/add-keyboard-event-listener "keydown"])
  (dev-setup)
  (mount-root))
