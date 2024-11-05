(ns kotws.app-view.c-header
  "Header of all pages."
  (:require [kotws.fe-language :as kfe-lang]
            [kotws.app-view.v-header :as kheader]))

(defn c-header
  "Component displaying the header."
  [size]
  (kheader/v-header (kfe-lang/current-language) kfe-lang/set-language size))
