(ns kotws.ml
  (:require [taoensso.tempura :as tempura]
            [kotws.subs :as subs]
            [re-frame.core :as rf]))

(def dictionary-registry
  {:en {:missing "Missing english translation"}
   :fr {:missing "Manque la traduction française"
        }})

(defn tr
  ([dic keys] (tr dic keys []))
  ([dic keys args]
   (tempura/tr {:dict (merge-with merge dic dictionary-registry)}
               [@(rf/subscribe [::subs/language])]
               keys
               args
               )))
