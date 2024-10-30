(ns kotws.components.single "For a elementary property")

(defn translate
  "Returns a map of each `lang` associated to the `items` translated with `tr`"
  [single langs tr]
  (if (keyword single)
    (->> langs
         (mapv (fn [lang] [lang (tr lang single)]))
         flatten
         (apply array-map))
    single))
