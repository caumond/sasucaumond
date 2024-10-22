(ns kotws.app-view.footer
  "Footer of all pages."
  (:require [kotws.multi-language :as ml]
            [kotws.components.labelled-image :as klabelled-image]))

(defn tr
  [k]
  (-> {:copyright {:en "Copyright", :fr "Copyright"},
       :powered-by {:en "Powered by", :fr "Propulsé par"},
       :see-on-gh {:en "See on Github", :fr "Voir sur Github"},
       :rights-assertion {:en "All rights reserved",
                          :fr "Tous droits réservés"}}
      (ml/tr* k)))

(defn current-year
  []
  (-> (js/Date.)
      .getFullYear))

(defn v-footer
  "Footer's view."
  []
  [:<>
   [:div.secondary-bg.w3-display-container.secondary-text
    {:style {:height "10em"}}
    [:a {:href "https://gitlab.com/caumond/caumond-resume", :target "blank"}
     [:div.w3-right
      [klabelled-image/raw-image "images/gh.jpeg" "Github" :tiny
       "See on github"]]]
    [:div.w3-display-bottommiddle.w3-padding-32.w3-center
     [:div (tr :copyright) (str " © " (current-year) " Caumond - ")
      (tr :rights-assertion)]
     [:div (tr :powered-by) " "
      [:a {:href "https://www.w3schools.com/w3css/default.asp"} "w3.css"]]]]])

(defn footer [] (v-footer))
