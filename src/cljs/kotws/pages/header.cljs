(ns kotws.pages.header
  (:require
   [kotws.multi-language :as ml]
   [kotws.pages.left-panel-mgt :refer [open-left-panel]]
   [re-frame.core :as rf]
   [kotws.events :as events]))

(defn header[]
  [:header {:id "portfolio"}
   [:span {:class "w3-button w3-left w3-hide-large w3-xxlarge w3-hover-text-grey",
           :on-click open-left-panel
           }
    [:i {:class "fa fa-bars"}]]

   [:a {:href "#"}
    [:img {:src "/images/avatar_g2.jpg", :width "40px"
           :class "w3-circle w3-left w3-margin w3-hide-large w3-hover-opacity"}]]

   [:span {:class "header-title"}
    [:b (ml/get-msg :home-title)]]

   [:div {:class "w3-container w3-right"}
    [:img {:src "images/french.png"
           :class "w3-circle w3-right w3-margin w3-hover-opacity"
           :on-click #(rf/dispatch [::events/change-language :fr])
           :width "40px"}]
    [:img {:src "images/english.png"
           :class "w3-circle w3-right w3-margin w3-hover-opacity"
           :on-click #(rf/dispatch [::events/change-language :en])
           :width "40px"}]
    ]
   ]
  )
