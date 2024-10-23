(ns kotws.components.v-description-card
  "Cards describing elements."
  (:require [kotws.components.v-labelled-image :as kvlabelled-image]))

(defn c-card
  [title sub-title img-url detail]
  [:div.w3-card-4 [:header.w3-container.w3-light-grey [:h3 title]]
   [:div.w3-container.w3-white [:p sub-title] [:hr]
    [kvlabelled-image/labelled-image img-url "Avatar" :small nil nil]
    [:p detail]]])

(defn c-cards
  "Displays cards for each element in `name-img-href-desc`,

  Each element should be a map with `name`, `img`, `short`, `href`, `desc`"
  [name-img-href-desc]
  (-> [:div.w3-row-padding.w3-section]
      (concat (->> name-img-href-desc
                   (mapv (fn [{:keys [name img short href desc]}]
                           [:div.w3-margin-top.w3-half
                            [:a {:href href, :target "blank"}
                             [c-card name short img desc]]]))))
      vec))
