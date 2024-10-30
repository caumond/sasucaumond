(ns kotws.components.items
  "Various helpers to feed components."
  (:require [kotws.sub-map :as ksubmap]
            [clojure.string :as str]))

(defn str-to-kw
  "Turns the string `s` into a wellformed keyword (lower case with space replaced with -). `suffix` could be added at the end if given."
  ([s]
   (some-> s
           name
           str/lower-case
           (str/replace #" " "-")
           keyword))
  ([s suffix]
   (some-> s
           name
           str/lower-case
           (str "-" (name suffix))
           (str/replace #" " "-")
           keyword)))

(defn default-name
  "Defaulting `:name` key in item map to the name of the `item`.

  `items` is a map which values are map."
  [items]
  (ksubmap/array-map-add-key items :name))

(defn default-with-kw
  ([items target-kw src-kw]
   (ksubmap/reference-kw-suffix items target-kw src-kw))
  ([items target-kw src-kw suffix]
   (ksubmap/reference-kw-suffix items target-kw src-kw suffix)))

(defn default-with-kws
  [items defaultings]
  (reduce (fn [items defaulting]
            (if (keyword? defaulting)
              (default-with-kw items defaulting :name)
              (let [[target-kw src-kw suffix] defaulting]
                (default-with-kw items
                                 target-kw
                                 (if (nil? src-kw) :name src-kw)
                                 suffix))))
    items
    defaultings))

(defn apply-dic
  "Use `dic` as a dictionnary to translate all values matching keys `kws` in submaps of `items`.

  `dic` is a function that expects a `keyword` parameter, and return the translated value. If the parameter is not a keyword, it is left unmodified."
  [items kws dic]
  (->> kws
       (reduce (fn [items kw]
                 (update-vals items
                              (fn [item]
                                (let [kw-val (get item kw)]
                                  (cond-> item
                                    (keyword? kw-val) (assoc kw
                                                        (if (or (map? dic)
                                                                (fn? dic))
                                                          (dic kw-val)
                                                          kw-val)))))))
         items)))

(defn translate
  "Returns a map of each `lang` associated to the `items` translated with `tr`"
  [items kws langs tr]
  (->> langs
       (mapv (fn [lang] [lang (apply-dic items kws (partial tr lang))]))
       flatten
       (apply array-map)))
