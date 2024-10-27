(ns kotws.pages.c-it
  "Developper panel."
  (:require [kotws.pages.v-it :as kit]
            [kotws.fe-language :as kfe-lang]))

(defn it [] (kit/v-it (kfe-lang/current-language)))
