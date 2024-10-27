(ns kotws.db "Default database values.")

(defn from-page
  "Returns the language as set in the current page."
  []
  (let [l js/lang] (if l (keyword l) :en)))

(def default-db
  {:name "Anthony CAUMOND professional website",
   :selected-items #{},
   :language (from-page),
   :active-panel nil,
   :slide-idx 0})
