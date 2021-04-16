(ns kotws.pages.v-vision
  (:require [kotws.ml :as ml]))

(def tr
  (partial ml/tr
           {:en {
                 :title                  "My vision"
                 :intro                  "During the time I spent in the industry, I acquired strong knowledge of industry process: Supply Chain, Logistics, Order To Cash, Industrialization, Quality Guarantee ... I discovered also the package software of that domain. I have strong opinions, supported by their strength and weakness."
                 :what-i-want-to-do      "What I want to do"
                 :what-i-want-to-do-text "I want to work in team at human scale, in an entreprise at human scale. That enterprise should privilege leadership, technical skills, innovation."
                 :what-i-know "What I think"
                 }
            :fr {
                 :title                  "Ma vision"
                 :intro                  "Durant mes années dans l'industrie, j'ai acquis une solide connaissance des processus Supply Chain, logistique, order to cash, industrialisation et garantie qualité ... Ainsi que les progiciels qui les animent. J'ai des opinions ancrées, étayées par les succès et les faiblesses des progiciels."
                 :what-i-want-to-do      "Ce que je veux faire"
                 :what-i-want-to-do-text "Je veux travailler dans une équipe à taille humaine, dans une entreprise à taille humaine. Elle doit privilégier le leadership, la technique, l'innovation. J'aime les sujets complexes, avec des concepts."
                 :what-i-know "Ce que je pense"
                 }}))

(def pars
  [{:fr {:desc "Ma vision est qu'il faut savoir distinguer dans une entreprise là où l'effort doit être porté. A cet endroit, la connaissance métier doit être extraite pour en faire une application coeur. La jointure. Mes connaissances en recherche opérationnelle m'ont permis d'avoir une approche systémique, savoir modéliser un système. Foncièrement full stack, j'aime les projets d'une petite équipe de haut niveau, adressant des sujets complexes ambitieux. Ajouter les compétences de modélisation - optimisation. Je souhaite"}
    :en {:desc ""}}
   {:fr {:desc "L'informatique est un avantage compétitif pour l'industrie. Mon sentiment est que l'industrie mesure mal l'importance de ces compétences techniques, ni même l'importance des compétences transverses."}
    :en {:desc "Information technology is a real competitive advantage for industries. My feeling is that industry don't measure the importance of IT competencies, neither the importance of transversal competencies."}}
   ])

(defn tr-item [par & args]
  (apply ml/tr par args))

(defn vision-panel []
  [:<>
   [:h1 (tr [:title])]
   [:p (tr [:intro])]

   [:h2 (tr [:what-i-want-to-do])]
   [:p (tr [:what-i-want-to-do-text])]

   [:h2 (tr [:what-i-know])]

   [:ul
    (for [p pars]
      ^{:key p}[:li (tr-item p [:desc])])]
   ]
  )
