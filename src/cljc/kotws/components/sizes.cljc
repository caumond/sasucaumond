(ns kotws.components.sizes "Predefined sizes, for graphical components")

(defn predefined-size
  "Turn `kw` into a size in `em`."
  [kw]
  (if (keyword? kw)
    (-> {:small "10em", :medium "20em", :tiny "4em", :big "40em", :icon "1em"}
        (get kw "10em"))
    kw))

(defn min-size
  "Minimum size linked to `kw`."
  [kw]
  (if (keyword? kw)
    (-> {:small "4em", :medium "5em", :tiny "3em", :big "20em", :icon "0.8em"}
        (get kw "4em"))
    kw))
