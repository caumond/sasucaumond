(ns kotws.pages.about-panel
  (:require [re-com.core :as re-com]))

;; about
(defn about-title []
  [re-com/title
   :label "This is the About Pag !!"
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
