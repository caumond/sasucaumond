(ns kotws.views
  (:require
   [re-frame.core :as re-frame]
   [kotws.subs :as subs]
   [kotws.multi-language :as ml]
   [kotws.pages.v-home :refer [home-panel]]
   [kotws.pages.v-about :refer [about-panel]]
   [kotws.pages.v-biblio :refer [biblio-panel]]
   [kotws.pages.v-coi :refer [coi-panel]]
   [kotws.pages.v-cv :refer [cv-panel]]
   ))

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    :coi [coi-panel]
    :cv [cv-panel]
    :biblio-panel [biblio-panel]
    [:h1 (ml/get-msg :non-existing-panel panel-name)]
    ))

(defn panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [panels @active-panel]
    )
  )

