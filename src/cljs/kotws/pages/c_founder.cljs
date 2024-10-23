(ns kotws.pages.c-founder
  "About panel."
  (:require [kotws.multi-language :as ml]
            [kotws.fe-language :as kfe-lang]
            [kotws.components.v-headered-list :as kvheadered-list]))

(defn tr
  [k]
  (->
    {:founder {:fr "Fondateur", :en "Founder"},
     :intro
       {:fr
          "J'ai créé mon Entreprise SASU Caumond, en 2022 et fondé la marque Hephaistox en 2023."},
     :histoire-desc
       {:fr
          "L'idée de fonder une entreprise sur la technique m'a longtemps suivi, mais je n'étais ni mûr ni j'avais un sujet sur lequel je voulais démarrer. En sortant de doctorat, j'ai préféré intégrer une Entrerprise comme Michelin qui m'a permis de découvrir de nombreux domaines différnts, tout en étant intégré dans l'Industrie."}}
    (kfe-lang/tr k)))

(defn inspiration-sources
  []
  (-> [{:name "Histoire",
        :url
          "https://www.w3schools.com/w3css/tryw3css_templates_portfolio.htm"}]
      ml/defaulting
      (ml/translate-keys [:description :long-desc] tr)))

(defn v-founder-panel
  []
  [:<> [:h1 (tr :founder)] [:div (tr :intro)]
   (-> (inspiration-sources)
       kvheadered-list/detailed-list) [:hr]])

(defn founder-panel [] (v-founder-panel))
