(ns kotws.page-place-holder
  (:require [kotws.pages.c-home :refer [home-panel]]
            [kotws.pages.c-about :refer [about-panel]]
            [kotws.pages.c-biblio :refer [biblio-panel]]
            [kotws.pages.c-developper :refer [developper-panel]]
            [kotws.pages.c-o-r :refer [o-r]]
            [kotws.pages.c-sc :refer [sc]]
            [kotws.pages.c-tech-stack :refer [tech-stack-panel]]
            [kotws.pages.c-founder :refer [founder-panel]]))

(defn page
  "map the `panel` value (a keyword) to the component itself."
  [panel]
  (case panel
    :home-panel [home-panel]
    :about-panel [about-panel]
    :tech-stack-panel [tech-stack-panel]
    :founder-panel [founder-panel]
    :developper-panel [developper-panel]
    :or-panel [o-r]
    :sc [sc]
    :biblio-panel [biblio-panel]
    [home-panel]))
