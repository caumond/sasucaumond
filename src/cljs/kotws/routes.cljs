(ns kotws.routes
  "Frontend routing"
  (:require [reitit.frontend :as rfe]
            [kotws.events :as ke]
            [re-frame.core :as rf]
            [kotws.pages :as kpages]
            [reitit.frontend.easy :as rfe-ez]))

(defn on-navigate
  "Called when the uri is modified by browser integeration."
  [match _history]
  (rf/dispatch-sync [::ke/set-active-panel
                     (-> match
                         (get-in [:data :name]))]))

(defn setup!
  []
  (-> (mapv (juxt :uri :name) (vals kpages/pages))
      rfe/router
      (rfe-ez/start! on-navigate {})))
