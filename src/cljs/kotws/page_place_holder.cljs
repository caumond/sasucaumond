(ns kotws.page-place-holder
  (:require [kotws.pages.v-home :refer [home-panel]]
            [kotws.pages.v-about :refer [about-panel]]
            [kotws.pages.v-biblio :refer [biblio-panel]]
            [kotws.pages.v-developper :refer [developper-panel]]
            [kotws.pages.v-or :refer [or-panel]]
            [kotws.pages.v-sc :refer [sc-panel]]
            [kotws.pages.v-tech-stack :refer [tech-stack-panel]]
            [kotws.pages.v-founder :refer [founder-panel]]))

(defn page
  "map the `panel` value (a keyword) to the component itself."
  [panel]
  (case panel
    :home-panel [home-panel]
    :about-panel [about-panel]
    :tech-stack-panel [tech-stack-panel]
    :founder-panel [founder-panel]
    :developper-panel [developper-panel]
    :or-panel [or-panel]
    :sc-panel [sc-panel]
    :biblio-panel [biblio-panel]
    [home-panel]))
