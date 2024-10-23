(ns kotws.app-view.v-header
  "Header of all pages."
  (:require [kotws.fe-language :as kfe-lang]
            [kotws.app-view.v-header :as kheader]))

(defn header
  "Component displaying the header."
  []
  (kheader/v-header (kfe-lang/current-language) kfe-lang/set-language))
