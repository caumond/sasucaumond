(ns kotws.pages.v-about
  (:require [kotws.multi-language :as ml]
            [re-frame.core :as rf]
            [kotws.subs :as subs]))

(def dictionnary
  {:en {
        :about-title "About"
        :about-intro "This website gather all materials I want to share, summing up my digital contribution."
        }
   :fr {
        :about-title "A propos"
        :about-intro "Ce site rassemble tous les matériaux que je souhaite partager, une synthèse de ma contribution digitale."
        }})

(defn about-panel []
  (let [language (rf/subscribe [::subs/language])
        get-msg (partial (ml/build-translate dictionnary) @language)
        ]
    [:div [:h1 (get-msg :about-title)]
     [:p (get-msg :about-intro)]])
  )
