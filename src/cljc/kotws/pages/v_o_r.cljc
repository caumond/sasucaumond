(ns kotws.pages.v-o-r
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]
            [kotws.components.v-headered-list :as kvheadered-list]
            [kotws.components.v-space :as kvspace]))

(def dic
  {:founder {:fr "Recherche opérationnelle", :en "Operations Research"},
   :intro
     {:fr
        "La recherche opérationnelle est beaucoup moins connue que sa petite sœur, l'intelligence artificielle. Pourtant les fondamentaux sont extrêmement proches. Personnellement, je dis que je fais de l'intelligence naturelle, car la recherche opérationnelle ne prétend pas laissé la créativité à un cerveau électronique. Bien au contraire, en recherche opérationnelle, on capture la connaissance des humains et on l'insert délibérément dans des modèles ou dans des méthodes d'explorer pour améliorer la performance de l'optimisation. Cela fait moins rêver, cela repose sur l'humain qui donne les informations et les experts de recherche opérationnelle qui font la modélisation et l'optimisation. Mais je trouve ce sujet passionnant et il y a des endroits où l'industrie ne pourra pas, ou ne voudra pas confier sa prise de décision à des algorithmes qu'elle ne comprend pas, qu'elle ne maîtrise pas. L'image qui illustre bien ces propos est celle de la voiture. Posséder une voiture autonome qui parcourt les routes, découvre son environnement (voiture autonome de niveau 5), c'est encore loin et nous avons des craintes à ce propos. En revanche, quand vous utilisez votre voiture, vous ne tournez pas les roues, vous n'appuyez pas sur les freins, depuis des années déjà. A la place, un algorithme écoute vos commandes et obéit, jusqu'au moment où la trajectoire déclenche une glissade, ou que les pneus commencent à bloquer. Ces algorithmes nous sont plus familier car on comprend mieux comment cela fonctionne. On reste aux commandes le temps que tout va bien et quand l'algorithme prend les commandes, c'est parce que l'on est dans une situation pénible. Un pilote pourra vouloir désactiver ces aides, mais la plupart des conducteurs sont très heureux d'être assisté dans ces conditions extrêmes.",
      :en
        "Operations research is much less well-known than its little sister, artificial intelligence. However, the fundamentals are extremely close. I'm saying I do natural intelligence because operations research does not claim to leave creativity to an electronic brain. Quite the contrary, in operations research, we capture human knowledge and deliberately insert it into models or exploration methods to improve optimization performance. This is less of a dream, it relies on the human who provides the information and the operations research experts who do the modeling and optimization. But I find this subject fascinating and there are places where the industry will not be able, or will not want to entrust its decision-making to algorithms that it does not understand, that it does not control. The image that illustrates this well is that of the car. Having an autonomous car that travels the roads, and discovers its environment (level 5 autonomous car), is still a long way off and we have concerns about it. On the other hand, when you use your car, you don't turn the wheels, you don't press the brakes, and this has been the case for years. Instead, an algorithm listens to your commands and obeys them until the trajectory triggers a slide, or the tires start to lock. These algorithms are more familiar to us because we understand better how they work. We stay in control while everything is going well and when the algorithm takes control, it's because we are in a difficult situation. A driver may want to deactivate these aids, but most drivers are very happy to be assisted in these extreme conditions."},
   :intro-2
     {:fr
        "Durant mon école d'ingénieur, mon DEA et mon doctorat, ou après dans ma carrière professionnelle, je n'ai eu de cesse que d'appliquer ces connaissances sur des projets industriels, même quand mon financement ne me l'imposait pas. C'est mon goût et c'est ainsi que j'ai construit une expérience utile.",
      :en
        "During my engineering school, my DEA, and my doctorate, or after in my professional career, I never stopped to apply this knowledge on industrial projects, even when my funding did not require it. It's my taste and it's how I built up useful experience."},
   :hephaistox {:fr "Heiphaistox", :en "Heiphaistox"},
   :hephaistox-desc {:fr "SASU Caumond - Offres pour les PMIs",
                     :en "SASU Caumond - Small and medium-sized industries"},
   :hephaistox-long-desc
     {:fr
        "L'offre Hephaistox intègre la recherche opérationnelle au coeur. Mes expériences ci-dessous intégreront l'offre, mais pour l'instant seuls l'optimisation et la simulation à événements discrets sont disponibles. L'optimisation découle naturellement du chapitre 5 de ma thèse, alors que la simulation à événements discrets est une nouvelle offre..",
      :en
        "The Hephaistox offering integrates operational research at its core. My practice below will integrate the offering, but for now, only optimization and discrete event simulation are available. Optimization naturally follows from chapter 5 of my thesis, while discrete event simulation is a new offering."},
   :tissue-tactical-planning {:fr "Outil tactique d'optimisation en C++",
                              :en "C++ Tactical planning optimization tool"},
   :tissue-tactical-planning-desc
     {:fr "Michelin - Décider ce qui est acheté, ce qui est produit",
      :en "Michelin - Deciding what is purchased, what is produced"},
   :tissue-tactical-planning-long-desc
     {:fr
        "L'optimisation `make or buy` consiste à décider ce qu'une entreprise produit avec ses moyens propres et ce qu'elle achète. Sachant que pour être performant, les achats doivent être réalisé à l'avance, ce qui permet de négocier les prix, mais obligé à s'imposer des volumes de commandes minimum et maximum (minimum par an, par mois, par référence, ...). Décider quoi produire quand, dans un univers incertain, c'est très difficile et de nombreuses décisions sont à prendre. L'outil que j'ai réalisé prend est une métaheuristique explorant efficacement ces décisions. Basé sur la BCOO (cf. onglet développement), c'est un outil qui a été en production pendant au moins plus de dix ans.",
      :en
        "`Make or buy` optimization consists of deciding what a company produces with its resources and what it buys. Knowing that to be efficient, purchases must be made in advance, which allows for price negotiations, but requires imposing minimum and maximum order volumes (minimum per year, per month, per reference, ...). Deciding what to produce when, in an uncertain universe, is very difficult and many decisions have to be made. The tool I created is a metaheuristic that effectively explores these decisions. Based on BCOO (see development tab), it is a tool that has been in production for at least ten years."},
   :drp {:fr "Réseau de distribution", :en "Distribution sourcing"},
   :drp-desc {:fr "Michelin - Des milliers d'algorithme de flots",
              :en "Michelin - Thousands of flow algorithms"},
   :drp-long-desc
     {:fr
        "Découvert pendant le déploiement, le bug de la version précédente aurait pu arrêter le déploiement du projet. J'ai réécrit dans l'urgence, en PLSQL des algorithmes de flot (Busaker et Goven), pour pouvoir corriger la version précédente. Il y a autant d'algorithmes de flots à traiter que de références dans le groupe Michelin, autant dire plusieurs milliers.",
      :en
        "Discovered during deployment, the bug in the previous version could have stopped the deployment of the project. I urgently rewrote flow algorithms (Busaker and Goven) in PLSQL to be able to correct the previous version. There are as many flow algorithms to process as there are references in the Michelin group, which is to say several thousand."},
   :cor-time-lag {:fr "C.O.R. - Timelag", :en "C.O.R. - Timelag"},
   :cor-time-lag-desc
     {:fr "Résoudre un problème pratique et théoriquement peu traité",
      :en "Solving a practical and theoretically little-treated problem"},
   :cor-time-lag-long-desc
     {:en
        "In `Computers and Operation Research`, I had the chance to publish an article on time lags. Time lag constraints express minimum and maximum times between two operations. These constraints make the problems very difficult (a single-machine problem is already NP-complete). This article implements a genetic algorithm to find optimized solutions to practical problems. The difficulty is that outside of special cases, it is not possible to build a feasible solution. This requires the use of slightly more complex graph algorithms, but above all it disrupts iterative search algorithms. Indeed, they must travel large spaces where no solution is feasible before finding a new feasible solution. We must imagine the search space as a Swiss cheese in which we would only want to be in the `holes`. These issues come from my research following the internship at Aubert & Duval. The workshop is that of hot forging, the time lags then represent the minimum heating times (without which the part cannot pass on the forge) and maximum without which the loss of material and energy becomes too significant. COR is one of the very best scientific journals on operational research.",
      :fr
        "Dans Computers and Operation Research`, j'ai eu la chance de publier un article sur les time lags. Les contraintes de time lags expriment des temps minimum et maximum entre deux opérations. Ces contraintes rendent les problèmes très difficiles (un problème à une machine est déjà NP-complet). Cet article met en oeuvre un algorithme génétique permettant de trouver des solutions optimisées à des problèmes pratiques. La difficulté est qu'en dehors de cas particuliers, il n'est pas possible d'être de construire une solution faisable. Cela oblige à utiliser des algorithmes de graphe légèrement plus complexe, mais surtout cela perturbe les algorithmes de recherche itératives. En effet, ceux-ci doivent parcourir de grands espaces où aucune solution n'est faisable avant de trouver une nouvelle solution faisable. Il faut s'imaginer l'espace de recherche comme un gruyère dans lequel on ne voudrait être que dans les trous`. Ces problématiques sont issues de mes recherches suite au stage chez Aubert & Duval. Latelier est celui de forge à chaud, les time lags représentent alors les temps de chauffe minimum (sans quoi la pièce ne peut passer sur la forge) et maximum sans quoi la perte de matière et d'énergie deviennent trop importante. COR est un des tout meilleurs journaux scientifiques sur la recherche opérationnelle."},
   :ejor-transport {:en "EJOR - Transportation", :fr "E.J.O.R. - Transports"},
   :ejor-transport-desc
     {:en "Iterative methods, integer linear programming, graph optimization",
      :fr
        "Méthodes itératives, programmation linéaire en nombres entiers, optimisation de graphe"},
   :ejor-transport-long-desc
     {:en
        "In the `European Journal of Optimization Research`, I had the chance to publish this article demonstrating the importance of the non-anticipation constraint. An anticipation constraint expresses that in the real world, a conveyor rarely anticipates the arrival of a part, it waits for a signal from the machine that triggers it, making assumptions about the next part that will have to be transported is a source of error, it is much more complex to implement in industry and make the installation sensitive to hazards. In this article, we show that not taking these constraints into account drastically changes the best solutions, their form, and the optimization criterion. By grouping in the same article two very different but self-validating methods, we were able to show the importance of this often neglected constraint. EJOR is a high-level operational research journal, focused on Europe.",
      :fr
        "Dans l' `European Journal of Optimization Research`, j'ai eu la chance de publier cet article démontrant l'importance de la contrainte de non anticipation. Une contrainte d'anticipation exprime que dans le monde réel, un transporteur anticipe rarement l'arrivée d'une pièce, il attend un signal de la machine qui le déclenche, prendre des hypothèses sur la prochaine pièce qui devra être transportée sont sources d'erreur, est beaucoup plus complexe à mettre en oeuvre dans l'industrie et rends l'installation sensible aux aléas. Dans cet article, on montre que ne pas prendre en compte ces contraintes changent drastiquement les meilleures solutions, leur forme et le critère d'optimisation. En regroupant dans le même article deux méthodes très différentes mais qui s'auto valident, nous avons pu montrer l'importance de cette contrainte  souvent négligée. EJOR est un journal de recherche opérationnel de haut niveau, centré sur l'Europe."},
   :phd {:en "Phd thesis", :fr "Thèse de doctorat"},
   :phd-desc
     {:en
        "Université d'Auvergne - Unique, conditions for, discovering complex, systems and, industry.",
      :fr
        "Université d'Auvergne - Des conditions uniques pour découvrir les systèmes complexes et l'industrie."},
   :phd-long-desc
     {:fr
        "J'ai souhaité faire un doctorat pour approfondir les sujets que j'avais découvert auparavant. Grâce à une bourse ministérielle (MENRT) obtenue au mérite pendant le DEA, j'ai eu les conditions idéales pour naviguer entre la théorie et la pratique. Le titre de ma thèse est `Le problème de jobshop avec contraintes: modélisation et optimisation`. Dans son premier chapitre, le document décrit les problématiques traitées - l'optimisation, la modélisation des systèmes de production. Le second chapitre décrit le problème de jobshop et quelques méthodes de résolution afin de servir de base aux propositions des chapitres suivants. Dans le troisième chapitre, des méthodes originales d'optimisation des jobshops avec time lags sont décrites. Le chapitre 4 présente le problème de jobshop avec transport et contraintes additionnelles, avec une double modélisation mathématique et de simulation sur exactement les mêmes problématiques afin de valider chacune des deux méthodes. Le dernier chapitre décrit un cadriciel (framework) permettant de modéliser les problèmes d'optimisation.",
      :en
        "I wanted to do a PhD to deepen the topics I had discovered before. Thanks to a ministerial scholarship (the so-called MENRT) obtained on merit during the master of research, I had the ideal conditions to navigate between theory and practice. The title of my thesis is `The jobshop problem with constraints: modeling and optimization`. In its first chapter, the document describes the problems addressed - optimization, and modeling of production systems. The second chapter describes the jobshop problem and some resolution methods to serve as a basis for the proposals of the following chapters. In the third chapter, original methods for optimizing jobshops with time lags are described. Chapter 4 presents the jobshop problem with transport and additional constraints, with a double mathematical and simulation modeling on the same problems to validate each of the two methods. The last chapter describes a framework for modeling optimization problems."},
   :smpp {:fr "Planification automatique d'usine de pneumatiques",
          :en "Automatic Tire Plant Planning"},
   :smpp-desc
     {:fr
        "Michelin - Simulation et optimisation des usines (Simulation à événements discrets et heuristiques).",
      :en
        "Michelin - Simulation and optimization of factories (Discrete event simulation and heuristics)."},
   :smpp-long-desc
     {:fr
        "Les usines de fabrication de pneumatiques étaient planifiées manuellement. En déployant le programme Mercure, le groupe Michelin avait besoin d'un plan de production de plus long terme. Faire ce planning manuellement créait trop de charge sur les planneurs, et SMPP est l'outil qui a permis de compléter le plan de production. A deux, nous avons créé un outil de planification calculant automatiquement ces plans. Intégré à l'architecture du groupe, SMPP a été déployé sur plusieurs usines du groupe;",
      :en
        "The tire manufacturing plants were planned manually. By deploying the Mercure program, the Michelin group needed a longer-term production plan. Doing this planning manually created too much workload for the planners, and SMPP is the tool that allowed production planning to be completerd. Together, we created a planning tool that automatically calculated these plans. Integrated into the group's architecture, SMPP was deployed across several of the group's plants;"},
   :forge-workshop {:fr "Atelier de forge à chaud", :en "Hot forging workshop"},
   :forge-workshop-desc
     {:fr
        "Eramet - Intégrer les contraintes de cuisson dans l'ordonnancement de la forge",
      :en "Eramet - Integrating cooking constraints into forge scheduling"},
   :forge-workshop-long-desc
     {:fr
        "Les ateliers de forge à chaud sont centrées sur la forge, la machine que l'on cherche à charger. L'action de la forge crée le corroyage de la matière, ce que l'on peut comparer à l'action d'un pâtissier sur une pâte à tarte, le malaxage fait évoluer la structure de la matière et donne les bonnes propriétés à la matière. Mais quand il s'agit de métal, chauffer la pièce est un prérequis essentiel pour la rendre malléable. Ce chauffage est réalisé par des fours qui entourent la forge. Ces fours montent à haute température et le temps de chauffe peut aller de quelques à heures à une journée entière. Quand une pièce chauffe, une autre est très certainement en cours de forgeage. Au bout d'un certain temps de forgeage, la pièce a trop descendu en température et il peut être nécessaire de faire passer la pièce de nouveau au four pour un appoint de chauffe. Pendant ce temps, une autre pièce peut être traitée. Ce qui rends le problème théoriquement complexe, c'est une contrainte de temps de chauffe maximum, car au bout d'un certain temps dans le four une couche de calamine se forme. C'est une couche de matière à rebuter, qui a été endommagée par la haute température.",
      :en
        "Hot forging workshops are centered on the forge, the machine we are trying to load. The action of the forge prepares the materials, as we can prepare a pastry on a pie crust, the kneading changes the structure of the material and gives the right properties to the material. But when it comes to metal, heating the part is an essential prerequisite to make it malleable. This heating is carried out by ovens that surround the forge. These ovens rise to a high temperature and the heating time can range from a few hours to a whole day. When one part is heating, another is most certainly being forged. After a certain amount of forging time, the part has dropped too much in temperature and it may be necessary to put the part back in the oven for additional heating. In the meantime, another part can be processed. What makes the problem theoretically complex is a maximum heating time constraint, because the part oxidizes after a certain time in the oven. This is a layer of material to be discarded, which has been damaged by the high temperature."},
   :cpferv {:fr "Chantiers polyvalents", :en "Multipurpose construction sites"},
   :cpferv-desc {:fr "PSA - Résoudre un problème `RCPSP`",
                 :en "PSA - Solve an `RCPSP` problem"},
   :cpferv-long-desc
     {:fr
        "Les chantiers polyvalents fabriquent des pièces de rechange métallique pour l'automobile. Ils ont la particularité d'être très flexibles pour fabriquer toutes les pièces détachées des modèles passés. Le prix de cette flexibilité est la complexité des configurations possibles. Les chantiers sont de formes variables et la première décision à prendre est la position du chantier au sol. Certains outils sont lourds et donc suspendus sur des rails. Mais lorsque le chantier est installé, il n'est plus possible de faire se doubler les outils. Une autre contrainte majeure est la disponibilité des personnes qui installent et désinstallent les chantiers.",
      :en
        "Multi-purpose yards manufacture metal spare parts for automobiles. They are particularly flexible in manufacturing all spare parts for past models. The price of this flexibility is the complexity of the possible configurations. The yards are of variable shapes and the first decision to be made is the position of the yard on the ground. Some tools are heavy and therefore suspended on rails. However, when the yard is installed, it is no longer possible to duplicate the tools. Another major constraint is the availability of the people who install and uninstall the yards."},
   :isima {:fr "Ecole d'ingénieur", :en "Initial training"},
   :isima-desc
     {:fr
        "ISIMA - Simulation, modélisation et optimisation des systèmes industriels",
      :en
        "ISIMA - Simulation, modelling and optimization of industrial systems"},
   :isima-long-desc
     {:fr
        "C'est avec mes enseignants et ces cours que j'ai découvert la chaine logistique: simulation des systèmes complexes, production et recherche opérationnelle avec les chaînes de Markov, programmation par contraintes, heuristiques pour les systèmes de production, modélisation et simulation des systèmes de production.",
      :en
        "It was with my teachers and these courses that I discovered the supply chain: simulation of complex systems, production and operational research with Markov chains, constraint programming, heuristics for production systems, modeling and simulation of production systems."}})

(def items
  [[:hephaistox {}] [:tissue-tactical-planning {}] [:drp {}] [:cor-time-lag {}]
   [:ejor-transport {}]
   [:phd
    {:start-date "01/09/2001",
     :end-date "01/09/2006",
     :company "Université Blaise Pascale"}] [:smpp {:img-url :tire}]
   [:forge-workshop {}] [:cpferv {:img-url :psa}] [:isima {}]])

(def tr (partial klang/tr dic))

(defn v-o-r
  [l]
  (let [current-tr (partial tr l)
        founder-steps (kvheadered-list/defaulting* items
                                                   tr
                                                   klinks/image-link
                                                   klinks/external-link)]
    [:<> [:h1.text (current-tr :founder)] [:div.text (current-tr :intro)]
     [:div.text (current-tr :intro-2)] [kvspace/vertical-spacing]
     [kvheadered-list/detailed-list (get founder-steps l) :small]]))
