(ns kotws.pages.left-panel (:require [kotws.events :as events]
                                     [re-frame.core :as rf]
                                     [breaking-point.core :as bp]
                                     [kotws.subs :as subs]
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
                 :gitlab "See on gitlab"
                 }
            :fr {:home           "Accueil"
                 :home-comment   "Ma vie digital"
                 :home-item      "Accueil"
                 :techstack-item "Stack technique"
                 :cv-item        "CV"
                 :biblio-item    "Biblio"
                 :about-item     "A propos"
                 :vision-item    "Vision"
                 :contact-item   "Contact"
                 :gitlab "Voir sur gitlab"
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
  (let [small-monitor? (rf/subscribe [::bp/small-screen?])
        show-left-panel? (rf/subscribe [::subs/show-left-panel])
        display-menu? (if (or (not @small-monitor?)
                              (and @small-monitor? @show-left-panel?))
                        "block"
                        "none")
        display-menu-close? (if @show-left-panel?
                              "block"
                              "none")]
    [:div#left-panel {:style {:display display-menu?}}
     [:span [:a.close-button
             {:on-click #(rf/dispatch [::events/close-left-panel])
              :style {:display display-menu-close?}
              }
             [:i.fa.fa-remove]]]
     [:img.avatar {:src "/images/anthony.png"}]
     [:p.home-comment
      (tr [:home-comment])]

     [:hr.rounded]
     [:div.menu.w3-bar-block
      (doall
       (for [menu left-menu-entries]
         ^{:key menu} [:a.w3-bar-item.menu-item {:href (:link menu) :on-click #(rf/dispatch [::events/close-left-panel])}
                       [:i {:class (str "fa " (:icon menu) " fa-fw")}]
                       (tr [(:text menu)])]))]

     [:div.contact-bar
      [:a {:target "blank" :href "https://www.linkedin.com/in/anthony-caumond-a365b15/"}
       [:i.fa.fa-linkedin.w3-hover-opacity]]
      [:a {:target "blank" :href "mailto:caumond@gmail.com"}
       [:i.fa.fa-envelope-open.w3-hover-opacity]]
      [:a {:target "blank" :href "https://clojurians.slack.com/team/U018QDQGZ9Q"}
       [:i.fa.fa-slack.w3-hover-opacity]]
      [:a {:target "blank" :href "https://gitlab.com/caumond"}
       [:i.fa.fa-gitlab.w3-hover-opacity]]
      [:a {:target "blank" :href "https://github.com/caumond"}
       [:i.fa.fa-github.w3-hover-opacity]]
      ]
     [:a {:href "https://gitlab.com/caumond/kot-ws" :target "blank"} [:div.git (tr [:gitlab])]]
     ]))
