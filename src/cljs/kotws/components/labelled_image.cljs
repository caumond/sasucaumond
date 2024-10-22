(ns kotws.components.labelled-image
  "Display an image with predefined images and optional label.")

(defn- predefined-seize
  [kw]
  (if (keyword? kw)
    (-> {:small "10em", :middle "20em", :tiny "4em", :big "40em"}
        (get kw "10em"))
    kw))

(defn- v-labelled-image
  "Display an image with a label.

  * `c` is a class that can be added to the image.
  * `img-url` is where the image is stored
  * `alt` text describing this image.
  * `width-kw` width of the picture
  * `label` text to display below the image."
  [c img-url alt width-kw label]
  (let [width-kw (predefined-seize width-kw)]
    [:div.w3-center (when c {:class c})
     [:img
      {:src img-url,
       :alt alt,
       :style (assoc (if width-kw
                       {:max-width width-kw, :width "80%"}
                       {:width "100%"})
                :pointer-events "none")}] (when label [:p.w3-small label])]))

(defn labelled-image
  [img-url alt width-kw label]
  (v-labelled-image "" img-url alt width-kw label))

(defn card-image
  [img-url alt width-kw label]
  (v-labelled-image "w3-card-4 w3-container" img-url alt width-kw label))

(defn raw-image
  [img-url alt width-kw label]
  (v-labelled-image "w3-container" img-url alt width-kw label))
