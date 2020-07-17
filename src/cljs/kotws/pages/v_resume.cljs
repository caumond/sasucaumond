(ns kotws.pages.v-resume
  (:require [re-frame.core :as rf]
            [kotws.subs :as subs]
            [kotws.events :as events]
            [kotws.ml :as ml]))

;; private
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def tr
  (partial ml/tr
           {:fr {:title "Curriculum vitae"
                 :public-reference "Référence en ligne"
                 :download "Télécharger ce document"
                 :what-is-it "Qu'est-ce?"
                 :intro "La version ci-dessous en est une version détaillée, riche de références. Une version plus traditionnelle en pdf de mon curriculum vitae est téléchargeable, sous forme de pdf, grâce à l'icône en haut à droite de cette page."
                 :intro2 "Trois aspects de mon expérience sont développés ici: supply chain, développement et optimisation."
                 }
            :en {:title "Resume"
                 :public-reference "Online reference"
                 :download "Download that document"
                 :what-is-it "What is it?"
                 :intro "The below version is a detailed version of my resume, full of references. A more classical pdf version of my resume is downloadable (cf. download icon in the upper right corner of that page)."
                 :intro2 "The focus here is made three aspects: supply chain, development and optimization."}}))

(defn tr-item[item & args]
  (apply ml/tr (:ml item) args))

