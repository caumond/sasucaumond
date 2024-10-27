(ns kotws.language
  "Multi language."
  (:require [clojure.string :as str]))

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

(defn- wellformed-kw
  "Turns `n` into a wellformed keyword (lower case with space replaced with -). `suffix` could be added at the end if given."
  ([n]
   (some-> n
           name
           str/lower-case
           (str/replace #" " "-")
           keyword))
  ([n suffix]
   (some-> n
           name
           str/lower-case
           (str "-" (name suffix))
           (str/replace #" " "-")
           keyword)))

(defn default-and-translate
  "For all items in `items` and all keys in `kws`,

   If the key is already present it is not updated, otherwise it is replaced with"
  [items kws tr]
  (->> kws
       (reduce (fn [items kw]
                 (->> items
                      (mapv (fn [[name item]] [name
                                               (-> item
                                                   (update kw
                                                           #(if (nil? %)
                                                              (-> name
                                                                  (wellformed-kw
                                                                    kw)
                                                                  tr)
                                                              (tr %))))]))))
         (mapv (fn [[k v]] [k
                            (assoc v
                              :name k
                              :tag (wellformed-kw k))])
           items))
       (mapv second)))

(defn urls
  "Each `kw` in `kws` is added ot all items.

  * If `kw` is a string, it is not modified,
  * If `kw` is a kw it is translated with its value in `url` map
  * If `kw` is `nil`, the name is reused."
  [items kws url]
  (reduce (fn [items kw]
            (->> items
                 (mapv (fn [[name item]]
                         (let [kw-val (get item kw)
                               translated
                                 (if (keyword? kw-val) (url kw-val) (url name))]
                           [name
                            (if (or (nil? translated) (string? kw-val))
                              item
                              (cond-> item
                                (or (nil? kw-val) (keyword? kw-val))
                                  (assoc kw translated)))])))))
    items
    kws))

(comment
  (urls [[:downstream-ope {:img-url "images/framing.png", :href "zaz"}]]
        [:href]
        {:xx "xxx-str"})
  ;
)
