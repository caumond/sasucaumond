(ns kotws.app-view.footer
  "Footer of all pages."
  (:require [kotws.app-view.footer-data :as kfooter-data]
            [kotws.fe-language :as kfe-lang]))

(defn footer
  []
  (kfooter-data/v-footer (kfe-lang/current-language)
                         (-> (js/Date.)
                             .getFullYear)))
