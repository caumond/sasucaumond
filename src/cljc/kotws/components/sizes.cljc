(ns kotws.components.sizes)

(defn predefined-seize
  [kw]
  (if (keyword? kw)
    (-> {:small "10em", :middle "20em", :tiny "4em", :big "40em"}
        (get kw "10em"))
    kw))
