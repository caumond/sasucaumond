(ns kotws.pages.v-o-r
  (:require [kotws.language :as klang]
            [kotws.components.v-headered-list :as kvheadered-list]))

(def dic
  {:founder {:fr "Recherche opérationnelle", :en "Operations Research"},
   :intro {:fr "Introduction", :en "Introduction"},
   :hephaistox {:fr "Heiphaistox", :en "Heiphaistox"},
   :hephaistox-desc {:fr "Offres pour les PMIs",
                     :en "Small and medium-sized industries"},
   :hephaistox-long-desc {:fr "", :en ""},
   :event-stock
     {:fr
        "Lancement d'une application de streaming d'événements - le booster stock",
      :en "Launch of an event streaming app - the so called booster stock"},
   :event-stock-desc {:fr "", :en ""},
   :event-stock-long-desc
     {:fr
        "Création de la vision: créer une image résiliante du stock à partir des mouvements de stock. On construit un état de stock à partir des événements de stocks tout en ajoutant la contrainte: un élément de stock n'est qu'à un seul endroit, dans un seul état - Lancement du projet en tant que product owner.",
      :en
        "Create the vision: create a resiliant snapshot of stock information based on stock movements. The stock snapshot is built based on stock events while adding a constraint: a stock element should be in one place, in one state. Starting of the project as a product owner."},
   :ai-purchasing
     {:fr "Première tentative d'achat d'un progiciel d'IA au niveau du groupe",
      :en "First attempt of group A.I. software purchasing"},
   :ai-purchasing-desc {:fr "", :en ""},
   :ai-purchasing-long-desc
     {:en
        "In a group which curiosity for A.I. is awaking, this study has to formalize what is the need for software package or in-house competency. The conclusion was to develop in-house.",
      :fr
        "Dans un groupe s'éveillant à l'IA, cette étude a proposé de ne pas se baser sur un progiciel mais de développer les compétences internes."},
   :tissue-tactical-planning {:fr "Outil tactique d'optimisation en C++",
                              :en "C++ Tactical planning optimization tool"},
   :tissue-tactical-planning-desc {:fr "", :en ""},
   :tissue-tactical-planning-long-desc {:fr "", :en ""},
   :transport {:en "E.J.O.R. - Transportation", :fr "E.J.O.R. - Transports"},
   :transport-desc
     {:en "Iterative methods, integer linear programming, graph optimization",
      :fr
        "Méthodes itératives, programmation linéaire en nombres entiers, optimisation de graphe"},
   :transport-long-desc
     {:en
        "That article present a mathematical model to demonstrate the importance of the anticipation constraint.",
      :fr
        "Cet article présente un modèle mathématique démontrant l'importance de la contrainte de non anticipation."},
   :time-lag {:fr "C.O.R. - Timelag", :en "C.O.R. - Timelag"},
   :time-lag-desc {:fr "", :en ""},
   :time-lag-long-desc
     {:en
        "The time lag constraints allow to manage minimum and maximum heating time, between forge operations. That constraints turn one machine problems into NP-complete problems. That article use a genetic algorithm to find optimized solutions for practical problems.",
      :fr
        "Les contraintes de time lags permettent de gérer des contraintes de temps minimum et maximum de chauffe, entre les opérations de forgeage. Ces contraintes rendent NP-complet les problèmes à une seule machine. Cet article met en oeuvre un algorithme génétique permettant de trouver des solutions optimisées à des problèmes pratiques."},
   :phd {:en "Phd thesis", :fr "Thèse"},
   :phd-desc {:en "", :fr ""},
   :phd-long-desc
     {:fr
        "Le titre de ma thèse est `Le problème de jobshop avec contraintes: modélisation et optimisation`. Dans son premier chapitre, le document décrit les problématiques traitées - l'optimisation, la modélisation des systèmes de production. Le second chapitre décrit le problème de jobshop et quelques méthodes de résolution afin de servir de base aux propositions des chapitres suivants. Dans le troisième chapitre, des méthodes originales d'optimisation des jobshops avec time lags sont décrites. Le chapitre 4 présente le problème de jobshop avec transport et contraintes additionnelles, avec une double modélisation mathématique et de simulation sur exactement les mêmes problématiques afin de valider chacune des deux méthodes. Le dernier chapitre décrit un cadriciel (framework) permettant de modéliser les problèmes d'optimisation.",
      :en
        "The title of this thesis is `Le problème de jobshop avec contraintes: modélisation et optimisation` which stands for `Jobshop problem with constraints: modelling and optimization`. In its first chapter, the thesis describes modelling and optimization of production systems. In the second chapter, the jobshop problem and some optimization methods are described, they'll be a basis on which the proposal in the next chapters will be built. In the third chapter, original optimization methods are described to deal with jobshop with time lags. The chapter 4 describes the jobshop problem with transportation and additional constraints. Two different methods are proposed for exactly the same complex problem: a linear programming method and a simulation method, this help to validate the assumption of each method. The last chapter described a C++ framework for optimisation methods."},
   :cpferv {:fr "P.O.C. industriels", :en "Industrial Proof Of Concepts"},
   :cpferv-desc
     {:fr
        "PSA - Optimisation des lignes d'assemblage (conception des postes) - PSA - Optimisation des chantiers polyvalents (RCPSP)- Eramet - Optimisation des ateliers de forge à chaud (Jobshop with time lags) - Michelin - Gestion d'emploi du temps des pistes d'essais (Time tabling problem) - Michelin - Simulation et optimisation des usines (Simulation à événements discrets et heuristiques).",
      :en
        "PSA - Assembly line optimization (post optimization) - PSA - Workshop optimization (RCSPSP) - Eramet - Forging workshop optimization (Jobshop with time lags) - Michelin - Test tracks time tabling (Time tabling problem) - Michelin - Plant simulation (Discrete event simulation and heuristics)."},
   :cpferv-long-desc {:fr "", :en ""},
   :initial {:fr "Ecole d'ingénieur", :en "Initial training"},
   :initial-desc
     {:fr "Simulation, modélisation et optimisation des systèmes industriels",
      :en "Simulation, modelling and optimization of industrial systems"},
   :initial-long-desc
     {:fr
        "Simulation des systèmes complex, production et recherche opérationnelle avec les chaînes de markov, programmation par contraintes, heuristiques pour les systèmes de production, modélisation et simulation des systèmes de production.",
      :en
        "Complex systems simulation, production and operations research with markov chains, Constraint Programming, Heuristics for production systems, Modelling and simulation of production systems"}})

