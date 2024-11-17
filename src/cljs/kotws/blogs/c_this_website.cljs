(ns kotws.blogs.c-this-website
  (:require [kotws.blogs.v-this-website :refer [v-this-website]]
            [kotws.fe-language :as kfe-lang]))

(defn this-website [] (v-this-website (kfe-lang/current-language)))
