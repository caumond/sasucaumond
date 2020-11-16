(ns kotws.pages.overlay
  (:require [kotws.pages.left-panel-mgt :refer [close-left-panel]]))

(defn panel []
  [:div {
         :on-click close-left-panel
         :cursor "pointer" :title "close side menu"} ])
