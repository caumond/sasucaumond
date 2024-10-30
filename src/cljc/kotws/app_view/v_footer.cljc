(ns kotws.app-view.v-footer
  (:require [kotws.components.v-labelled-image :as kvlabelled-image]
            [kotws.links :as klinks]
            [kotws.components.sizes :as ksizes]
            [kotws.lang :as klang]))

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
      {:style {:height (ksizes/predefined-size :small)}}
      [:div.w3-right
       [kvlabelled-image/raw-image (klinks/image-link :git-hub)
        (klinks/external-link :sasu-caumond) (tr :see-on-gh) :tiny]]
      [:div.w3-display-bottommiddle.w3-padding-32.w3-center
       [:div (tr :copyright) (str " © " year " Caumond - ")
        (tr :rights-assertion)] [:hr]
       [:div (tr :powered-by) " "
        [:a {:href (:w3-css klinks/external-links)} "w3.css"]]]]]))