(def founder-steps
  (letfn
    [(f [l]
       (->
         [[:hephaistox {:img-url "images/hephaistox_logo.png"}]
          [:event-stock {:img-url "images/kafka.png"}]
          [:tissue-tactical-planning {:img-url "images/graduation_cap.png"}]
          [:time-lag
           {:img-url "images/cor_time_lag.png",
            :href
              "https://www.sciencedirect.com/science/article/pii/S0305054806002930"}]
          [:transport
           {:img-url "images/ejor_transport.png",
            :href
              "https://www.sciencedirect.com/science/article/abs/pii/S0377221708004608"}]
          [:phd
           {:url "https://tel.archives-ouvertes.fr/tel-00713587/document",
            :img-url "images/graduation_cap.png"}]
          [:cpferv {:img-url "images/it.png"}]
          [:initial {:img-url "images/isima.png"}]]
         (klang/default-and-translate [:desc :name :long-desc]
                                      (partial klang/tr dic l))))]
    (->> klang/possible-langs
         (mapv (fn [l] [l (f l)]))
         (into {}))))

(defn v-o-r
  [l]
  (let [tr (partial klang/tr dic l)]
    [:<> [:h1.text (tr :founder)] [:div.text (tr :intro)]
     (-> (get founder-steps l)
         kvheadered-list/detailed-list) [:hr]]))

;; [ {:public-reference
;; "https://scholar.google.com/scholar?hl=fr&as_sdt=0%2C5&q=CAUMOND&btnG=", ]
;; "https://www.uca.fr/"
