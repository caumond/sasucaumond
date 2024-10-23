(ns kotws.multi-language
  "Multi language."
  (:require [clojure.string :as str]))

(defn possible-langs [] [:en :fr])

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

;;TODO To remove
(defn defaulting
  "Defaulting the next keys (meaning they're not modified if they already exist)"
  [items]
  (->> items
       (mapv (fn [{:keys [desc long-desc name], :as d}]
               (let [k (wellformed-kw name)
                     kd (wellformed-kw name "-desc")]
                 (cond-> d
                   k (assoc :kw k)
                   (and (some? k) (nil? desc)) (assoc :desc k)
                   (and (some? kd) (nil? long-desc)) (assoc :long-desc kd)))))))

;;TODO To remove
(defn translate-keys
  "Helper to call `tr` on all keys set in `kws`."
  [items kws tr]
  (->> kws
       (reduce (fn [items kw]
                 (->> items
                      (mapv #(update % kw tr))))
         items)))

(defn default-and-translate
  "For all items in `items` and all keys in `kws`,

   If the key is already present it is not updated, otherwise it is replaced with"
  [items kws tr]
  (->> kws
       (reduce (fn [items kw]
                 (->> items
                      (mapv (fn [[name item]]
                              (println "xx->" name "-" item)
                              [name
                               (-> item
                                   (update kw
                                           #(if (nil? %)
                                              (-> name
                                                  (wellformed-kw kw)
                                                  tr)
                                              (tr %))))]))))
         (mapv (fn [[k v]] [k (assoc v :name k)]) items))
       (mapv second)))
