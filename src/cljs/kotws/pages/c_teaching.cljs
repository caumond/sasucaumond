(ns kotws.pages.c-teaching
  (:require [kotws.pages.v-teaching :refer [v-teaching]]
            [kotws.fe-language :as kfe-lang]))

(defn teaching [] (v-teaching (kfe-lang/current-language)))
