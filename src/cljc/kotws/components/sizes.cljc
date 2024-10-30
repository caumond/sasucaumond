(ns kotws.components.sizes "Predefined sizes, for graphical components")

(defn predefined-size
  "Turn `kw` into a size in `em`."
  [kw]
  (if (keyword? kw)
    (-> {:small "10em", :middle "20em", :tiny "4em", :big "40em"}
        (get kw "10em"))
    kw))

(defn min-size
  "Minimum size linked to `kw`."
  [kw]
  (if (keyword? kw)
    (-> {:small "4em", :middle "5em", :tiny "3em", :big "20em"}
        (get kw "4em"))
    kw))
