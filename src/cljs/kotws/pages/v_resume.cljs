(ns kotws.pages.v-resume
  (:require [cljs-time.core :as time]
            [re-frame.core :as rf]
            [kotws.subs :as subs]
            [kotws.events :as events]
            [kotws.ml :as ml]))

;; private
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def tr
  (partial ml/tr
           {:fr {:resume {:title "Curriculum vitae"}
                 :cv {:intro "J'ai démarré l'informatique tôt, au collège. Ma carrière a démarré en 2001, à l'université en tant que doctorant."
                      :plm   {:title         "'Product owner' d'un logiciel de gestion de cycle de vie produit (PLM)"
                              :where         "Michelin"
                              :create-vision "Crée, promeut et met en oeuvre la vision"
                              :vision        "Commencé en 2018 dans une étude d'architecture Entreprise, mon premier rôle sur ce PLM (gestion de cycle de vie produit) a été de construire une vision expliquant le pourquoi et un début de comment, de la communiquer dans les équipes et les `executive`, et de la faire inscrire dans les plans d'investissement. Puis, en tant que product owner et chef projet, j'ai cherché des premiers clients permettant.
 monté l'équipe et matéralisé la vision en cherchant une approche répondant à la fois aux ambitions des utilisateurs du site et de nos ambitions longs termes. Mon rôle a été particulièrement important dans la conception de cette application, et des mécanismes de gestion de configuration en particulier."
                              }
                      }
                 }
            :en {:resume {:title "Resume"}
                 :cv {:intro "I started IT early, and developed first my Operations Research and then Supply Chain expertise, all along leveraging my IT skills. Now I have deep convictions about industry needs and future, and I would like to express them, being able to focus more on technical skills. I proved my ability to be both disruptive and pragmatic."
                      :plm   {:title         "Product owner of an in-house PLM"
                              :where         "Michelin"
                              :create-vision "Create, sell and materialize the vision"
                              :vision        "This is the vision"}
                      }}}))

(def resume-timeline
  [{:icon     "fa-clipboard"
    :evt-type "timeline__event--type1"
    :date     "2021"
    :title    :cv.plm/title
    :where    :cv.plm/where
    :items    [{:icon      "fa-industry"
                :sub-items [{:text   :cv.plm/create-vision
                             :detail :cv.plm/vision}
                            {:text   :cv.plm/title
                             :detail :cv.plm/raph}]}
               {:icon      "fa-code"
                :sub-items [{:text   :cv.plm/create-vision
                             :detail :cv.plm/vision}]}
               ]
    }
   {:icon     "fa-cut"
    :evt-type "timeline__event--type3"
    :date     "20-08-2020"
    :title    :cv.plm/title
    :where    :cv.plm/where}
   ])

(defn years-of-experience []
  (-
   (time/year (time/now))
   2001)
  )

;; public
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn resume-panel []
  [:<>
   [:a {:href "docs/caumond-resume.pdf" :target "blank"}[:i.fa.fa-download.w3-margin.w3-right]]
   [:h1 (tr [:resume/title])]
   [:p (tr [:cv/intro])]

   [:div.timeline
    (doall
     (for [resume-item resume-timeline]
       ^{:key resume-item}
       [:div.timeline__event.animated.fadeInUp.delay-1s {:class (:evt-type resume-item)}
        [:div.timeline__event__icon
         [:i.fa {:class (:icon resume-item)}]]

        [:div.timeline__event__date
         (:date resume-item)]
        [:div.timeline__event__content
         [:div.timeline__event__title
          (tr [(:title resume-item)])]
         [:p.w3-right (tr [(:where resume-item)])]
         [:hr.round]
         [:ul.timeline__event__description.w3-ul
          (doall
           (for [item (:items resume-item)]
             ^{:key item}
             [:li.w3-row
              [:i.w3-col.fa {:style {:width "40px"} :class (:icon item)}]
              [:div.w3-rest
               (doall
                (for [sub-item (:sub-items item)]
                  (let [selected-items (rf/subscribe [::subs/selected-items])
                        text-id (:text sub-item)
                        detailed-text (get @selected-items text-id)]
                    ^{:key text-id}
                    [:div {:on-click #(rf/dispatch [::events/selected-items
                                                    text-id
                                                    (:detail sub-item)])
                           :style{:display "block"}}
                     [:i.fa.fa-angle-down.w3-left {:class (when-not detailed-text "w3-hide")}]
                     [:i.fa.fa-angle-right.w3-left {:class (when detailed-text "w3-hide")}]
                     [:div.cv-button
                      (tr [text-id]) ]
                     [:div.detailed-item
                      {:class (when-not detailed-text "w3-hide")}
                      (tr [(get @selected-items text-id)])
                      ]]
                    )))]]
             ))]
         ]]
       ))]
   ]
  )
