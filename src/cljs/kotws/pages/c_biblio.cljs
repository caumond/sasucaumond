(ns kotws.pages.c-biblio
  (:require [kotws.fe-language :as kfe-lang]
            [kotws.pages.v-biblio :as kvbiblio]
            [kotws.components.c-selector :as kcselector]))

(defn biblio-panel
  []
  [kvbiblio/v-biblio-panel (kfe-lang/current-language)
   (kcselector/selected :biblio-book)
   (partial kcselector/opts-go-to :biblio-book)
   (partial kcselector/opts-go-rel :biblio-book)])
