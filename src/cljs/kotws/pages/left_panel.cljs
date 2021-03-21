(ns kotws.pages.left-panel
  (:require [kotws.pages.left-panel-mgt :refer [closeable]]
            [kotws.ml :as ml]))

(def tr (partial ml/tr
           {:en {:home         "Home"
                 :home-comment "My digital life"
                 :home-item    "Home"
                 :coi-item     "Tech stack"
                 :cv-item      "Resume"
                 :biblio-item  "Biblio"
                 :about-item   "About"
                 :vision-item  "Vision"
                 :contact-item "Contact"
                 }
            :fr {:home         "Accueil"
                 :home-comment "Ma vie digital"
                 :home-item    "Accueil"
                 :coi-item     "Centre d'intérêts"
                 :cv-item      "CV"
                 :biblio-item  "Biblio"
                 :about-item   "A propos"
                 :vision-item  "Vision"
                 :contact-item "Contact"
                 }}))


(def left-menu-entries
  [{:icon :fa-home :text :home-item}])

(defn panel []
  [:div.w3-container
   [:a.close-button closeable
    [:i.fa.fa-remove]]

   [:img.avatar {:src "/images/anthony.png"}]

   [:h4 (tr [:home])]
   [:p.home-comment
    (tr [:home-comment])]

   (for [menu left-menu-entries]
     [:div.menu
      [:a {:on-click closeable}
       [:i {:class (:icon menu)}
        (tr [(:text menu)])]]])

   [:div.menu.w3-bar-block
    [:a.w3-bar-item.menu-item {:on-click closeable}
     [:i.fa.fa-home.fa-fw] (tr [:home-item])]

    [:a {:href  "#/coi" :on-click closeable
         :class "w3-bar-item menu-item"}
     [:i {:class "fa fa-bullhorn fa-fw"}] (tr [:coi-item])
     ]

    [:a {:href  "#/cv" :on-click closeable
         :class "w3-bar-item menu-item"}
     [:i {:class "fa fa-graduation-cap fa-fw"}] (tr [:cv-item])
     ]

    [:a {:href  "#/vision" :on-click closeable
         :class "w3-bar-item menu-item"}
     [:i {:class "fa fa-eye fa-fw"}] (tr [:vision-item])
     ]

    [:a {:href  "#/biblio" :on-click closeable
         :class "w3-bar-item menu-item"}
     [:i {:class "fa fa-book fa-fw"}] (tr [:biblio-item])
     ]

    [:a {:href  "#/about", :on-click closeable
         :class "w3-bar-item menu-item"}
     [:i {:class "fa fa-user fa-fw"}] (tr [:about-item])]
    ]

   [:div.contact-bar
    [:a {:target "blank" :href "https://www.linkedin.com/in/anthony-caumond-a365b15/"}
     [:i.fa.fa-linkedin.w3-hover-opacity]]
    [:a {:target "blank" :href "mailto:caumond@gmail.com"}
     [:i.fa.fa-envelope-open.w3-hover-opacity]]
    [:a {:target "blank" :href "https://clojurians.slack.com/team/U018QDQGZ9Q"}
     [:i.fa.fa-slack.w3-hover-opacity]]
    ]]
  )
