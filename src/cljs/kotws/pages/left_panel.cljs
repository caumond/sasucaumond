(ns kotws.pages.left-panel
  (:require [kotws.pages.left-panel-mgt :refer [closeable-link]]
            [kotws.ml :as ml]))

(def tr (partial ml/tr
           {:en {:home           "Home"
                 :home-comment   "My digital life"
                 :home-item      "Home"
                 :techstack-item "Tech stack"
                 :cv-item        "Resume"
                 :biblio-item    "Biblio"
                 :about-item     "About"
                 :vision-item    "Vision"
                 :contact-item   "Contact"
                 }
            :fr {:home           "Accueil"
                 :home-comment   "Ma vie digital"
                 :home-item      "Accueil"
                 :techstack-item "Centre d'intérêts"
                 :cv-item        "CV"
                 :biblio-item    "Biblio"
                 :about-item     "A propos"
                 :vision-item    "Vision"
                 :contact-item   "Contact"
                 }}))


(def left-menu-entries
  [{:icon "fa-home" :text :home-item :link "#/"}
   {:icon "fa-graduation-cap" :text :cv-item :link "#/resume"}
   {:icon "fa-eye" :text :vision-item :link "#/vision"}
   {:icon "fa-bullhorn" :text :techstack-item :link "#/tech-stack"}
   {:icon "fa-book" :text :biblio-item :link "#/biblio"}
   {:icon "fa-user" :text :about-item :link "#/about"}
   ])

(defn panel []
  [:div.w3-container.w3-center

   [:p [:a.close-button closeable-link
        [:i.fa.fa-remove]]]

   [:img.avatar {:src "/images/anthony.png" } ]

   [:p.home-comment
    (tr [:home-comment])]

   [:hr.rounded]
   [:div.menu.w3-bar-block
    (doall
      (for [menu left-menu-entries]
        ^{:key menu} [:a.w3-bar-item.menu-item (merge closeable-link {:href (:link menu)})
                      [:i {:class (str "fa " (:icon menu) " fa-fw")}]
                      (tr [(:text menu)])]))

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
