(ns kotws.pages.c-developper
  "Developper panel."
  (:require [kotws.pages.v-developper :as kvdevelopper]
            [kotws.fe-language :as kfe-lang]))

(defn developper-panel
  []
  (kvdevelopper/v-founder-panel (kfe-lang/current-language)))
