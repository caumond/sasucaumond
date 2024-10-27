(ns kotws.sub-map
  "Helpers for maps of maps (the inner map is called `sub-map`)")

(defn add-key
  "Each key of the `map-of-map` is added to inner maps under the `kw` keyword, if it was not existing already.."
  [map-of-map kw]
  (->> map-of-map
       (mapv (fn [[k v]] [k (cond-> v (nil? (get v kw)) (assoc kw k))]))
       (into {})))

(defn array-map-add-key
  "Each key of the `map-of-map` is added to inner maps under the `kw` keyword, if it was not existing already..

  This version creates an array-map to preserve the order of the elements."
  [map-of-map kw]
  (->> map-of-map
       (mapv (fn [[k v]] [k (cond-> v (nil? (get v kw)) (assoc kw k))]))
       flatten
       (apply array-map)))

(defn update-submaps
  "Update submaps keyword `kw` with `(kw-val-fn submap args ...)`"
  [map-of-map kw kw-val-fn & args]
  (-> map-of-map
      (update-vals (fn [submap]
                     (cond-> submap
                       (nil? (get submap kw))
                         (assoc kw (apply kw-val-fn submap args)))))))

(defn reference-kw-suffix
  "Update submaps keyword `kw` with the value of `kw-ref` completed `suffix`.

  If not provided the `suffix` parameter is defaulted to `-kw` where kw is the name of `kw`."
  ([mapf-of-map kw kw-ref]
   (reference-kw-suffix mapf-of-map
                        kw
                        kw-ref
                        (apply str
                          (some-> kw
                                  name
                                  (cons ["-"])
                                  reverse))))
  ([map-of-map kw kw-ref suffix]
   (let [kw (if (vector? (vector? kw)) kw [kw])]
     (-> map-of-map
         (update-vals (fn [submap]
                        (cond-> submap
                          (nil? (get-in submap kw)) (assoc-in kw
                                                      (some-> submap
                                                              (get kw-ref)
                                                              name
                                                              (str suffix)
                                                              keyword)))))))))
