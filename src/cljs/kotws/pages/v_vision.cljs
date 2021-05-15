(ns kotws.pages.v-vision
  (:require [kotws.ml :as ml]))

(def tr
  (partial ml/tr
           {:en {:title                  "My motivations"

                 :where-i-come-from      "Where I come from"
                 :intro                  "During my career, computing has been my preferred innovation vector. After a few years building \"demos\", I loved to bring some innovative methods, based on operations research to industries (PSA | Michelin | Eramet). Thanks to the funding of my phD, I could have done some academic research, but I required to work with industries. The prototypes were fun, but I targeted the industry to be in the heart of the issues, where the decisions were taken. After some years there, I am very happy to have learnt most of main process, their diversity, the markets and had some opportunities to innovate."

                 :what-i-want-to-do      "What I want to do"
                 :what-i-want-to-do-text "I would like to do what I love: innovate as a day-to-day activity. And my strength today is to be able to make appear a vision, to sell it and make it happens, in particular in supply chains, logistics, order to cash, industrialization. When I say make it happens, I'm not speaking of delegation, but to build a solution with competitive advantages, brought by new technologies. This disruption happens because I have these transversal knowledges in three domains: supply chain, computing and mathematics."

                 :where-i-want-to-work "Where I want to work?"
                 :where-i-want-to-work-text "Typically, a small team, at human scale, technology oriented, focusing on leadership and innovation. I prefer full remote position even if discussions are open."

                 :first-typical-mission "First typical mission"
                 :first-typical-mission-text "Some examples: \"Hands-on product [owner | manager]\". If this position let me the possibility to be in the team, in core design, ideally with some developments, this position will be fun. \"Designer or developer\": Beyond development, which is a passion, if that position allow me to work on complex subjects, mixing optimization and modelling, if am able to meet users and innovate with them, it would make me really happy. \"Maybe other ideas I don't have now ...\": I proved my ability to organize project and to manage, but it should not be a principal activity."

                 :some-positions "What I think"
                 }
            :fr { :title                  "Mes motivations"

                 :where-i-come-from      "D'où je viens"
                 :intro                  "L'informatique a été tout au long de ma carrière mon vecteur préféré pour innover. Après quelques années passées à faire des \"démos\", j'ai adoré apporter des méthodes innovantes basées sur la recherche opérationnelle à des enterprises (PSA | Michelin | Aubert & Duval, Eramet). Avec ma bourse d'état, j'aurais pu faire des recherches plus académiques, mais je souhaitais travailler pour des industries. Les prototypes, c'est bien mais je souhaitais être dans le coeur de l'action, là où les décisions se prennent. L'industrie fût l'endroit. Quelques années après, je suis très heureux d'avoir quelques occasions d'innover et d'apprendre largement sur les processus de l'entreprise, leurs variétés, les marchés."

                 :what-i-want-to-do      "Ce que je veux faire"
                 :what-i-want-to-do-text "Je veux faire ce que j'aime: innover tous les jours, et ma force aujourd'hui est de savoir faire émerger, faire grandir une vision, la vendre et la mettre en oeuvre, en particulier dans les domaines de la supply chain, de la logistique, de l'order to cash, de l'industrialisation. Et quand je dis mettre en oeuvre, il n'est pas question de déléguer aveuglement, mais de construire une solution qui apporte des avantages compétitifs, liés aux nouvelles technologies. Ce décalage, je le tire de mes connaissances transverses dans les trois domaines: supply chain, informatiques et mathématiques, en emmenant l'équipe dans de nouveaux chemins."

                 :where-i-want-to-work "Où je souhaite travailler?"
                 :where-i-want-to-work-text "Dans une équipe à taille humaine, techniquement à la pointe, qui privilégie le leadership et l'innovation. Je préférerais travail à la maison, en télétravail, même si tout est discutable."

                 :first-typical-mission "Prochain poste typique"
                 :first-typical-mission-text "Quelques exemples: \"Hands-on product [owner | manager]\": S'il me permet d'être dans l'équipe, dans les éléments de conception coeur, idéalement dans le développement, ce poste me permettra de m'épanouir et d'apporter à l'entreprise. \"Concepteur ou développeur\": Si, au-delà du développement qui me passione, ce poste me permet de travailler sur des sujets complexes mêlant développement optimisation et modélisation, s'il me permet d'être en contacts avec les utilisateurs et d'innover avec eux, je serais comblé. \"Sûrement d'autres idées...\": J'ai prouvé mes compétences d'organisation de projet et de management, mais ce ne doit clairement pas être la composante principale."

                 :some-positions "Ce que je pense"
                 }}))

