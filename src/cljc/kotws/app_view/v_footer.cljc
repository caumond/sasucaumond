(ns kotws.app-view.v-footer
  (:require [kotws.components.v-labelled-image :as kvlabelled-image]
            [kotws.links :as klinks]
            [kotws.lang :as klang]))

(def dic
  {:copyright {:en "Copyright", :fr "Copyright"},
   :powered-by {:en "Powered by", :fr "Propulsé par"},
   :see-on-gh {:en "See the code", :fr "Voir le code"},
   :rights-assertion {:en "All rights reserved", :fr "Tous droits réservés"}})

(def tr (partial klang/tr dic))

(defn v-footer
  [l year size]
  (let [tr (partial tr l)]
    [:footer.w3-row.secondary-bg.w3-display-container.secondary-text.adaptative.w3-center
     {:style {:height size, :min-height "10em"}}
     [:div.w3-right
      [kvlabelled-image/raw-image (klinks/image-link :git-hub)
       (klinks/external-link :sasu-caumond) (tr :see-on-gh) :small]]
     [:div.w3-display-bottommiddle
      [:div (tr :copyright) (str " © " year " Caumond - ")
       (tr :rights-assertion)] [:div " "]
      [:div (tr :powered-by) " "
       [klinks/a klinks/external-links :w3-css "w3.css"]]]]))
