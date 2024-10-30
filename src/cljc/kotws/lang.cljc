(ns kotws.lang
  "Multi language."
  (:require [clojure.string :as str]
            [kotws.sub-map :as ksubmap]))

(def languages
  {:en {:label {:fr "Anglais", :en "English"}},
   :fr {:label {:fr "Français", :en "French"}, :default true}})

(def possible-langs (set (keys languages)))

(def default-lang
  (->> languages
       (filter (comp :default second))
       ffirst))

(defn tr
  "Translate the key `k` based on `dic` entries and langauge `l`.

  The `default` is used if not found, otherwise the key itself is shown (translated to string if is a keyword)."
  ([dic l k] (tr dic l k (if (keyword? k) (name k) k)))
  ([dic l k default] (get-in dic [k l] default)))

;;TODO Remove
(defn- str-to-kw
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

(defn ^:deprecated default-name
  "Add default name if missing

  `items` is a map which values are a map where `:name` key will be added."
  [items]
  (ksubmap/add-key items :name))

(defn ^:deprecated translate-lang
  "For each `item`, the `kw` keyword is added with its translation

  `tr` is expecting one parameter only, the `kw` to translate.

  * If `kw` is a string, it is not modified,
  * If `kw` is a kw it is translated with its value in `tr` map
  * If `kw` is `nil`, the concatenation `name-kw` is translated with its value in `tr` map."
  [items kws tr]
  (->>
    kws
    (reduce (fn [items kw]
              (update-vals
                items
                (fn [{:keys [name], :as item}]
                  (let [kw-val (get item kw)]
                    (if (string? kw-val)
                      item
                      (let [k (if (keyword? kw-val) kw-val (str-to-kw name kw))]
                        (cond-> item (keyword? k) (assoc kw (tr k)))))))))
      items)))

(defn ^:deprecated translate-langs
  "For each `item`, the `kw` keyword is added

  `tr` is expecting twos parameters, the `lang` and the `kw` to translate.

  * If `kw` is a string, it is not modified,
  * If `kw` is a kw it is translated with its value in `tr` map
  * If `kw` is `nil`, the name is translated with its value in `tr` map."
  [items kws langs tr]
  (->> langs
       (mapv (fn [lang] [lang (translate-lang items kws (partial tr lang))]))
       (into {})))

(defn ^:deprecated urls
  "For each `item`, the `kw` keyword url is added

  * If `kw` is a `string` it is not modified,
  * If `kw` is a `keyword` it is translated with its value in `url` map
  * If `kw` is `nil`, the name is translated with its value in `url` map."
  [items kws url]
  (->> kws
       (reduce (fn [items kw]
                 (update-vals items
                              (fn [{:keys [name], :as item}]
                                (let [kw-val (get item kw)]
                                  (if (string? kw-val)
                                    item
                                    (let [k (if (keyword? kw-val) kw-val name)]
                                      (cond-> item
                                        (keyword? k) (assoc kw (url k)))))))))
         items)))
