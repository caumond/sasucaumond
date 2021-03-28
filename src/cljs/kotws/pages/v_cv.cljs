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
                        :vision "La création de la vision a consisté à faire émerger le besoin d'une "
                        :raph   "Je suis raph"}
                }
           }
      :en {:cv {:intro "I started IT early, and developed first my Operations Research and then Supply Chain expertise, all along leveraging my IT skills. Now I have deep convictions about industry needs and future, and I would like to express them, being able to focus more on technical skills. I proved my ability to be both disruptive and pragmatic."
                :plm   {:title  "Product owner of an in-house PLM"
                        :first  "Create, sell and materialize the vision"
                        :raph   "I am raph"
                        :vision "This is the vision"}
                }}}))

(def resume-timeline
  [{:icon     "fa-cut"
    :evt-type "timeline__event--type1"
    :date     "20-08-2019"
    :title    :cv.plm/title
    :items    [{:icon      "fa-industry"
                :sub-items [{:text   :cv.plm/first
                             :detail :cv.plm/vision}
                            {:text   :cv.plm/title
                             :detail :cv.plm/raph}]}
               {:icon      "fa-code"
                :sub-items [{:text   :cv.plm/first
                             :detail :cv.plm/vision}]}]
    }
   {:icon     "fa-cut"
    :evt-type "timeline__event--type3"
    :date     "20-08-2020"
    :title    :cv.plm/vision}])

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
     (doall
       (for [resume-item resume-timeline]
         ^{:key resume-item}[:div.timeline__event.animated.fadeInUp.delay-3s {:class (:evt-type resume-item)}
                             [:div.timeline__event__icon
                              [:i.fa {:class (:icon resume-item)}]]

                             [:div.timeline__event__date
                              (:date resume-item)]
                             [:div.timeline__event__content
                              [:div.timeline__event__title
                               (tr [(:title resume-item)])
                               ]
                              [:ul.timeline__event__description.w3-ul
                               (doall
                                 (for [item (:items resume-item)]
                                   ^{:key item}[:li.w3-container
                                                [:i.fa {:class (:icon item)}]
                                                (doall
                                                  (for [sub-item (:sub-items item)]
                                                    ^{:key sub-item}
                                                    (let [detail-id (random-uuid)]
                                                      [:div.desc-item.w3-right
                                                       [:div.cv-button
                                                        (accord/accordionize (str detail-id))
                                                        (tr [(:text sub-item)])]
                                                       [:span.w3-hide {:id (str detail-id)}
                                                        (tr [(:detail sub-item)])]
                                                       ])))]
                                   ))]
                              ]]
         ))]
    ]]
  )
