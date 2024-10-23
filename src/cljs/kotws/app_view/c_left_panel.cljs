(ns kotws.app-view.c-left-panel
  "Connect left-pannel to page current language."
  (:require [kotws.app-view.v-left :refer [v-left]]
            [kotws.fe-language :as kfe-lang]))

(defn c-left-panel [] (v-left (kfe-lang/current-language)))
