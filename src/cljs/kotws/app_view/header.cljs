(ns kotws.app-view.header
  "Header of all pages."
  (:require [kotws.fe-language :as kfe-lang]
            [kotws.app-view.header-data :as kheader-data]))

(defn header
  "Component displaying the header."
  []
  (kheader-data/v-header (kfe-lang/current-language) kfe-lang/set-language))