(def resume-timeline
  [{:icon     "fa-wrench"
    :evt-type "timeline__event--type1"
    :date     "2021"
    :where-link "https://www.michelin.fr/"
    :ml {:en {:title "Product owner of an in-house PLM"
              :where "Michelin"}
         :fr {:title "'Product owner' - Cycle de vie produit (PLM)"
              :where "Michelin"}}
    :roles [{:icon      "fa-industry"
             :items [{:what-is-it "https://fr.wikipedia.org/wiki/Gestion_du_cycle_de_vie_(produit)"
                      :ml {:en {:text "Building an in-house PLM"
                                :details "A PLM is a product lifecycle management tool, providing a product, bill of materials and routings referential."}
                           :fr {:text "Construction d'un PLM (Product Lifecycle Management)"
                                :details "Un PLM est un outil de gestion du cycle de vie du produit, permettant de créer un référentiel de produits, gammes et nomenclatures."}}}
                     {:ml {:en {:text "Creation, selling and materialization the vision"
                                :details "Starting in 2018, my first mission was to build the vision in an Entreprise Architecture study. Then, I communicate that vision to teams and executives to trigger inscription in investments plans. As a product owner and project manager, I looked for customers, build the team and materialize the vision. One of the challenge was to conciliate short and long term ambitions."}
                           :fr {:text "Création, promotion et mise en oeuvre de la vision"
                                :details "Commencée en 2018 dans une étude d'architecture Entreprise, ma première mission a été de construire une vision, de la communiquer dans les équipes et aux `executive` pour la faire inscrire dans les plans d'investissement. Puis, en tant que product owner et chef projet, j'ai cherché des premiers clients du produit, monté l'équipe et matéralisé la vision. Un des challenges a été de concilier les ambitions courts et longs termes."}}}
                     {:ml {:en {:text "Team leader"
                                :details "About ten people to manage."}
                           :fr {:text "Team leader"
                                :details "Management d'une équipe d'une dizaine de personnes"}}}
                     ]}
            {:icon      "fa-code"
             :items [{:what-is-it "https://fr.wikipedia.org/wiki/Clojure"
                      :ml {:en {:text "Clojure prototyping"
                                :details "Development in clojure. Data mapping in huge maps (specter), describe a model with data samples and schema validation with malli."}
                           :fr {:text "Prototypage en clojure"
                                :details "Développement en clojure. Mapping de données dans de grandes `map` (specter), description de modèle en illustrant par des données et en validant ces schémas en malli."}}}
                     {:ml {:en {:text "Application design "
                                :details "Design some complex concepts around release management and change orders."}
                           :fr {:text "Conception de l'application"
                                :details "Conception de concepts complexes autour de la gestion de configuration: la gestion des versions et les ordres de changements."}}}
                     ]}
            ]}

   {:icon     "fa-ruler-combined"
    :evt-type "timeline__event--type2"
    :date     "2019"
    :where-link "https://www.michelin.fr/"
    :ml {:en {:title "Supply Chain Entreprise Architect"
              :where "Michelin"}
         :fr {:title "Architecte entreprise pour la supply chain"
              :where "Michelin"}}
    :roles [{:icon "fa-industry"
             :items [{:ml {:en {:text "C-Level entreprise studies"
                                :details "Some studies to illustrate this activity: Offtakers integration in group process, taking group strategy, fiscality, customs and logistics into account. Study on OPE transformation program next step on finished product plants."}
                           :fr {:text "Etudes `Entreprise` niveau `executives`"
                                :details"Quelques études pour illustrer cette activité: L'intégration de la sous traitance dans un processus groupe, avec la prise en compte de la stratégie groupe, de la fiscalité, des douanes et logistiques. Etude sur la suite du programme de transformation OPE sur les usines de produits finis."}}}
                     {:ml {:en {:text "Software package purchasing"
                                :details "I was in charge of supply chain software package purchase: a first project on an automative ERP for integration with automotive customers and their specificities. A second project to equip a subsidiary with an integrated supply chain tool."}
                           :fr {:text "Achat de progiciels entreprises"
                                :details "J'ai eu en charge l'achat des progiciels de mon domaine supply chain: un premier projet sur un ERP spécialisé dans l'automobile pour intégration avec les clients automobiles et leurs spécificités. Un second projet pour outiller une filiale avec un outil de supply chain intégré."}}}
                     {:public-reference "https://www.usinenouvelle.com/article/michelin-veut-reduire-ses-frais-generaux-de-500-millions-d-euros-d-ici-2020.N396442"
                      :ml {:en {:text "Framework studies for a major transformation program"
                                :details "As a team member of the architecture team of OPE program (cf. the hyperlink), we had in charge to find business and I.T. solutions when they concern many teams and metiers. The missions are: define interactions between metiers, supervise projects execution."}
                           :fr {:text "Etudes cadres d'un programme de transformation majeur"
                                :details "Participant à l'équipe d'architecture du programme OPE (cf. le lien), nous avions en charge de trouver des solutions (métiers et informatiques) quand elles font évoluer plusieurs métiers et équipes. Les missions: cadrer les interactions entre les métiers, superviser l'exécution des projets."}}}
                     {:public-reference "https://www.strategieslogistique.com/Michelin-ameliore-son-S-OP-avec"
                      :ml   {:en {:text "Sales and Operations framework and sourcing with JDA"
                                  :details "Finalize purchasing of software package with JDA, frame the project"}
                             :fr {:text "Cadrage et achat d'un progiciel S&OP avec JDA"
                                  :details "Finalisation de l'achat du progiciel S&OP avec JDA, cadrage du projet."}}}
                     {:ml {:en {:text "First attempt of group A.I. software purchasing"
                                :details "In a group which curiosity for A.I. is awaking, this study has to formalize what is the need for software package or in-house competency. The conclusion was to develop in-house."}
                           :fr {:text "Première tentative d'achat d'un progiciel d'IA au niveau du groupe"
                                :details "Dans un groupe s'éveillant à l'IA, cette étude a proposé de ne pas se baser sur un progiciel mais de développer les compétences internes."}}}
                     ]}
            {:icon "fa-code"
             :items [{:ml {:en {:text "Kownledge of main Supply Chain software package"
                                :details "That position was an opportunity to meet main Supply Chain software vendors: OMP, JDA, ORACLE, INFOR and understand their offers."}
                           :fr {:text "Connaissance des principaux progiciels Supply Chain"
                                :details "Ce poste a été l'occasion de rencontrer régulièrement les principaux vendeurs de logiciels Supply Chain: OMP, JDA, ORACLE, INFOR et d'approfondir leurs offres."}}}
                     {:download "docs/togaf.pdf"
                      :ml {:en {:text "Enterprise Architecture - TOGAF"
                                :details "Entreprise Architecture deliverables as described in TOGAF (cf. certification). 200+ software in my perimeters and some architects in my network."}
                           :fr {:text "Pratique de l'architecture entreprise"
                                :details "Livraison des livrables conformément au processus Architecture Entreprise tel que décrit par TOGAF (cf. certification). 200 logiciels dans mon périmètre et quelques architectes dans mon réseau."}}}
                     {:public-reference "https://videos.confluent.io/watch/Uny8xop6vWZut5Hb5CaNpA?"
                      :ml {:en {:text "Launch of an event streaming app - the so called booster stock"
                                :details "Create the vision: create a resiliant snapshot of stock information based on stock movements. The stock snapshot is built based on stock events while adding a constraint: a stock element should be in one place, in one state. Starting of the project as a product owner."}
                           :fr {:text "Lancement d'une application de streaming d'événements - le booster stock"
                                :details "Création de la vision: créer une image résiliante du stock à partir des mouvements de stock. On construit un état de stock à partir des événements de stocks tout en ajoutant la contrainte: un élément de stock n'est qu'à un seul endroit, dans un seul état - Lancement du projet en tant que product owner."}}}
                     ]}]
    }

   {:icon "fa-ruler-horizontal"
    :evt-type "timeline__event--type3"
    :where-link "https://www.michelin.fr/"
    :date "2016"
    :ml {:en {:title "I.T. Architect and Supply Chain consultant"
              :where "Michelin"}
         :fr {:title "Architecte I.T. et consultant Supply Chain"
              :where "Michelin"}}
    :roles [{:icon "fa-industry"
             :items [{:ml {:en {:text "Architecture business"
                                :details "At the beginning of OPE program, the 60 semi finished production sites are locally managed, with a high diversity of process and maturity. My contribution is the design of supply chain process, build planning model in a PLM, integrate planning with and ERP and a WMS (Warehouse Management System)."}
                           :fr {:text "Architecture business"
                                :details "Au démarrage du programme OPE, les 60 sites de production de semis-finis sont gérés complétement localement. Ma contribution consiste à concevoir les processus supply chain, construire le modèle de planification dans un PLM, intégrer la planification avec l'ERP et l'outil de gestion de magasin (WMS)."}}}
                     {:ml {:en {:text "Production planning"
                                :details "Expert (solution consultant) of a master planning application for finish products plant - deployment on asian and south american plants."}
                           :fr {:text "Expert d'une solution de planning de production"
                                :details "Expert (solution consultant) d'une application de master planning des usines produits finis - déploiement sur des usines d'asie et d'amérique du sud."}}}
                     {:ml {:en {:text "Certification for BASICS - APICS"
                                :details "I was certified with MGCM with a BASICS level of APICS. Supply chain oriented, dealing with methods and tools, this training gives a comprehensive panorama of supply chain."}
                           :fr {:text "Certification BASICS à l'APICS"
                                :details "J'ai été certifié par MGCM pour le niveau BASICS de l'APICS. Orientée Supply Chain, outils et méthodes, cette formation fournit un panorama complet de la supply chain."
                                }}
                      :public-reference "https://www.fapics.org/762_p_44058/bscm.html"}
                     ]}
            {:icon "fa-code"
             :items [{:ml {:en {:text "Solution Architecture"
                                :details "Solution architect of two planning solution - architecture folder."}
                           :fr {:text "Architecte solution"
                                :details "Architecte solution sur deux solutions de planification - dossier d'architecture."}}}
                     ]}]}

   {:icon "fa-chalkboard-teacher"
    :evt-type "timeline__event--type1"
    :date "2008"
    :where-link "https://fr.wikipedia.org/wiki/Logica"
    :ml {:en {:title "I.T. Supply Chain consultant"
              :where "Unilog - A Logica CMG compagny"}
         :fr {:title "I.T. consultant Supply chain"
              :where "Unilog - A Logica CMG compagny"}}
    :roles [{:icon "fa-industry"
             :items [{:ml {:en {:text "Distribution planning - DRP - change management"
                                :details "Design of distribution network, deployment of a DRP on 3 product lines (European truck tires, Agriculture, Africa India Middle east)"}
                           :fr {:text "Planning de distribution - DRP - gestion du changement"
                                :details "Conception de réseaux de distribution, de déploiement d'un DRP sur 3 lignes de produits (Poids Lourd Europe, Agro, Afrique Inde Moyen Orient)"}}}
                     ]}
            {:icon "fa-infinity"
             :items [{:ml {:en {:text "Distribution network optimization"
                                :details "Solving thousands of minimum flow algorithms (one per article reference) thanks to busaker and gowen algorithm. Design, development and integration of the solution."}
                           :fr {:text "Optimisation du réseau de distribution"
                                :details "Résolution de milliers (un par référence article) de problème de flots minimum, grâce à l'algorithme de busaker et gowen (coût de transport minimum respectant les contraintes capacitaires)."}}}
                     {:ml {:en {:text "Trainer in Supply Chain"
                                :details "Temporary trainer in Master I and Master II in logistics and Supply Chain."}
                           :fr {:text "Formateur en Supply Chain"
                                :details "Vacataire en Master I et Master II en Logistique et Supply Chain."}}}
                     ]}
            {:icon "fa-code"
             :items [{:ml {:en {:text "PLSQL"
                                :details "Integration in PLSQL of optimization tool (Thousand of product references calculation)."}
                           :fr {:text "PLSQL"
                                :details "Conception, développement et intégration de la solution d'optimisation du réseau de distribution."}}}
                     {:ml {:en {:text "C++ Tactical planning optimization tool"
                                :details "Needs analysis - design - development of an optimization tool for tactical planning (make or buy)."}
                           :fr {:text "Outil tactique d'optimisation en C++"
                                :details "Analyse du besoin - conception - développement d'un outil d'optimisation des plans tactiques (make or buy)."}}}
                     ]}
            ]}

   {:icon "fa-shopping-cart"
    :evt-type "timeline__event--type2"
    :date "2006"
    :where-link "https://web.archive.org/web/20060614232036/http:/www.bijouteriecaumond.fr/"
    :ml {:en {:title "E-commerce website"
              :where "Family jewelry"}
         :fr {:title "Site e-commerce"
              :where "Bijouterie familiale"}}
    :roles [{:icon "fa-industry"
             :items [{:ml {:en {:text "Practical order to cash knowledge"
                                :details "Build and practise of an order to cash process."}
                           :fr {:text "Connaissance pratique d'un order to cash"
                                :details "Construction et mise en pratique d'un processus order to cash."}}}]}
            {:icon "fa-code"
             :items [{:public-reference "https://web.archive.org/web/20060614232036/http:/www.bijouteriecaumond.fr/"
                      :ml {:en {:text "Php5 - mysql paradox db - Borland C++"
                                :details "The website was operational and worked during roughly three years. The website objective was to create extra activity for the family jewerly. A backend in Borland C++ was developped to manage and upload product catalog. The website by itself contains some e-payment and CMS to delegate some site update."}
                           :fr {:text "Php5 - mysql paradox db - Borland C++"
                                :details "Le site web était opérationnel et fonctionnait pendant environ trois ans, permettant d'offrir une activité supplémentaire à la bijouterie familiale. Un backend en Borland C++ permettait de gérer et de télécharger le catalogue produit. Le site offrait des fonctionnalités de paiement et de CMS, afin de déléguer une partie de sa mise à jour."}}}]}]}

   {:icon "fa-university"
    :evt-type "timeline__event--type3"
    :where-link "https://www.uca.fr/"
    :date "2001"
    :ml {:en {:title "Operation Research PhD and teacher"
              :where "Blaise Pascal University"}
         :fr {:title "Docteur en recherche opérationnelle et enseignant"
              :where "Université Blaise Pascal"}}
    :roles [{:icon "fa-industry"
             :items [{:ml {:en {:text "Industrial Proof Of Concepts"
                                :details "PSA - Assembly line optimization (post optimization) - PSA - Workshop optimization (RCSPSP) - Eramet - Forging workshop optimization (Jobshop with time lags) - Michelin - Test tracks time tabling (Time tabling problem) - Michelin - Plant simulation (Discrete event simulation and heuristics)."}
                           :fr {:text "P.O.C. industriels"
                                :details "PSA - Optimisation des lignes d'assemblage (conception des postes) - PSA - Optimisation des chantiers polyvalents (RCPSP)- Eramet - Optimisation des ateliers de forge à chaud (Jobshop with time lags) - Michelin - Gestion d'emploi du temps des pistes d'essais (Time tabling problem) - Michelin - Simulation et optimisation des usines (Simulation à événements discrets et heuristiques)."}}}
                     ]}
            {:icon "fa-code"
             :items [{:ml {:en {:text "UI and backend in Borland C++"
                                :details "Most of that poc are assorted with user interfaces for data preparation, result visualization, setup and optimisation monitoring."}
                           :fr {:text "Interfaces utilisateurs et backend en Borland C++"
                                :details "Ces démonstrateurs sont pour la plupart agrémentés d'interfaces utilisateurs pour la préparation des données, la visualisation des résultats, le paramétrage et pour le suivi de l'optimisation."}}}
                     {:ml {:en {:text "C++ Framework for iterative optimization"
                                :details "The chapter 5 of my thesis offers a framework for iterative optimization."}
                           :fr {:text "Cadriciel pour l'optimisation itérative"
                                :details "Le chapitre 5 de ma thèse propose un framework pour l'optimisation itérative."}}}
                     ]}
            {:icon "fa-infinity"
             :items [{:download "https://tel.archives-ouvertes.fr/tel-00713587/document"
                      :ml {:en {:text "Phd thesis"
                                :details "The title of this thesis is `Le problème de jobshop avec contraintes: modélisation et optimisation` which stands for `Jobshop problem with constraints: modelling and optimization`. In its first chapter, the thesis describes modelling and optimization of production systems. In the second chapter, the jobshop problem and some optimization methods are described, they'll be a basis on which the proposal in the next chapters will be built. In the third chapter, original optimization methods are described to deal with jobshop with time lags. The chapter 4 describes the jobshop problem with transportation and additional constraints. Two different methods are proposed for exactly the same complex problem: a linear programming method and a simulation method, this help to validate the assumption of each method. The last chapter described a C++ framework for optimisation methods." }
                           :fr {:text "Thèse"
                                :details "Le titre de ma thèse est `Le problème de jobshop avec contraintes: modélisation et optimisation`. Dans son premier chapitre, le document décrit les problématiques traitées - l'optimisation, la modélisation des systèmes de production. Le second chapitre décrit le problème de jobshop et quelques méthodes de résolution afin de servir de base aux propositions des chapitres suivants. Dans le troisième chapitre, des méthodes originales d'optimisation des jobshops avec time lags sont décrites. Le chapitre 4 présente le problème de jobshop avec transport et contraintes additionnelles, avec une double modélisation mathématique et de simulation sur exactement les mêmes problématiques afin de valider chacune des deux méthodes. Le dernier chapitre décrit un cadriciel (framework) permettant de modéliser les problèmes d'optimisation."}}}
                     {:public-reference "https://scholar.google.com/scholar?hl=fr&as_sdt=0%2C5&q=CAUMOND&btnG="
                      :ml {:en {:text "Articles"
                                :details "Various articles are presented in conferences and journals."}
                           :fr {:text "Articles"
                                :details "Plusieurs articles issus de conférences et de journaux."}}}
                     {:public-reference "https://www.sciencedirect.com/science/article/pii/S0305054806002930"
                      :ml {:en {:text "C.O.R. - Timelag"
                                :details "The time lag constraints allow to manage minimum and maximum heating time, between forge operations. That constraints turn one machine problems into NP-complete problems. That article use a genetic algorithm to find optimized solutions for practical problems."}
                           :fr {:text "C.O.R. - Timelag"
                                :details "Les contraintes de time lags permettent de gérer des contraintes de temps minimum et maximum de chauffe, entre les opérations de forgeage. Ces contraintes rendent NP-complet les problèmes à une seule machine. Cet article met en oeuvre un algorithme génétique permettant de trouver des solutions optimisées à des problèmes pratiques."}}}
                     {:public-reference "https://www.sciencedirect.com/science/article/abs/pii/S0377221708004608"
                      :ml {:en {:text "E.J.O.R. - Transportation"
                                :details "That article present a mathematical model to demonstrate the importance of the anticipation constraint."}
                           :fr {:text "E.J.O.R. - Transports"
                                :details "Cet article présente un modèle mathématique démontrant l'importance de la contrainte de non anticipation."}}}
                     {:ml {:en {:text "Iterative methods"
                                :details "Iterative methods, integer linear programming, graph optimization"}
                           :fr {:text "Méthodes itératives"
                                :details "Méthodes itératives, programmation linéaire en nombres entierss, optimisation de graphe"}}}
                     ]}
            ]}

   {:icon "fa-school"
    :where-link "https://www.isima.fr/"
    :evt-type "timeline__event--type1"
    :date "1998"
    :ml {:en {:title "Computer science Engineering degree"
              :where "ISIMA"}
         :fr {:title "Ecole d'ingénieurs en informatique"
              :where "ISIMA"}}
    :roles [{:icon "fa-industry"
             :items [{:ml {:en {:text "Simulation, modelling and optimization of industrial systems"
                                :details "Complex systems simulation, production and operations research with markov chains, Constraint Programming, Heuristics for production systems, Modelling and simulation of production systems"}
                           :fr {:text "Simulation, modélisation et optimisation des systèmes industriels"
                                :details "Simulation des systèmes complex, production et recherche opérationnelle avec les chaînes de markov, programmation par contraintes, heuristiques pour les systèmes de production, modélisation et simulation des systèmes de production."}}
                      }]}
            {:icon "fa-code"
             :items [{:ml {:en {:text "Decision Support System and Information System"
                                :details "ADA, Assembly, C, Fortran, LISP, data structure, matlab, algorithmic, java, numerical programming, prolog. Two stages and two internships of six months long."}
                           :fr {:text "Systèmes d’Information et Aide à la Décision"
                                :details "ADA, Assembleur, C, fortran, LISP, structure de données, matlab, algorithmique, java, programmation numérique, prolog. Ces cours sont assortis de deux projets et de deux stages de 6 mois"}}}]}]}
   {:icon "fa-user-alt"
    :evt-type "timeline__event--type2"
    :ml {:en {:title "Coding for fun"
              :where "@home"}
         :fr {:title "Développement pour le plaisir"
              :where "@maison"}}
    :roles [{:icon "fa-code"
             :items [{:what-is-it "https://en.wikipedia.org/wiki/Demoscene"
                      :ml {:en {:text "Demo making and games"
                                :details "I discovered development with game creation. They could be in text mode at that time (redefining fonts to define sprites), or in graphical mode. But I spent a lot of time to develop demos: vectoballs, rasters, overscans, wireframe 3D. I had to rediscover how to draw lines..."}
                           :fr {:text "Démos et jeux"
                                :details "J'ai découvert le développement en créant des jeux, en mode texte (en redéfinissant les caractères) ou en mode graphique. Mais j'ai passé beaucoup de temps à faire des démos: des vectors balls, des rasters, des overscans, de la 3D en wireframe, en redécouvrant les algorithmes de traçage de lignes."}}}
                     {:ml {:en {:text "Jewelry stock management tool"
                                :details "At a time when professionnal software were quite scarce, I had the occasion to build one in GFA Basic, in order to manage the stock of the family jewelry."}
                           :fr {:text "Outil de gestion de stock pour bijouterie"
                                :details "A une époque où les logiciels de gestion professionnels étaient rares, j'ai eu l'occasion de construire le logiciel de gestion de stock de la bijouterie familiale en gfa basic. "}}}
                     {:ml {:en {:text "GFA basic & 68000 assembly"
                                :details "I used mainly that two languages for the above achievements. I also had the opportunity to use Z80 and code machine."}
                           :fr {:text "Assembleur Z80 et 68000"
                                :details "J'ai majoritairement utilisé ces deux languages pour les réalisations ci-dessus. J'ai aussi eu l'occasion de faire du Z80 et du language machine."}}}]}]}
   ])

