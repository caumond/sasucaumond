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
         :home-intro "I'm Anthony Caumond, software engineer, designing and building software. Having a wide knowledge from Business / Entreprise Architect to developer."
         :about "About"
         :biblio-title "Bibliography"
         :resume-title "Sum-up:"
         :biblio-intro "These are some noticeable books I took pleasure to read:"
         }
   :fr {
        :about-message "A propos"
        :about-intro "Ce site rassemble tous les matériaux que je souhaite partager, une synthèse de ma contribution digitale."
        :non-existing-panel "Erreur fatale: le panel `{1}` n'est pas paramétré dans les vues"
        :home-title "Site personnel de Kot"
        :home-intro "Bonjour, je suis anthony Caumond, ingénieur en informatique, combinanant une connaissance profonde de l'informatique, des problématiques de conception, de change management. Foncièrement full stack, j'aime les projets munis d'une petite équipe de haut niveau, adressant des sujets ambitieux."
        :about "A propos"
        :biblio-title "Bibliographie"
        :resume-title "Résumé:"
        :biblio-intro "Je vous souhaite autant de plaisir que moi à lire ces ouvrages"
        }
   }
  )

(def translate
  (tongue/build-translate dictionnary))

(defn get-msg [msg & args]
  (let [language (re-frame/subscribe [::subs/language-changed])]
    (translate @language msg args)))
