(ns kotws.pages.left-panel
  (:require [kotws.multi-language :as ml]
            [kotws.pages.left-panel-mgt :refer [close-left-panel]]
            [kotws.subs :as subs]
            [re-frame.core :as rf]
            ))

(def dictionnary
  {:en {:home "Home"
        :home-comment "My digital life"
        :home-item "HOME"
        :coi-item "C.O.I."
        :cv-item "CV"
        :biblio-item "Biblio"
        :about-item "About"
        :contact-item "Contact"
        }
   :fr {:home "Accueil"
        :home-comment "Ma vie digital"
        :home-item "Accueil"
        :coi-item "Centre d'intérêts"
        :cv-item "CV"
        :biblio-item "Biblio"
        :about-item "A propos"
        :contact-item "Contact"
       } })

(defn panel []
  (let [language (rf/subscribe [::subs/language])
        get-msg (partial (ml/build-translate dictionnary) @language)
        ]
    [:div
     [:br]
     [:div {:class "w3-container"}
      [:a {:href "#", :on-click close-left-panel
           :class "w3-hide-large w3-right w3-jumbo w3-padding w3-hover-grey", :title "close menu"}
       [:i {:class "fa fa-remove"}]]
      [:img {:src "/images/avatar_g2.jpg",  :width "45%" :class "w3-round"}]
      [:br]
      [:br]
      [:h4 [:b (get-msg :home)]]
      [:p {:class "w3-text-grey"} (get-msg :home-comment)]]
     [:div {:class "w3-bar-block"}
      [:a {:href "#/":on-click close-left-panel
           :class "w3-bar-item w3-button w3-padding"}
       [:i {:class "fa fa-home fa-fw w3-margin-right"}] (get-msg :home-item)
       ]

      [:a {:href "#/coi":on-click close-left-panel
           :class "w3-bar-item w3-button w3-padding"}
       [:i {:class "fa fa-bullhorn fa-fw w3-margin-right"}] (get-msg :coi-item)
       ]

      [:a {:href "#/cv" :on-click close-left-panel
           :class "w3-bar-item w3-button w3-padding"}
       [:i {:class "fa fa-graduation-cap fa-fw w3-margin-right"}] (get-msg :cv-item)
       ]

      [:a {:href "#/biblio" :on-click close-left-panel
           :class "w3-bar-item w3-button w3-padding"}
       [:i {:class "fa fa-book fa-fw w3-margin-right"}] (get-msg :biblio-item)
       ]

      [:a {:href "#/about", :on-click close-left-panel
           :class "w3-bar-item w3-button w3-padding"}
       [:i {:class "fa fa-user fa-fw w3-margin-right"}] (get-msg :about-item)]

      [:a {:href "#/contact", :on-click close-left-panel
           :class "w3-bar-item w3-button w3-padding"}
       [:i {:class "fa fa-envelope fa-fw w3-margin-right"}] (get-msg :contact-item)]]

     [:div {:class "w3-center w3-padding-32"}
      [:div {:class "w3-bar" :letter-spacing "2px"}
       [:i {:class "fa fa-facebook-official w3-hover-opacity"}]
       [:i {:class "fa fa-instagram w3-hover-opacity"}]
       [:i {:class "fa fa-snapchat w3-hover-opacity"}]
       [:i {:class "fa fa-pinterest-p w3-hover-opacity"}]
       [:i {:class "fa fa-twitter w3-hover-opacity"}]
       [:i {:class "fa fa-linkedin w3-hover-opacity"}]]]])
  )
