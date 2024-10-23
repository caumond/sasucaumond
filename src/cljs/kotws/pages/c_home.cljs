(ns kotws.pages.c-home
  (:require [kotws.fe-language :as kfe-lang]
            [kotws.multi-language :as ml]
            [kotws.pages.v-home :as kvhome]
            [kotws.components.v-headered-list :as kvheadered-list]
            [kotws.components.v-labelled-image :as vclabelled-image]))

(defn tr
  [k]
  (-> kvhome/dic
      (kfe-lang/tr k)))

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
                               [vclabelled-image/labelled-image url (tr :it) w
                                (tr kw) href]]))))
         vec)
     [:div.w3-center
      [vclabelled-image/labelled-image "images/home/hephaistox_logo.png"
       (tr :it) w (tr :founder) "#/founder"]] [:hr] [:h1 "Details:"]
     [kvheadered-list/detailed-list (data)]]))
