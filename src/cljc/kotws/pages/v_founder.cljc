(ns kotws.pages.v-founder
  (:require [kotws.multi-language :as kmulti-language]
            [kotws.components.v-headered-list :as kvheadered-list]))

(def dic
  {:founder {:fr "Fondateur", :en "Founder"},
   :introa {:fr "Introduction", :en "Introduction"},
   :intro
     {:fr
        "J'ai créé mon Entreprise SASU Caumond, en 2022 et fondé la marque Hephaistox en 2023."},
   :introa-desc
     {:fr
        "L'idée de fonder une entreprise sur la technique m'a longtemps suivi, mais je n'étais ni mûr ni j'avais un sujet sur lequel je voulais démarrer. En sortant de doctorat, j'ai préféré intégrer une Entrerprise comme Michelin qui m'a permis de découvrir de nombreux domaines différnts, tout en étant intégré dans l'Industrie."}})

(defn founder-steps
  [l]
  (-> {:introa {}}
      (kmulti-language/default-and-translate
        [:desc :name]
        (partial kmulti-language/tr dic l))))

(defn v-founder
  [l]
  (let [tr (partial kmulti-language/tr dic l)]
    [:<> [:h1 (tr :founder)] [:div (tr :intro)]
     (-> (founder-steps l)
         kvheadered-list/detailed-list) [:hr]]))
