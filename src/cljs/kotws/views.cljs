(ns kotws.views
  (:require [re-frame.core :as rf]
            [kotws.subs :as subs]
            [kotws.ml :as ml]
            [kotws.pages.v-home :refer [home-panel]]
            [kotws.pages.v-about :refer [about-panel]]
            [kotws.pages.v-biblio :refer [biblio-panel]]
            [kotws.pages.v-tech-stack :refer [tech-stack-panel]]
            [kotws.pages.v-resume :refer [resume-panel]]
            [kotws.pages.v-vision :refer [vision-panel]]
            [kotws.pages.biblio-details.ddd :refer [biblio-details-ddd-panel]]
            ))

(def tr (partial ml/tr
           {:en {:non-existing-panel "Fatal error: the panel `%1` is not setup in views"}
            :fr {:non-existing-panel "Erreur fatale: le panel `%1` n'est pas paramétré dans les vues"}}))

(defn panel []
  (let [active-panel (rf/subscribe [::subs/active-panel])]
    (case @active-panel
      :home-panel               [home-panel]
      :about-panel              [about-panel]
      :tech-stack-panel         [tech-stack-panel]
      :resume-panel             [resume-panel]
      :vision-panel             [vision-panel]
      :biblio-panel             [biblio-panel]
      :biblio-details-ddd-panel [biblio-details-ddd-panel]
      [:h1 (tr [:non-existing-panel])]
      )))
