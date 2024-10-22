(ns kotws.pages.v-home
  (:require [kotws.multi-language :as ml]
            [kotws.components.headered-list :as kheadered-list]
            [kotws.components.labelled-image :as klabelled-image]))

(defn tr
  [k]
  (ml/tr*
    {:home-msg {:en "Resume", :fr "Curriculum vitae"},
     :home-intro
       {:en "My resume is organized with three main skills:",
        :fr
          "Mon cv est organisé autour de trois compétences. Voyez ma carrière à travers chacun de ses axes et comment ils se rejoignent quand je fonde `Hephaistox`."},
     :founder {:en "Founder", :fr "Fondateur"},
     :it {:en "Computing", :fr "Informatique"},
     :maths {:en "Mathematics", :fr "Mathématiques"},
     :sc {:en "Supply chain", :fr "Chaîne logistique"}}
    k))

(defn data
  []
  (-> [{:name "TBD",
        :img-url "images/tech_stack/clojure.png",
        :href "https://clojure.org"}]
      ml/defaulting
      (ml/translate-keys [:description :short :long-desc] tr)))

(defn home-panel
  []
  (let [w "10em"]
    [:div [:h1 (tr :home-msg)] [:p (tr :home-intro)] [:hr]
     (-> [:div.w3-cell-row]
         (concat (->> [["images/home/it.png" :it "#/developper"]
                       ["images/home/sc.png" :sc "#/sc"]
                       ["images/home/math.png" :maths "#/or"]]
                      (mapv (fn [[url kw href]]
                              [:div.w3-cell.w3-mobile
                               [:a {:href href}
                                (klabelled-image/labelled-image url
                                                                (tr :it)
                                                                w
                                                                (tr kw))]]))))
         vec)
     [:a {:href "#/founder"}
      [:div.w3-center
       (klabelled-image/labelled-image "images/home/hephaistox_logo.png"
                                       (tr :it)
                                       w
                                       (tr :founder))]] [:hr] [:h1 "Details:"]
     [kheadered-list/detailed-list (data)]]))
