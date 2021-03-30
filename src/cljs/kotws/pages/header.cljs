(ns kotws.pages.header
  (:require
   [kotws.pages.left-panel-mgt :refer [open-left-panel]]
   [re-frame.core :as rf]
   [kotws.events :as events]))

(def dictionnary
  { :en {}
   :fr  {}})

(defn header[]
  [:header
   [:button {:class "menu-bn" :on-click open-left-panel}
    [:i {:class "fa fa-bars"}]]

   [:a {:href "#"}
    [:img {:src "/images/anthony.png" :class "avatar"}]]

   [:a {:class    "lang-bn"
        :on-click #(rf/dispatch [::events/change-language :fr])}
    "fr"
    ]
   [:a {:class    "lang-bn"
        :on-click #(rf/dispatch [::events/change-language :en])}
    "en"]
   ]
  )
