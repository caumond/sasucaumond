(ns kotws.multi-language
  (:require [tongue.core :as tongue]
            [re-frame.core :as re-frame]
            [kotws.subs :as subs]))


(def dictionnary
  { :en {
         :about-message "About"
         :about-intro "This website gather all materials I want to share, summing up my digital contribution."
         :non-existing-panel "Fatal error: the panel `{1}` is not setup in views"
         :home-title "Kot website"
         }
   :fr {
        :about-message "A propos"
        :about-intro "Ce site rassemble tous les matériaux que je souhaite partager, une synthèse de ma contribution digitale."
        :non-existing-panel "Erreur fatale: le panel `{1}` n'est pas paramétré dans les vues"
        :home-title "Site personnel de Kot"
        }
   }
  )

(def translate
  (tongue/build-translate dictionnary))

(defn get-msg [msg & args]
  (let [language (re-frame/subscribe [::subs/change-language])]
    (translate @language msg args)))
