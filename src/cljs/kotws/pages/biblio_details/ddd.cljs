(ns kotws.pages.biblio-details.ddd)

(defn quotation [txt author]
  [:div.w3-panel.w3-leftbar.w3-sand
   [:p.w3-large.w3-serif txt]
   [:p author]]
  )

(defn definition [kw detail]
  [:div.w3-panel.w3-border.w3-sand.w3-padding.w3-twothird
   [:span.w3-bold.w3-large.w3-border.w3-padding.w3-margin kw]
   [:p.w3-padding detail]]
  )

(defn biblio-details-ddd-panel []
  [:div.biblio-details-ddd
   [:h1 "Domain Driven Design"]

   [:h2 "Introduction"]
   [:p "Tout projet de développement est un projet d'apprentissage."]
   [:p "What & Why - DD - aircraft cahier des charges - Mach 2, 2.5
Harrt Hillaker demande pourquoi et propose une autre solution: manoeuvrabilité
Le résultat est le F16, énorme succès commercial"]
   [:p "D'où bien faire la différence entre l'espace du problème et l'espace de la solution,
L'espace du problème: Problem, usages, languages, domain, requirement, constraints, people,
L'espace de la solution: Software, Model, Design , bounded context, patterns, heuristics, feedback"]
   (quotation "Tous les modèles sont faux, certains sont utiles."
              "Georges box")
   (quotation "Il faut rendre l'implicite explicite."
              "DD mantra")

   [:h2 "Evenements"]
   (quotation "When you start modeling events, it forces you to think about the behavior of the system. As opposed to thinking about the structure of the system"
              "Greg Young")

   (definition "événements" "représentent un fait du domaine, il est passé, immutables, ils ont modifié l'état du systeme. Le nommage des événéments est important, il doit représenter un concept du métier. Les événements internes sont dans notre bounded context, mais il peut y avoir aussi des événéments externes.")

   (definition "query" "pour requêter l'état du système.")
   (definition "commandes" "sont des intentions, elles représentent le futur, une intention que l'on a pour le futur. Le succès ou l'échec de cette commande est un événement.")

   [:h2 "Domaine"]
   [:p "A domain is what the business does and the contexte of how it does it
A subdomain represents groups or units in the compagny that collaborate to accomplish the compagny goal"]

   [:h2 "Entité / Objet valeur / Aggrégat"]

   [:h2 "Bounded Context"]
   [:p "Bounded contexte \"an operatioal definition of where a particular model is well defined and applicable\" Typically a subsystem or the work owned by a particular team."]
   [:p "Les bounded context s'organise avec l'upstream et le downstream. Les bounded context sont upstream, ils peuvent impacter les bounded context downstream. L'interaction entre ces bounded context est à présenter clairement dans une contexte map"]
   (definition "context map" "décrit le flux des modèles entre les contextes et fournit un vue d'ensemble du paysage des systèmes.")

   [:h2 "Strategical and Tactical patterns"]
   [:p "Contient deux niveaux de patterns:"]
   [:ul
    [:li "Tactical pattern: lié à l'orienté objets"]
    [:li "Strategical pattern: lié à l'archi"]]
   [:p "Le DDD parle beaucoup d'objet mais est compatible avec les langages fonctionnels"]

   [:h2 "Value oriented"]
   [:p "Les valeurs sont immutables. Elles sont au cœur de l'approche DD. DDD insiste sur la différence entre une entité qui est ce pour quoi on veut gérer un timeline, et une valeur, qui peut évoluer dans le temps mais dont on ne cherche pas à conserver l'ensemble des états."
    ]
   [:p "Un invariant est une règle business qui doit toujours rester consistante. Quand il y a un invariant, on cherche à créer un agrégat. Quand l'agrégat est créé, toutes les modifications des agrégées sont supposées passées par l'agrégat, afin de garantir l'invariant métier."]
   [:ul
    [:li "nombres d'attributs trop important pour une valeur / une entité (10)"]
    [:li "nombre trop important d'entités, 5"]]
   [:p "Smell (sont les heuristiques de problèmes de conception)"]

   ]
  )
