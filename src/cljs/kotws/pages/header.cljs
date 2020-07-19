(ns kotws.pages.header
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]))

(defn header[]
  [re-com/h-box :gap "3em"
   :children [[re-com/box :size "auto" :child [re-com/hyperlink-href :label "Kot website" :href "#/"]]
              [re-com/button :label [:img {:src "images/french.png" :id "flag"}]
               :on-click #(re-frame/dispatch [:change-language :fr])]
              [re-com/button :label [:img {:src "images/english.png" :id "flag"}]
               :on-click #(re-frame/dispatch [:change-language :en])]
              [re-com/hyperlink-href :label "Home" :href "#/"]
              [re-com/hyperlink-href :label "Blog" :href "#/blog-cc-clojure"]
              [re-com/hyperlink-href :label "COI" :href "#/coi"]
              [re-com/hyperlink-href :label "CV" :href "#/cv"]
              [re-com/hyperlink-href :label "Biblio" :href "#/biblio"]
              [re-com/hyperlink-href :label "About" :href "#/about"]
              ]])
