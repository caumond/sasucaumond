(ns kotws.app-view.c-left
  "Connect left-pannel to page current language."
  (:require [kotws.app-view.v-left :refer [v-left]]
            [kotws.fe-language :as kfe-lang]))

(defn c-left [] (v-left (kfe-lang/current-language)))
