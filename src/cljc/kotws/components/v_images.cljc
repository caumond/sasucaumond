(ns kotws.components.v-images
  "Show image cells than are mobile compliant."
  (:require [kotws.components.items :as kcitems]
            [kotws.components.v-labelled-image :as vclabelled-image]))

(defn defaulting
  "Add default values for all items.

  * `label` is the name displayed below the image.
  * `href` where to point
  * `img-link` the source of the image.

  `href-dic` `image-dic` are dictionary where translation are made."
  [items href-dic image-dic]
  (-> items
      kcitems/default-name
      (kcitems/default-with-kws [:label [:href :name ""] [:img-link :name ""]])
      (kcitems/apply-dic [:href] href-dic)
      (kcitems/apply-dic [:img-link] image-dic)))

(def defaulting* (memoize defaulting))

(defn image-cells
  [items tr w]
  (reduce (fn [hiccup {:keys [img-link name href]}]
            (conj hiccup
                  [:div.w3-cell.w3-mobile
                   [vclabelled-image/labelled-image img-link href (tr name)
                    w]]))
    [:div.w3-cell-row]
    (vals items)))
