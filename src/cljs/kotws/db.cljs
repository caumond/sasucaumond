(ns kotws.db
  "Default database values."
  (:require [kotws.local-storage :as klocal-storage]))

(defn lang-strategy
  "Returns the language of the local storage, if not, get the accepted language from the server request."
  []
  (let [server-accepted-lang js/lang
        ls-lang (klocal-storage/get-item :lang)]
    (cond (some? ls-lang) (keyword ls-lang)
          server-accepted-lang (keyword server-accepted-lang)
          :else :en)))

(def default-db
  {:name "Anthony CAUMOND professional website",
   :selected-items #{},
   :language (lang-strategy),
   :active-panel nil,
   :slide-idx 0})
