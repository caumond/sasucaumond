(ns kotws.components.sizes "Predefined sizes, mostly for graphical components")

(defn predefined-size
  [kw]
  (if (keyword? kw)
    (-> {:small "10em", :middle "20em", :tiny "4em", :big "40em"}
        (get kw "10em"))
    kw))

(defn size-minus1
  [kw]
  (if (keyword? kw)
    (-> {:small "4em", :middle "5em", :tiny "3em", :big "20em"}
        (get kw "4em"))
    kw))
