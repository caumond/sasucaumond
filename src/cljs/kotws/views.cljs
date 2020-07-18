(ns kotws.views
  (:require
   [re-frame.core :as re-frame]
   [re-com.core :as re-com]
   [kotws.subs :as subs]
   [kotws.pages.header :refer [header]]
   [kotws.pages.cv :refer [cv-panel]]
   [kotws.pages.home :refer [home-panel]]
   [kotws.pages.about :refer [about-panel]]
   ))

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    :cv [cv-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [re-com/v-box
     :height "100%"
     :children [header
                [panels @active-panel]]]))
