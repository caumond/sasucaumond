(ns kotws.routes
  (:require [reitit.frontend :as rfe]
            [kotws.events :as ke]
            [re-frame.core :as rf]
            [reitit.frontend.easy :as rfe-ez]))

(defn on-navigate
  "Called when the uri is modified by browser integeration."
  [match _history]
  (rf/dispatch-sync [::ke/set-active-panel
                     (-> match
                         (get-in [:data :name]))]))

(defn setup!
  []
  (-> [["/" :home-panel] ["/biblio" :biblio-panel]
       ["/blog-cc-clojure" :blog-cc-clojure] ["/tech-stack" :tech-stack-panel]
       ["/vision" :vision-panel] ["/founder" :founder-panel]
       ["/developper" :developper-panel] ["/or" :or-panel] ["/sc" :sc]
       ["/about" :about-panel]]
      rfe/router
      (rfe-ez/start! on-navigate {})))
