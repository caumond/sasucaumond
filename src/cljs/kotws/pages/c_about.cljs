(ns kotws.pages.c-about
  (:require [kotws.pages.v-about :refer [v-about]]
            [kotws.fe-language :as kfe-lang]))

(defn about-panel [] (v-about (kfe-lang/current-language)))
