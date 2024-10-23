(ns kotws.pages.v-about
  (:require [kotws.pages.about-data :as kabout]
            [kotws.fe-language :as kfe-lang]))

(defn about-panel [] (kabout/v-about-panel (kfe-lang/current-language)))
