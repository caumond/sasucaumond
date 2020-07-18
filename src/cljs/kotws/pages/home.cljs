(ns kotws.pages.home
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [kotws.subs :as subs]
            ))

(defn home-title []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [re-com/title
      :label (str "Hello from " @name )
      :level :level1]
     [:p ".This is a marvelous Home Page!!."]]))

(defn link-to-about-page []
  [re-com/hyperlink-href
   :label "go to About Page--"
   :href "#/about"])

(defn home-panel []
  [re-com/v-box
   :gap "1em"
   :children [[home-title]
              [link-to-about-page]
              ]])
