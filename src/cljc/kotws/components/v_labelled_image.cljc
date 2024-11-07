(ns kotws.components.v-labelled-image
  "Display an image with predefined images and optional label."
  (:require [kotws.components.sizes :as ksizes]
            [kotws.links :as klinks]))

(defn- v-labelled-image
  "Display an image with a label.

  * `img-link` is where the image is stored
  * `href-link` where click will lead to, could be nil
  * `label` text to display below the image.
  * `width-kw` width of the picture, `:full` is taking the whole width, other are using `predefined-size`
  * `class` is a string that can be added to the image's class. "
  [img-link href-link label width-kw class]
  (let [href-link (if (map? href-link) href-link {})
        width (ksizes/predefined-size width-kw)
        min-width (ksizes/min-size width-kw)]
    [klinks/a href-link
     [:div.w3-center
      [:img.w3-image
       (assoc (klinks/img-meta img-link)
         :class class
         :style (assoc (if (and (some? width-kw) (not= width-kw :full))
                         {:max-width width, :width "80%", :min-width min-width}
                         {:width "100%"})
                  :pointer-events "none"))] (when label [:p.w3-small label])]]))

(defn labelled-image
  "Display an image with a label.

  * `img-link` is where the image is stored
  * `href-link` where click will lead to, could be nil
  * `label` text to display below the image.
  * `width-kw` width of the picture"
  [img-link href-link label width-kw]
  (v-labelled-image img-link href-link label width-kw ""))

(defn labelled-image-circle
  "Display an image with a label.

  * `img-link` is where the image is stored
  * `href-link` where click will lead to, could be nil
  * `label` text to display below the image.
  * `width-kw` width of the picture"
  [img-link href-link label width-kw]
  (v-labelled-image img-link href-link label width-kw "w3-round-xxlarge"))


(defn card-image
  "Display an image with a label, rounded with a card.

  * `img-link` is where the image is stored
  * `width-kw` width of the picture
  * `label` text to display below the image.
  * `href-link` where click will lead to, could be nil"
  [img-link href-link label width-kw]
  (v-labelled-image img-link href-link label width-kw "w3-card-4 w3-container"))

(defn raw-image
  "Display a raw image.

  * `img-link` is where the image is stored
  * `href-link` where click will lead to, could be nil
  * `label` text to display below the image.
  * `width-kw` width of the picture"
  [img-link href-link label width-kw]
  (v-labelled-image img-link href-link label width-kw "w3-container"))

(defn icon-image
  "Display an image to match other icons"
  [img-link href-link]
  (let [href-link (if (map? href-link) href-link {})
        width (ksizes/predefined-size :icon)]
    [klinks/a href-link
     [:img.w3-image
      (assoc (klinks/img-meta img-link)
        :style {:max-width width,
                :width width,
                :min-width width,
                :margin-block-start "1em",
                :margin-block-end "1em",
                :margin-inline-start "0px",
                :margin-inline-end "0px",
                :unicode-bidi "isolate"})]]))
