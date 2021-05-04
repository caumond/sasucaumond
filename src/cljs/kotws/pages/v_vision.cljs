(ns kotws.pages.v-vision
  (:require [kotws.ml :as ml]))

(def tr
  (partial ml/tr
           {:en {:title                  "My vision"

                 :where-i-come-from      "Where I come from"
                 :intro                  "I started development early, as a personal but intensive hobby. After some professional use of that computer skills, I discovered a taste for practical use of my computer skills. This is why I chose an industrial program during my studies. I discovered a technical and conceptual playground, where I needed to learn also modelling and mathematics. Then, I decided to enter the industry to be an actor of that tranformation and complete my domain knowledge. I did want to stop to work on prototypes and start to build."

                 :what-i-want-to-do      "What I want to do"
                 :what-i-want-to-do-text "I wish to focus on my technical skills (development - design - optimisation and modelling). Work on complex subjects, with concepts. Use my industry knowledge of processes (Supply Chain, Logistics, Order To Cash, Industrialization, Quality Guarantee) in different industry sectors (automotive, petrochemicals, steel industry, ...)"

                 :where-i-want-to-work "Where I want to work?"
                 :where-i-want-to-work-text "Typically a small enterprise, at human scale, technology oriented, focusing on leadership and innovation"

                 :first-typical-mission "First typical mission"
                 :first-typical-mission-text "Some examples: \"Hands-on product [owner | manager]\". This position allow me to bring my industry knowledge and allow me to improve by developing professionally. \"Designer and or developer\" I would work on complex subjects mixing development, optimization and modelling. \"For sure many any ideas I don't have right now\" I have no issue to manage a project or a team, as it is not the main part of the position."

                 :some-positions "What I think"
                 }
            :fr { :title                  "Ma vision"

                 :where-i-come-from      "D'où je viens"
                 :intro                  "L'innovation a été mon moteur pendant toute ma carrière. D'abord commencée comme un hobby, l'informatique m'a tout de suite passionée. L'algorithmie complexe des démos pour le jeune homme que j'étais a laissé place à la recherche opérationnelle et ses mathématiques. Avec ma bourse d'état, rien ne m'obligeait à chercher et développer des prototypes industriels (PSA, Michelin, Aubert & Duval), seule l'innovation m'a guidé. Afin de passer des prototypes à des projets industriels, j'ai choisi une carrière industrielle dans laquelle j'ai progressé des projets en apportant des projets innovants, et en prenant de la hauteur sur les sujets."

                 :what-i-want-to-do      "Ce que je veux faire"
                 :what-i-want-to-do-text "Je veux faire ce que j'aime, et ma force aujourd'hui est de savoir faire émerger, faire grandir une vision, la vendre et la mettre en oeuvre, en particulier dans les domaines de la supply chain, de la logistique, de l'order to cash, de l'industrialisation ou de la garantie qualité. Et quand je dis mettre en oeuvre, il n'est pas question de déléguer aveuglement, mais de construire une solution qui apporte des avantages compétitifs, liés aux nouvelles technologies. Ce décalage, je le tire de mes connaissances transverses dans les trois domaines, supply chain, informatiques et mathématiques. C'est cette triple maîtrise qui permet de proposer"

                 :where-i-want-to-work "Où je souhaite travailler?"
                 :where-i-want-to-work-text "Dans une équipe à taille humaine, techniquement à la pointe, qui privilégie le leadership et l'innovation. Je préférerais travail à la maison, en télétravail, même si tout est discutable."

                 :first-typical-mission "Prochain poste typique"
                 :first-typical-mission-text "Quelques exemples: \"Hands-on product [owner | manager]\": Ce poste me permet de développer une expérience de développement professionnelle. \"Concepteur ou développeur\": Ce poste pourrait me permettre de travailler sur des sujets complexes mêlant développement optimisation et modélisation. \"Surement d'autres idées...\": Il peut y avoir de l'organisation de projet et de management, même si ce n'est pas la composante principale."

                 :some-positions "Ce que je pense"
                 }}))

(def pars
  [{:fr {:sumup "L'avantage compétitif doit passer par un IT coeur: "
         :desc "Quand une entreprise décide de se différencier, (près de son avantage compétitif normalement), elle doit inventer sa différence, l'implémenter dans un logiciel spécifique, dont l'équipe d'ingénerie et de développement sont reconnues au coeur de la valeur. La conséquence est que cette équipe devrait être pérenne, de bon niveau et internalisée: les vraies équipes digitales de l'industrie."}
    :en {:sumup "The competitive advantage needs a core IT"
         :desc "When an enterprise needs to differentiate, it needs to invent its difference, implement it in a specific software, which engineering and development team are recognized to bring the enterprise value. The consequence should be a durable internal team, with the appropriate level of competency: the real digital teams of industry."}}

   {:fr {:sumup "Intègrer, c'est adopter, se conformer : "
         :desc "Il y a des endroits où les progiciels et l'informatique des intégrateurs sont parfaitement adaptés. Quand c'est le cas, il faut adopter le système, son processus et donc se conformer au domaine du progiciel. Sinon, le risque est d'avoir des équipes taillées pour utiliser un logiciel, et d'autres qui en inventent un nouvel usage. C'est comme cela qu'on finit par tenter de faire entrer des ronds dans des carrés."}
    :en {:sumup "Integration is adoption, needs conformist design pattern: "
         :desc "There are some part of the enterprise where software package and system integrator are perfectly adapted. But there, the system should be adopted, as its process and so, we should be conformist with its domain language. Otherwise, the risk is to have badly staffed teams trying to deploy something, while other teams trying to build a new usage. This is how we square the circle."}}

   {:fr {:sumup "Evolution digitale : "
         :desc "Les grandes industries sont des plateformes, basées sur de la technologie, les autres industries se transforment en \"digital\". Pour tous l'informatique devient critique, et le crafstmanship pourrait être la prochaine révolution, après l'agilité."}
    :en {:sumup "The digital evolution: "
         :desc "Biggest industries are platforms, based on technology, other industry are moving to the \"digital\". For all, computers science is critical, and crafstmanship should be the next revolution, following the agility / scrum one."}}

   {:fr {:sumup "L'I.A. et la recherche opérationnelle : "
         :desc "Les techniques de l'I.A. sont très médiatisées, souvent centrées sur quelques techniques, et quelques exemples de réussite. Leurs valeurs n'est donc plus à démontrer, mais les techniques de modélisation, d'optimisation itérative et de simulation peuvent les compléter habilement, dans certaines problématiques, en particulier dans l'industrie. Dans le passé, j'ai souvent vu des projets basés sur de la recherche opérationnelle échouer par manque de données fiables. Les conditions qui ont fait évoluer l'intelligence artificielle se mettent en place aussi pour la recherche opérationnelle. Je suis persuader que c'est un beau champ d'investigations et que de belles histoires sont à écrire."}
    :en {:sumup "I.A. and O.R. : "
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
