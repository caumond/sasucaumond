(ns kotws.views
  (:require
   [re-frame.core :as re-frame]
   [re-com.core :as re-com]
   [kotws.subs :as subs]
   [kotws.pages.home-panel :refer [home-panel]]
   ))



;; blog-1
(defn blog-cc-clojure-panel []
  [re-com/v-box
   :gap "1em"
   :children [[re-com/p "lein new re-frame kotws --force +10x +cider +handler +re-com +re-pressed +routes +test"]
              ]])

;; about
(defn about-title []
  [re-com/title
   :label "This is the About Page."
   :level :level1])

(defn link-to-home-page []
  [re-com/hyperlink-href
   :label "go to Home Page"
   :href "#/"])

(defn about-panel []
  [re-com/v-box
   :gap "1em"
   :children [[about-title]
              [link-to-home-page]]])


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
