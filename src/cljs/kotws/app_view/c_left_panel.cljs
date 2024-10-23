(ns kotws.app-view.c-left-panel
  "Connect left-pannel to page current language."
  (:require [kotws.app-view.v-left-panel :as kfe-left-panel]
            [kotws.fe-language :as kfe-lang]))

(defn left-panel [] (kfe-left-panel/v-panel (kfe-lang/current-language)))
