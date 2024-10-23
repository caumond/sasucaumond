(ns kotws.pages.c-sc
  (:require [kotws.fe-language :as kfe-lang]
            [kotws.pages.v-sc :as kvsc]))

(defn sc [] (kvsc/v-sc (kfe-lang/current-language)))
