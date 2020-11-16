(ns kotws.pages.left-panel
  (:require [kotws.multi-language :as ml]
            [kotws.pages.left-panel-mgt :refer [close-left-panel]]
            ))

(defn panel []
  [:div
   [:br]
   [:div {:class "w3-container"}
    [:a {:href "#", :on-click close-left-panel
         :class "w3-hide-large w3-right w3-jumbo w3-padding w3-hover-grey", :title "close menu"}
     [:i {:class "fa fa-remove"}]]
    [:img {:src "/images/avatar_g2.jpg",  :width "45%" :class "w3-round"}]
    [:br]
    [:br]
    [:h4 [:b (ml/get-msg :home-title)]]
    [:p {:class "w3-text-grey"} "Personal digital life"]]
   [:div {:class "w3-bar-block"}
    [:a {:href "#/":on-click close-left-panel
         :class "w3-bar-item w3-button w3-padding"}
     [:i {:class "fa fa-home fa-fw w3-margin-right"}] "HOME"
     ]

    [:a {:href "#/coi":on-click close-left-panel
         :class "w3-bar-item w3-button w3-padding"}
     [:i {:class "fa fa-bullhorn fa-fw w3-margin-right"}] "C.O.I."
     ]

    [:a {:href "#/cv" :on-click close-left-panel
         :class "w3-bar-item w3-button w3-padding"}
     [:i {:class "fa fa-graduation-cap fa-fw w3-margin-right"}] "C.V."
     ]

    [:a {:href "#/biblio" :on-click close-left-panel
         :class "w3-bar-item w3-button w3-padding"}
     [:i {:class "fa fa-book fa-fw w3-margin-right"}] "Biblio"
     ]

    [:a {:href "#/about", :on-click close-left-panel
         :class "w3-bar-item w3-button w3-padding"}
     [:i {:class "fa fa-user fa-fw w3-margin-right"}] (ml/get-msg :about)]

    [:a {:href "#/contact", :on-click close-left-panel
         :class "w3-bar-item w3-button w3-padding"}
     [:i {:class "fa fa-envelope fa-fw w3-margin-right"}]"CONTACT"]]

   [:div {:class "w3-center w3-padding-32"}
    [:div {:class "w3-bar" :letter-spacing "2px"}
     [:i {:class "fa fa-facebook-official w3-hover-opacity"}]
     [:i {:class "fa fa-instagram w3-hover-opacity"}]
     [:i {:class "fa fa-snapchat w3-hover-opacity"}]
     [:i {:class "fa fa-pinterest-p w3-hover-opacity"}]
     [:i {:class "fa fa-twitter w3-hover-opacity"}]
     [:i {:class "fa fa-linkedin w3-hover-opacity"}]]]]
  )
