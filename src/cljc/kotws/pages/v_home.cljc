(ns kotws.pages.v-home
  (:require [kotws.multi-language :as kmulti-language]
            [kotws.components.v-labelled-image :as vclabelled-image]))

(def dic
  {:home-msg {:en "Resume", :fr "Curriculum vitae"},
   :home-intro
     {:en "My resume is organized with three main skills:",
      :fr
        "Mon cv est organisé autour de trois compétences. Voyez ma carrière à travers chacun de ses axes et comment ils se rejoignent quand je fonde `Hephaistox`."},
   :founder {:en "Founder", :fr "Fondateur"},
   :it {:en "Computing", :fr "Informatique"},
   :maths {:en "Mathematics", :fr "Mathématiques"},
   :sc {:en "Supply chain", :fr "Chaîne logistique"}})

(defn v-home
  [l]
  (let [tr (partial kmulti-language/tr dic l)
        w "10em"]
    [:div [:h1 (tr :home-msg)] [:p (tr :home-intro)] [:hr]
     (-> [:div.w3-cell-row]
         (concat (->> [["images/home/it.png" :it "#/developper"]
                       ["images/home/sc.png" :sc "#/sc"]
                       ["images/home/math.png" :maths "#/or"]]
                      (mapv (fn [[url kw href]]
                              [:div.w3-cell.w3-mobile
                               [vclabelled-image/labelled-image url (tr :it) w
                                (tr kw) href]]))))
         vec)
     [:div.w3-center
      [vclabelled-image/labelled-image "images/home/hephaistox_logo.png"
       (tr :it) w (tr :home) "#/home"]] [:hr]]))
