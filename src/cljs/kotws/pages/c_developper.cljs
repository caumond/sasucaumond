(ns kotws.pages.c-developper
  "Developper panel."
  (:require [kotws.pages.v-developper :as kvdevelopper]
            [kotws.fe-language :as kfe-lang]))

(defn developper [] (kvdevelopper/v-founder (kfe-lang/current-language)))
