(ns kotws.pages.v-developper
  "Developper panel."
  (:require [kotws.pages.developper :as k-developper]
            [kotws.fe-language :as kfe-lang]))

(defn developper-panel
  []
  (k-developper/v-founder-panel (kfe-lang/current-language)))
