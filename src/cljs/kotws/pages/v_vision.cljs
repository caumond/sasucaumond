(ns kotws.pages.v-vision
  (:require [kotws.ml :as ml]))

(def tr
  (partial ml/tr {:en {
                 :title                  "My vision"
                 :intro                  "Since I worked many years in industry,"
                 :what-i-want-to-do      ""
                 :what-i-want-to-do-text ""
                 }
            :fr {
                 :title                  "Ma vision"
                 :intro                  "Durant mes années travaillées dans l'industrie, j'ai acquis une solide connaissance des processus de l'entreprise. La supply chain, la logistique, l'order to cash, l'industrialisation, la garantie qualité ... Ainsi que les progiciels qui les animent. J'ai des opinions ancrées, étayées sur ce que les succès des progiciels vs. leurs faiblesses."
                 :what-i-want-to-do      "Ce que je veux faire"
                 :what-i-want-to-do-text "Je veux travailler dans une équipe à taille humaine, dans une entreprise à taille humaine. Elle doit privilégier le leadership plutôt que du management. Les débats d'opinion ne m'intéressent que s'ils sont étayés par des faits, des gens qui connaissent."
                 :details                "Le niveau de détails attendus dans un ERP, ... Ma vision est qu'il faut savoir distinguer dans une entreprise là où l'effort doit être porté. A cet endroit, la connaissance métier doit être extraite pour en faire une application coeur. La jointure. Mes connaissances en recherche opérationnelle m'ont permis d'avoir une approche systémique, savoir modéliser un système."
                 :now                    "Je veux être moins métier, développer des sujets complexes, avec du théorique. Je me vois plus comme un leader que comme un manager."
                 }}))

(defn vision-panel []
  [:div {:class "about"}
   [:h1 (tr [:title])]
   [:p (tr [:intro])]

   [:h2 (tr [:what-i-want-to-do])]
   [:p (tr [:what-i-want-to-do-text])]

   [:h2 (tr ["Ce que je sais"])]
   [:p (tr [:details])]
   [:p (tr [:now])]
   ]

  )
