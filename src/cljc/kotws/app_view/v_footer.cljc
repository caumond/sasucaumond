(ns kotws.app-view.v-footer
  (:require [kotws.components.v-labelled-image :as kvlabelled-image]
            [kotws.language :as klang]))

(def dic
  {:copyright {:en "Copyright", :fr "Copyright"},
   :powered-by {:en "Powered by", :fr "Propulsé par"},
   :see-on-gh {:en "See on Github", :fr "Voir sur Github"},
   :rights-assertion {:en "All rights reserved", :fr "Tous droits réservés"}})

(defn v-footer
  [l year]
  (let [tr (partial klang/tr dic l)]
    [:<>
     [:div.secondary-bg.w3-display-container.secondary-text
      {:style {:height "10em"}}
      [:div.w3-right
       [kvlabelled-image/raw-image nil "images/gh.jpeg" "Github" :tiny
        "See on github" "https://github.com/caumond/sasucaumond"]]
      [:div.w3-display-bottommiddle.w3-padding-32.w3-center
       [:div (tr :copyright) (str " © " year " Caumond - ")
        (tr :rights-assertion)]
       [:div (tr :powered-by) " "
        [:a {:href "https://www.w3schools.com/w3css/default.asp"}
         "w3.css"]]]]]))
