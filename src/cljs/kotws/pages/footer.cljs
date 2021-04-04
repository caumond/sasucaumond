(ns kotws.pages.footer
  (:require [kotws.ml :as ml]
            [breaking-point.core :as bp]
            [re-frame.core :as rf]))

(def tr (partial ml/tr
                 {:en {:copyright "Copyright"
                       :rights-assertion "All rights reserved"}
                  :fr {:copyright "Copyright"
                       :rights-assertion "Tous droits réservés"}}
                 ))

(defn footer []
  (let [small-monitor? (rf/subscribe [::bp/small-screen?])]
    [:div#footer {:style (when @small-monitor? {:left "0px"})}
     (tr [:copyright])
     " "
     [:span {:dangerouslySetInnerHTML {:__html "&copy;"}}]
     " 2020 Caumond - " (tr [:rights-assertion])])
  )
