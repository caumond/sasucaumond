(ns kotws.views
  (:require
   [re-frame.core :as re-frame]
   [re-com.core :as re-com]
   [kotws.subs :as subs]
   [kotws.pages.home-panel :refer [home-panel]]
   [kotws.pages.about-panel :refer [about-panel]]
   [kotws.pages.blog-cc-clojure-panel :refer [blog-cc-clojure-panel]]
   ))

;; main
(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    :blog-cc-clojure-panel [blog-cc-clojure-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [re-com/v-box
     :height "100%"
     :children [[panels @active-panel]]]))