;; public
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn resume-panel []
  [:<>
   [:a {:href "docs/caumond-resume.pdf" :target "blank"} [:i.fa.fa-download.w3-margin.w3-right]]
   [:h1 (tr [:title])]
   [:p (tr [:intro])]
   [:p (tr [:intro2])]

   [:div.timeline
    (doall
     (for [position-idx (range (count resume-timeline))
           :let [position (nth resume-timeline position-idx)]]
       ^{:key (str "position-" position-idx)}
       [:div.timeline__event.animated.fadeInUp.delay-1s {:class (:evt-type position)}
        [:div.timeline__event__icon
         [:i.fa {:class (:icon position)}]]

        [:div.timeline__event__date
         (:date position)]
        [:div.timeline__event__content
         [:div.timeline__event__title
          (tr-item position [:title])]
         (let [where-link (:where-link position)]
           (if (nil? where-link)
             [:p.where (tr-item position [:where])]
             [:a {:href where-link :target "blank"}
              [:p.where (tr-item position [:where])]]))
         [:hr.round]
         [:ul.timeline__event__description.w3-ul
          (doall
           (for [role-idx (range (count (:roles position)))
                 :let [role (nth (:roles position) role-idx)]]
             ^{:key (str "role-" position-idx "-" role-idx)}
             [:li.role
              [:i.fa.role-icon {:class (:icon role)}]
              [:div.w3-rest
               (doall
                (for [item-idx (range (count(:items role)))
                      :let [item (nth (:items role) item-idx)]]
                  (let [selected-items (rf/subscribe [::subs/selected-items])
                        text-item (tr-item item [:text])
                        detailed-shown? (contains? @selected-items [position-idx role-idx item-idx])
                        details-text (tr-item item [:details])]
                    ^{:key (str "item-" position-idx "-" role-idx "-" item-idx)}
                    [:div.item {:on-click #(rf/dispatch [::events/selected-items [position-idx role-idx item-idx]])
                                :style{:display "block"}}
                     [:a
                      [:i.arrow.fa.fa-angle-down {:class (when-not detailed-shown? "w3-hide")}]
                      [:i.arrow.fa.fa-angle-right {:class (when detailed-shown? "w3-hide")}]
                      text-item]
                     (when (:what-is-it item)
                       [:a {:href (:what-is-it item) :target "blank"}
                        [:div.tooltipable
                         "?"
                         [:span.tooltip (tr [:what-is-it])]
                         ]])
                     (when (:public-reference item)
                       [:a {:href (:public-reference item) :target "blank"}
                        [:div.tooltipable
                         [:i.fa.fa-globe]
                         [:span.tooltip (tr [:public-reference])]
                         ]])
                     (when (:download item)
                       [:a {:href (:download item) :target "blank"}
                        [:div.tooltipable
                         [:i.fa.fa-download]
                         [:span.tooltip (tr [:download])]
                         ]])
                     [:div.detailed-item
                      {:class (when-not detailed-shown? "w3-hide")}
                      (when detailed-shown?
                        details-text)
                      ]]
                    )))]]
             ))]
         ]]
       ))]]
  )
