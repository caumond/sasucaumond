(ns kotws.pages.home.panel
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]
            [kotws.multi-language :as ml]
            [kotws.subs :as subs]))

;; home

(defn home-panel []
  [re-com/v-box
   :gap "1em"
   :children [[re-com/title
               :level :level1
               :label (ml/get-msg :home-title)]
              [re-com/p
               (ml/get-msg :home-intro)]
              ]])


