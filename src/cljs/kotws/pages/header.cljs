(ns kotws.pages.header
  (:require
   [kotws.multi-language :as ml]
   [kotws.pages.left-panel-mgt :refer [open-left-panel]]
   [re-frame.core :as rf]
   [kotws.subs :as subs]
   [kotws.events :as events]))

(def dictionnary
  { :en {:home-title "Kot website"}
   :fr {:home-title "Site personnel de kot"}})

(defn header[]
  (let [language (rf/subscribe [::subs/language])
        get-msg (partial (ml/build-translate dictionnary) @language)]
    [:header
     [:button {:on-click open-left-panel}
      [:i {:class "fa fa-bars"}]]

     [:a {:href "#"}
      [:img {:src "/images/avatar_g2.jpg" :class "avatar"}]]

     [:span {:class "header-title"}
      [:b (get-msg :home-title)]]

     [:img {:src "images/french.png"
            :class "lang-bn"
            :on-click #(rf/dispatch [::events/change-language :fr])}]
     [:img {:class "lang-bn"
            :src "images/english.png"
            :on-click #(rf/dispatch [::events/change-language :en])}]
     ])
  )
