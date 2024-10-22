(ns kotws.db
  "Default database values."
  (:require [kotws.config :as kconfig]))

(def default-db
  {:name "Anthony CAUMOND professional website",
   :selected-items #{},
   :language kconfig/language,
   :active-panel nil,
   :slide-idx 0})
