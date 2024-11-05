(ns kotws.app-view.c-footer
  "Footer of all pages."
  (:require [kotws.app-view.v-footer :as kfooter]
            [kotws.fe-language :as kfe-lang]))

(defn c-footer
  [size]
  (kfooter/v-footer (kfe-lang/current-language)
                    (-> (js/Date.)
                        .getFullYear)
                    size))
