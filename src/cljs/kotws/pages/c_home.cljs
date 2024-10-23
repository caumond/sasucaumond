(ns kotws.pages.c-home
  (:require [kotws.fe-language :as kfe-lang]
            [kotws.pages.v-home :as kvhome]))

(defn home [] (kvhome/v-home (kfe-lang/current-language)))
