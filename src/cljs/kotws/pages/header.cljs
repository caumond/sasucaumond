(ns kotws.pages.header
  (:require [re-frame.core :as rf]
            [breaking-point.core :as bp]
            [kotws.subs :as subs]
            [kotws.events :as events]))

(defn header[]
  (let [small-monitor? (rf/subscribe [::bp/small-screen?])
        display-menu-bns? (if @small-monitor? "block" "none")
        language (rf/subscribe [::subs/language])]
    [:div#header
     [:button {:class "menu-bn"
               :on-click #(rf/dispatch [::events/open-left-panel])
               :style {:display display-menu-bns?}}
      [:i {:class "fa fa-bars"}]]

     [:a {:href "#" :style {:display display-menu-bns?}}
      [:img {:src "/images/anthony.png" :class "avatar"}]]

     [:a {:class    "lang-bn"
          :on-click #(rf/dispatch [::events/change-language :fr])
          :style {:text-decoration (when (= :fr @language) "underline")}
          }
      "fr"
      ]
     [:a {:class    "lang-bn"
          :on-click #(rf/dispatch [::events/change-language :en])
          :style {:text-decoration (when (= :en @language) "underline")}}
      "en"]
     ])
  )
