(ns kotws.multi-language
  (:require [tongue.core :as tongue]
            [re-frame.core :as re-frame]
            [kotws.subs :as subs]))


(def dictionnary
  { :en {
         :about-message "This is the about page!"
         }
   :fr {
        :about-message "Voici la page à propos!"
        }
   }
  )

(def translate
  (tongue/build-translate dictionnary))

(defn get-msg [msg]
  (let [language (re-frame/subscribe [::subs/change-language])]
    (translate @language msg)))
