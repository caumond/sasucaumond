(ns kotws.pages.header
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]))

(defn header[]
  [re-com/h-box :gap "4em"
   :children [
              [re-com/label :class "label-header" :label "Kot website"]
              [re-com/gap :size "1"]
              [re-com/button :class "flag" :label [:img {:src "images/french.png"}]
               :on-click #(re-frame/dispatch [:change-language :fr])]
              [re-com/button :class "flag" :label [:img {:src "images/english.png"}]
               :on-click #(re-frame/dispatch [:change-language :en])]
              ]])


