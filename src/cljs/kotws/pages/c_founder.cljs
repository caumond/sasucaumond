(ns kotws.pages.c-founder
  (:require [kotws.fe-language :as kfe-lang]
            [kotws.pages.v-founder :as kvfounder]))

(defn founder [] (kvfounder/v-founder (kfe-lang/current-language)))
