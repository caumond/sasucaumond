(ns kotws.components.v-labelled-image
  "Display an image with predefined images and optional label."
  (:require [kotws.components.sizes :as ksizes]))

(defn- v-labelled-image
  "Display an image with a label.

  * `c` is a class that can be added to the image.
  * `img-url` is where the image is stored
  * `alt` text describing this image.
  * `width-kw` width of the picture
  * `label` text to display below the image.
  * `href` where click will lead to, could be nil"
  [kw c img-url alt width-kw label href]
  (let [width (ksizes/predefined-size width-kw)
        min-width (ksizes/size-minus1 width-kw)]
    [:a {:href href}
     [:div.w3-center (when c {:class c})
      [:img
       {:src img-url,
        :id kw,
        :alt alt,
        :style (assoc (if width-kw
                        {:max-width width, :width "80%", :min-width min-width}
                        {:width "100%"})
                 :pointer-events "none")}] (when label [:p.w3-small label])]]))

(defn labelled-image
  "Display an image with a label.

  * `img-url` is where the image is stored
  * `alt` text describing this image.
  * `width-kw` width of the picture
  * `label` text to display below the image.
  * `href` where click will lead to, could be nil"
  [kw img-url alt width-kw label href]
  (v-labelled-image kw "" img-url alt width-kw label href))

(defn card-image
  "Display an image with a label, rounded with a card.

  * `img-url` is where the image is stored
  * `alt` text describing this image.
  * `width-kw` width of the picture
  * `label` text to display below the image.
  * `href` where click will lead to, could be nil"
  [kw img-url alt width-kw label href]
  (v-labelled-image kw
                    "w3-card-4 w3-container"
                    img-url
                    alt
                    width-kw
                    label
                    href))

(defn raw-image
  "Display a raw image.

  * `img-url` is where the image is stored
  * `alt` text describing this image.
  * `width-kw` width of the picture
  * `label` text to display below the image.
  * `href` where click will lead to, could be nil"
  [kw img-url alt width-kw label href]
  (v-labelled-image kw "w3-container" img-url alt width-kw label href))
