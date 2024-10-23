(ns kotws.pages.c-tech-stack
  (:require [kotws.fe-language :as kfe-lang]
            [kotws.pages.v-tech-stack :as kv-tech-stack]))

(defn tech-stack [] (kv-tech-stack/c-tech-stack (kfe-lang/current-language)))
