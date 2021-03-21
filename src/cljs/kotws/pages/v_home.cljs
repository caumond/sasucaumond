(ns kotws.pages.v-home
  (:require [kotws.multi-language :as ml]
            [kotws.subs :as subs]
            [re-frame.core :as rf]))

(def dictionnary
  {:en {:home-intro "I'm Anthony Caumond, software engineer, designing and building software. Having a wide knowledge from Business / Entreprise Architect to developer."
        :home-msg   "I'm Anthony CAUMOND"}
   :fr {:home-intro "Bonjour, je suis anthony Caumond, ingénieur en informatique, combinanant une connaissance profonde de l'informatique, des problématiques de conception, de change management. Foncièrement full stack, j'aime les projets munis d'une petite équipe de haut niveau, adressant des sujets ambitieux.

The kind of position I would dream about: As a product manager, on a complex system targeting industry / distribution using optimisation techniques. My day to day is a mix of long term vision and hands on core algorithms. Animating complex design of systems."
        :home-msg "Je suis Anthony CAUMOND"}
   })

(defn home-panel []
  (let [language (rf/subscribe [::subs/language])
        get-msg (partial (ml/build-translate dictionnary) @language)
        ]
    [:div#home-main
     [:div#me-image]
     [:div#me-intro
      [:h1 (get-msg :home-msg)]
      [:p (get-msg :home-intro)]
      ]])
  )
