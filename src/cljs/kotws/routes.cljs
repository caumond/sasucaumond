(ns kotws.routes
  (:import [goog History]
           [goog.history EventType])
  (:require
   [secretary.core :as secretary :refer-macros [defroute]]
   [goog.events :as gevents]
   [re-frame.core :as re-frame]
   [re-pressed.core :as rp]
   [kotws.events :as events]
   ))

(defn hook-browser-navigation! []
  (doto (History.)
    (gevents/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn app-routes []
  (secretary/set-config! :prefix "#")
  ;; --------------------
  ;; define routes here
  (defroute "/" []
    (re-frame/dispatch [::events/set-active-panel :home-panel])
    (re-frame/dispatch [::events/set-re-pressed-example nil])
    (re-frame/dispatch [::rp/set-keydown-rules
                        {:event-keys [[[::events/set-re-pressed-example "Hello, world!"]
                                       [{:keyCode 72} ;; h
                                        {:keyCode 69} ;; e
                                        {:keyCode 76} ;; l
                                        {:keyCode 76} ;; l
                                        {:keyCode 79} ;; o
                                        ]]]
                         :clear-keys
                         [[{:keyCode 27} ;; escape
                           ]]}])
    )

  (defroute "/about" []
    (re-frame/dispatch [::events/set-active-panel :about-panel]))

  (defroute "/biblio" []
    (re-frame/dispatch [::events/set-active-panel :biblio-panel]))

  (defroute "/blog-cc-clojure" []
    (re-frame/dispatch [::events/set-active-panel :blog-cc-clojure]))

  (defroute "/coi" []
    (re-frame/dispatch [::events/set-active-panel :coi]))

  (defroute "/cv" []
    (re-frame/dispatch [::events/set-active-panel :cv]))

  (defroute "/connect" []
    (re-frame/dispatch [::events/set-active-panel :connection-panel]))

  (defroute "/vision" []
    (re-frame/dispatch [::events/set-active-panel :vision-panel]))

  (defroute "/biblio-details-ddd" []
    (re-frame/dispatch [::events/set-active-panel :biblio-details-ddd]))

  (defroute "*" []
    (re-frame/dispatch [::events/set-active-panel :unknown-route]))
  ;; --------------------
  (hook-browser-navigation!))
