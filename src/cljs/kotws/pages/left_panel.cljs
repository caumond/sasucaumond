(ns kotws.pages.left-panel
  (:require [kotws.multi-language :as ml]
            [kotws.pages.left-panel-mgt :refer [close-left-panel]]
            [kotws.subs :as subs]
            [re-frame.core :as rf]
            ))

(def dictionnary
  {:en {:home         "Home"
        :home-comment "My digital life"
        :home-item    "Home"
        :coi-item     "Tech stack"
        :cv-item      "Resume"
        :biblio-item  "Biblio"
        :about-item   "About"
        :contact-item "Contact"
        }
   :fr {:home         "Accueil"
        :home-comment "Ma vie digital"
        :home-item    "Accueil"
        :coi-item     "Centre d'intérêts"
        :cv-item      "CV"
        :biblio-item  "Biblio"
        :about-item   "A propos"
        :contact-item "Contact"
        } })

(defn panel []
  (let [language (rf/subscribe [::subs/language])
        get-msg  (partial (ml/build-translate dictionnary) @language)
        ]
    [:div {:class "w3-container"}
     [:a {:href     "#"
          :on-click close-left-panel
          :class    "close-menu"
          :title    "close menu"}
      [:i {:class "fa fa-remove"}]]
     [:img {:src   "/images/anthony.png"
            :class "avatar"}]
     [:br]
     [:br]
     [:h4 [:b (get-msg :home)]]
     [:p {:class "home-comment"}
      (get-msg :home-comment)]

     [:div {:class "menu w3-bar-block"}
      [:a {:href  "#/" :on-click close-left-panel
           :class "w3-bar-item menu-item"}
       [:i {:class "fa fa-home fa-fw"}] (get-msg :home-item)
       ]

      [:a {:href  "#/coi" :on-click close-left-panel
           :class "w3-bar-item menu-item"}
       [:i {:class "fa fa-bullhorn fa-fw"}] (get-msg :coi-item)
       ]

      [:a {:href  "#/cv" :on-click close-left-panel
           :class "w3-bar-item menu-item"}
       [:i {:class "fa fa-graduation-cap fa-fw"}] (get-msg :cv-item)
       ]

      [:a {:href  "#/biblio" :on-click close-left-panel
           :class "w3-bar-item menu-item"}
       [:i {:class "fa fa-book fa-fw"}] (get-msg :biblio-item)
       ]

      [:a {:href  "#/about", :on-click close-left-panel
           :class "w3-bar-item menu-item"}
       [:i {:class "fa fa-user fa-fw"}] (get-msg :about-item)]
      ]

     [:div {:class "contact-bar"}
      [:a {:target "blank" :href "https://www.linkedin.com/in/anthony-caumond-a365b15/"}
       [:i {:class "fa fa-linkedin w3-hover-opacity"}]]
      [:a {:target "blank" :href "mailto:caumond@gmail.com"}
       [:i {:class "fa fa-envelope-open w3-hover-opacity"}]]
      [:a {:target "blank" :href "https://clojurians.slack.com/team/U018QDQGZ9Q"}
       [:i {:class "fa fa-slack w3-hover-opacity"}]]
      ]])
  )
