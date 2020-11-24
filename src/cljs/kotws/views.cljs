(ns kotws.views
  (:require
   [re-frame.core :as rf]
   [kotws.subs :as subs]
   [kotws.multi-language :as ml]
   [kotws.pages.v-home :refer [home-panel]]
   [kotws.pages.v-about :refer [about-panel]]
   [kotws.pages.v-biblio :refer [biblio-panel]]
   [kotws.pages.v-coi :refer [coi-panel]]
   [kotws.pages.v-cv :refer [cv-panel]]
   [kotws.pages.v-connect :refer [connection-panel]]
   [kotws.pages.biblio-details.ddd :refer [biblio-details-ddd-panel]]
   ))

(def dictionnary
  {:en {:non-existing-panel "Fatal error: the panel `{1}` is not setup in views"}
   :fr {:non-existing-panel "Erreur fatale: le panel `{1}` n'est pas paramétré dans les vues"}})

(defn panel []
  (let [active-panel (rf/subscribe [::subs/active-panel])
        language (rf/subscribe [::subs/language])
        get-msg (partial (ml/build-translate dictionnary) @language)
        ]
    (case @active-panel
      :home-panel [home-panel]
      :about-panel [about-panel]
      :coi [coi-panel]
      :cv [cv-panel]
      :biblio-panel [biblio-panel]
      :connection-panel [connection-panel]
      :biblio-details-ddd [biblio-details-ddd-panel]
      [:h1 (get-msg :non-existing-panel @active-panel)]
      )

    )
  )

