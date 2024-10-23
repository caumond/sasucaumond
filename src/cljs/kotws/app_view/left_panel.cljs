(ns kotws.app-view.left-panel
  "Connect left-pannel to page current language."
  (:require [kotws.app-view.left-panel-data :as kfe-left-panel-data]
            [kotws.fe-language :as kfe-lang]))

(defn panel [] (kfe-left-panel-data/v-panel (kfe-lang/current-language)))