(def pars
  [{:fr {:sumup "L'avantage compétitif doit passer par un IT coeur: "
         :desc "Quand une entreprise décide de se différencier, (près de son avantage compétitif normalement), elle doit inventer sa différence, l'implémenter dans un logiciel spécifique, dont l'équipe d'ingénierie et de développement sont reconnues au coeur de la valeur. La conséquence est que cette équipe devrait être pérenne, de bon niveau et internalisée: les vraies équipes digitales de l'industrie."}
    :en {:sumup "The competitive advantage needs a core IT: "
         :desc "When an enterprise needs to differentiate, it needs to invent its difference, implement it in a specific software, which engineering and development team are recognized to bring the enterprise value. The consequence should be a durable internal team, with the appropriate level of competency: the real digital teams of industry."}}

   {:fr {:sumup "Intègrer, c'est adopter, se conformer: "
         :desc "Il y a des endroits où les progiciels et l'informatique des intégrateurs sont parfaitement adaptés. Quand c'est le cas, il faut adopter le système, son processus et donc se conformer au domaine du progiciel. Sinon, le risque est d'avoir des équipes taillées pour utiliser un logiciel, et d'autres qui en inventent un nouvel usage. C'est comme cela qu'on finit par tenter de faire entrer des ronds dans des carrés."}
    :en {:sumup "Integration is adoption, needs conformist design pattern: "
         :desc "There are some part of the enterprise where software package and system integrator are perfectly adapted. But there, the system should be adopted, as its process and so, we should be conformist with its domain language. Otherwise, the risk is to have badly staffed teams trying to deploy something, while other teams trying to build a new usage. This is how we square the circle."}}

   {:fr {:sumup "Evolution digitale: "
         :desc "Les grandes industries sont des plateformes, basées sur de la technologie, les autres industries se transforment en \"digital\". Pour tous l'informatique devient critique, et le crafstmanship pourrait être la prochaine révolution, après l'agilité."}
    :en {:sumup "The digital evolution: "
         :desc "Biggest industries are platforms, based on technology, other industry are moving to the \"digital\". For all, computers science is critical, and crafstmanship should be the next revolution, following the agility / scrum one."}}

   {:fr {:sumup "L'I.A. et la recherche opérationnelle: "
         :desc "Les techniques de l'I.A. sont très médiatisées, souvent centrées sur quelques techniques, et quelques exemples de réussite. Leur valeur n'est donc plus à démontrer, mais les techniques de modélisation, d'optimisation itérative et de simulation peuvent les compléter habilement, dans certaines problématiques, en particulier dans l'industrie. Dans le passé, j'ai souvent vu des projets basés sur de la recherche opérationnelle échouer par manque de données fiables. Les conditions qui ont fait évoluer l'intelligence artificielle se mettent en place aussi pour la recherche opérationnelle. Je suis persuadé que c'est un beau champ d'investigations et que de belles histoires sont à écrire."}
    :en {:sumup "I.A. and O.R.: "
         :desc "IA techniques are well covered in the news. Often centered on a few techniques and success stories. The modelling and operationnal research techniques should not be shy. I often meet some O.R. projects failing due to bad data / modelling. The data volume increasing, I have no doubt formalization quality will increase, and O.R. interest will increase in the industry."}}
   ])

(defn tr-item [par & args]
  (apply ml/tr par args))

(defn vision-panel []
  [:<>
   [:h1 (tr [:title])]
   [:h2 (tr [:where-i-come-from])]
   [:p (tr [:intro])]

   [:h2 (tr [:what-i-want-to-do])]
   [:p (tr [:what-i-want-to-do-text])]

   [:h2 (tr [:where-i-want-to-work])]
   [:p (tr [:where-i-want-to-work-text])]

   [:h2 (tr [:first-typical-mission])]
   [:p (tr [:first-typical-mission-text])]

   [:h2 (tr [:some-positions])]

   [:ul
    (doall
     (for [p pars]
       ^{:key p}[:li [:span.par-title (tr-item p [:sumup]) ] (tr-item p [:desc])]))]
   ])
