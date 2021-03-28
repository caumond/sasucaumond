(ns kotws.pages.v-cv
  (:require [cljs-time.core :as time]
            [kotws.utils.accordion :as accord]
            [kotws.ml :as ml]))
;; Reference to https://codepen.io/hunzaboy/pen/qBWRBXw

;; private
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def tr
  (partial ml/tr
     {:fr {:cv {:intro "J'ai démarré l'informatique tôt, au collège. Ma carrière a démarré en 2001, à l'université en tant que doctorant."
                :plm   {:title  "'Product owner' d'un logiciel de gestion de cycle de vie produit (PLM)"
                        :first  "Crée, promeut et met en oeuvre la vision"
                        :vision "La création de la vision a consisté à faire émerger le besoin d'une "}
                }
           }
      :en {:cv {:intro "I started IT early, and developed first my Operations Research and then Supply Chain expertise, all along leveraging my IT skills. Now I have deep convictions about industry needs and future, and I would like to express them, being able to focus more on technical skills. I proved my ability to be both disruptive and pragmatic."
                :plm   {:title  "Product owner of an in-house PLM"
                        :first  "Create, sell and materialize the vision"
                        :vision "This is the vision"}
                }}}))

(def resume-timeline
  [{:icon     "fa-cut"
    :evt-type 1
    :date     "20-08-2019"
    :title    :cv.plm/title}
   {:icon     "fa-cut"
    :evt-type 2
    :date     "20-08-2019"
    :title    :cv.plm/title}])

(defn years-of-experience []
  (-
    (time/year (time/now))
    2001)
  )
;; public
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn cv-panel []
  [:div
   [:div#cv
    [:p (tr [:cv/intro])]

    [:div.timeline
     [:div.timeline__event.timeline__event--type1.animated.fadeInUp.delay-3s
      [:div.timeline__event__icon
       [:i.fa.fa-cut]]

      [:div.timeline__event__date
       "20-08-2019"]
      [:div.timeline__event__content
       [:div.timeline__event__title
        (tr [:cv.plm/title])
        ]
       [:ul.timeline__event__description.w3-ul
        [:li.w3-container
         [:i.fa.fa-industry]
         [:div.desc-item.w3-right
          [:div.cv-button
           (accord/accordionize "plm-create-vision")
           (tr [:cv.plm/first])]
          [:span#plm-create-vision.w3-hide
           (tr [:cv.plm.vision])]
          ]
         [:div.desc-item.w3-right
          [:div.cv-button
           (accord/accordionize "plm-create-vision2")
           (tr [:cv.plm/first])]
          [:span#plm-create-vision2.w3-hide
           (tr [:cv.plm.vision])]
          ]
         ]]
       ]]

     [:div.timeline__event.animated.fadeInUp.delay-3s.timeline__event--type2
      [:div.timeline__event__icon
       [:i.fa.fa-header]]

      [:div.timeline__event__date
       "20-08-2019"]
      [:div.timeline__event__content
       [:div.timeline__event__title
        "Birthday"
        ]
       [:div.timeline__event__description
        [:p "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Vel, nam! Nam eveniet ut aliquam ab asperiores, accusamus iure veniam corporis incidunt reprehenderit accusantium id aut architecto harum quidem dolorem in!"]]
       ]]
     ]

    ]]
  )
