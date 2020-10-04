(ns kotws.pages.header
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]))

(defn header[]
  [re-com/h-box :gap "3em"
   :children [[re-com/box :size "auto" :child [re-com/hyperlink-href :label "Kot website" :href "#/"]]
              [re-com/button :class "flag" :label [:img {:src "images/french.png"}]
               :on-click #(re-frame/dispatch [:change-language :fr])]
              [re-com/button :class "flag" :label [:img {:src "images/english.png"}]
               :on-click #(re-frame/dispatch [:change-language :en])]
              ]])

