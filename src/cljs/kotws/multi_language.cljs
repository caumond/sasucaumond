(ns kotws.multi-language
  "Multi language."
  (:require [kotws.subs :as subs]
            [re-frame.core :as rf]
            [clojure.string :as str]))

(def dictionary-registry
  {:en {:missing "Missing english translation"},
   :fr {:missing "Manque la traduction française"}})

(defn tr*
  ([dic k] (tr* dic k nil))
  ([dic k default]
   (get-in (merge-with merge dic dictionary-registry)
           [k @(rf/subscribe [::subs/language])]
           default)))

(defn- change-name
  "Turns `n` into a wellformed keyword"
  ([n] (change-name n nil))
  ([n suffix]
   (some-> n
           str/lower-case
           (str suffix)
           (str/replace #" " "-")
           keyword)))

(defn defaulting
  [data]
  (->> data
       (mapv (fn [{:keys [description long-desc name], :as d}]
               (let [k (change-name name)
                     kd (change-name name "-desc")]
                 (cond-> d
                   k (assoc :kw k)
                   (and (some? k) (nil? description)) (assoc :description k)
                   (and (some? kd) (nil? long-desc)) (assoc :long-desc kd)))))))

(defn translate-keys
  "Helper to call `tr` on all keys set in `kws`."
  [data kws tr]
  (->> kws
       (reduce (fn [data kw]
                 (->> data
                      (mapv #(update % kw tr))))
         data)))
