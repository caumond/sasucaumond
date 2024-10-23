(ns kotws.pages.v-sc
  (:require [kotws.language :as klang]
            [kotws.components.v-headered-list :as kvheadered-list]))

(def dic
  {:founder {:fr "Chaîne logistique", :en "Supply Chain"},
   :introa {:fr "Introduction", :en "Introduction"},
   :intro
     {:fr
        "J'ai créé mon Entreprise SASU Caumond, en 2022 et fondé la marque Hephaistox en 2023."},
   :introa-desc
     {:fr
        "L'idée de fonder une entreprise sur la technique m'a longtemps suivi, mais je n'étais ni mûr ni j'avais un sujet sur lequel je voulais démarrer. En sortant de doctorat, j'ai préféré intégrer une Entrerprise comme Michelin qui m'a permis de découvrir de nombreux domaines différnts, tout en étant intégré dans l'Industrie."}})

(def founder-steps
  (letfn [(f [l]
            (-> {:introa {}}
                (klang/default-and-translate [:desc :name]
                                             (partial klang/tr dic l))))]
    (->> klang/possible-langs
         (map (fn [l] [l (f l)]))
         (into {}))))

(defn v-sc
  [l]
  (let [tr (partial klang/tr dic l)]
    [:<> [:h1 (tr :founder)] [:div (tr :intro)]
     (-> (get founder-steps l)
         kvheadered-list/detailed-list) [:hr]]))
