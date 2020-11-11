(ns kotws.pages.about.panel
  (:require [re-com.core :as re-com]
            [kotws.multi-language :as ml]))

;; about
(defn about-title []
  [re-com/title
   :label (ml/get-msg :about-message)
   :level :level1])


(defn about-panel []
  [re-com/v-box
   :gap "1em"
   :children [[about-title]
              [re-com/p (ml/get-msg :about-intro)]
              ]])
