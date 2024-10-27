(ns kotws.pages.c-o-r
  (:require [kotws.fe-language :as kfe-lang]
            [kotws.pages.v-o-r :as kvo-r]))

(defn o-r [] (kvo-r/v-o-r (kfe-lang/current-language)))
