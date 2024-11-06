(ns kotws.pages.v-it
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]
            [kotws.components.v-headered-list :as kvheadered-list]
            [kotws.components.v-space :as kvspace]))

(def dic
  {:computer-science {:fr "Informatique", :en "Computer science"},
   :intro
     {:en
        [:<>
         [:p
          "I love and have always loved IT development. I have used this knowledge in large companies, but now I prefer to return to smaller areas to exercise my vision and skills better."]
         [:p
          "I started IT development early, a little after 10 years. With this experience, I like:"]
         [:ul [:li "My user's world, their constraints."]
          [:li
           "Digitize (some would say digitalize) to transform and therefore improve your business."]
          [:li
           "More provide a solution than a technology. From my point of view, technologies evolve but very slowly, they are accessories. On the contrary, software design is of order one."]
          [:li
           "Design to find the best compromise, the best balance. Rich Hickey says it very well: \"Programmers know the benefits of everything and the tradeoffs of nothing\" (Rich Hickey)"]]
         [:p
          "To illustrate, I recognize myself in software craftsmanship, Domain-Driven Design, given direction, immutability, separation of concerns."]],
      :fr
        [:<>
         [:p
          "J'adore et j'ai toujours aimé le développement en informatique. J'ai exercé ces connaissances en grandes Entreprises, mais je préfère maintenant revenir à des périmètres plus petits sur lesquels je peux mieux exercer ma vision et mes compétences."]
         [:p
          "J'ai démarré tôt le développement en informatique, un peu après 10 ans. Fort de cette expérience, j'aime :"]
         [:ul [:li "Le monde de mon utilisateur, ses contraintes."]
          [:li
           "Informatiser (certains diront digitaliser) pour transformer et donc améliorer son métier."]
          [:li
           "Plus fournir une solution qu'une technologie. De mon point de vue, les technologies évoluent mais très lentement, elles sont accessoires. A contrario, la conception du logiciel est d'ordre un."]
          [:li
           "Concevoir pour rechercher le meilleur compromis, le meilleur équilibre. Rich Hickey dit très bien : \"Programmers know the benefits of everything and the tradeoffs of nothing\" (Rich Hickey)"]]
         [:p
          "Pour illustrer, je me reconnais dans l'artisanat logiciel, le Domain-Driven Design, l'orientation donnée, l'immutabilité, la séparation des préoccupations (separation of concerns)."]]},
   :hephaistox {:fr "Hephaistox", :en "Hephaistox"},
   :hephaistox-desc
     {:fr "Open source pour aider les PMIs dans leur prise de décision",
      :en
        "Small and medium industries open source softwares for decision support."},
   :hephaistox-long-desc
     {:fr
        [:<>
         [:p
          "Hephaistox est un ensemble d'outils open source pour créer des logiciels en tant que service. Concrètement, cela se composent de plusieurs outils, appelés automates."]
         [:ul
          [:li [:b "build : "]
           "un automate pour travailler avec tous les projets comme s'ils ne faisaient qu'un (Monorepo)"]
          [:li [:b "core : "] "l'automate noyau"]
          [:li [:b "web : "] "pour construire des applications web"]
          [:li [:b "optimization : "]
           "pour chercher des solutions parmi un grand nombre de solutions. (Optimisation discrète et itérative)"]
          [:li [:b "simulation-de : "]
           "simulation à événements discrets, pour reproduire le comportement de votre industrie et envisager numériquement des modifications."]]
         [:h3 "Technologies"] [:p "Clojure, Clojurescript"]],
      :en
        [:<>
         [:p
          "Hephaistox is a set of open source tools to create software as a service. Concretely, it consists of several tools, called automatons."]
         [:ul
          [:li [:b "build : "]
           "an automaton to work with all projects as if they were one (Monorepo)"]
          [:li [:b "core : "] "the kernel automaton"]
          [:li [:b "web : "] "to build web applications"]
          [:li [:b "optimization : "]
           "to search for solutions among a large number of solutions. (Discrete and iterative optimization)"]
          [:li [:b "simulation-de : "]
           "discrete event simulation, to reproduce the behavior of your industry and numerically consider modifications."]]
         [:h3 "Technologies"] [:p "Clojure, Clojurescript"]]},
   :storrito {:fr "Storrito", :en "Storrito"},
   :storrito-desc {:fr "Développeur Clojure fullstack.",
                   :en "Fullstack Clojure developper."},
   :storrito-long-desc
     {:fr
        [:<>
         [:p
          "Pendant une année, afin de préparer Hephaistox, j'ai participé au projet Storrito qui permet de planifier à l'avance la publication de stories, de reels sur Instagram. Mon objectif était d'apprendre Clojure, réapprendre les bases de développements, intégrer les contraintes d'un projet disponible dans le `cloud`."]
         [:p "J'ai démarré le freelance à travers cette activité, et appris :"]
         [:ul
          [:li
           "Clojure / Clojurescript : une connaissance pratique et professionnelle de ces langages que j'avais appris par moi-même."]
          [:li "Les contraintes de hautes disponibilités d'une solution cloud."]
          [:li
           "La pile web : du serveur web, l'authentification, les autorisations."]]
         [:h3 "Technologies"]
         [:p "Clojure, Clojurescript, Google Cloud, Datomic database"]],
      :en
        [:<>
         [:p
          "For a year, in order to prepare Hephaistox, I participated in the Storrito project which allows you to plan in advance the publication of stories, reels on Instagram. My goal was to learn Clojure, relearn the basics of development, and integrate the constraints of a project available in the `cloud`."]
         [:p "I started freelancing through this activity, and learned:"]
         [:ul
          [:li
           "Clojure / Clojurescript: a practical and professional knowledge of these languages ​​that I had learned by myself."]
          [:li "The high availability constraints of a cloud solution."]
          [:li
           "The web stack: from the web server, authentication, authorizations."]]
         [:h3 "Technologies"]
         [:p "Clojure, Clojurescript, Google Cloud, Datomic database"]]},
   :plm {:en "Industrial configuration management",
         :fr "Gestion de configuration industrielle"},
   :plm-desc {:fr "Conception d'un PLM pour l'industrie",
              :en "Industrial PLM design"},
   :plm-long-desc
     {:fr
        [:<>
         [:p
          "A l'instar de git pour le code informatique, un PLM est un outil de l'industrie pour gérer les nomenclatures (le contenu de ce que l'on souhaite fournir au client) et les gammes (comment on souhaite le fabriquer). Chaque acteur de l'industrie décrit sa façon de voir les produits et y adjoindre ses informations (des regroupements de produits similaires, des tolérances, ...)."]
         [:p
          "J'ai fait la première conception de cet outil, pour gérer les différents produit, gammes et nomenclatures, leurs versions, et leurs relations."]],
      :en
        [:<>
         [:p
          "Like git for computer code, a PLM is an industry tool for managing nomenclatures (the content of what we want to provide to the customer) and routings (how we want to manufacture it). Each industry actor describes their way of seeing products and adds their information (groupings of similar products, tolerances, etc.)."]
         [:p
          "I did the first design of this tool, to manage the different products, routings and nomenclatures, their versions, and their relationships."]]},
   :event-stock {:fr "Les flux d'événements pour gérer le stock",
                 :en "Event flows to manage inventory"},
   :event-stock-desc {:fr "Décaler la qualité de la connaissance du stock",
                      :en "Shifting the quality of stock knowledge"},
   :event-stock-long-desc
     {:fr
        "La connaissance du stock est un problème récurrent dans l'industrie, de l'extérieur on ne soupçonne pas à quel point il y a des imprécisions. Bien sûr il y a des industries meilleures que d'autres, mais toutes ont fortement intérêt à s'améliorer sur le sujet. L'idée est de créer une image résiliente du stock à partir des mouvements de stock. On construit un état de stock à partir des événements de stocks tout en ajoutant la contrainte : un élément de stock n'est qu'à un seul endroit, dans un seul état. Autant il est facile d'accumuler les erreurs quand on compte combien de produits entrent et sortent, autant quand un individu est muni d'un code barre, on peut beaucoup moins se tromper. Soit le produit n'est pas à l'endroit que l'on croit car on a raté un événement (mais le prochain mouvement rattrapera cette erreur), soit le produit est définitivement sorti et le délai de vieillissement, le prochain inventaire corrigeront cette erreur. Bien sûr que l'image ne sera pas parfaite, mais elle sera beaucoup plus résiliente.",
      :en
        "Knowledge of stock is a recurring problem in the industry, from the outside we do not suspect to what extent there are inaccuracies. Of course there are industries better than others, but all have a strong interest in improving on the subject. The idea is to create a resilient image of stock from stock movements. We build a stock status from stock events while adding the constraint : a stock item is only in one place, in one state. As much as it is easy to accumulate errors when we count how many products come in and go out, when an individual is equipped with a bar code, we can be much less mistaken. Either the product is not in the place we think because we missed an event (but the next movement will catch up on this error), or the product is definitely out and the aging period, the next inventory will correct this error. Of course the image will not be perfect, but it will be much more resilient."},
   :archi {:en "Architecture", :fr "Architecture"},
   :archi-desc
     {:en "Solution architect and Supply Chain Entreprise Architect (EA)",
      :fr "Architecte solution et architecte entreprise (EA)"},
   :archi-long-desc
     {:en
        "During my job interview at Michelin, I expressed my wish to become an Enterprise Architect (EA) and achieved it. Now I'm a certified TOGAF architect (click on the tile to see the certificate). So I started with the solution architect position to defend some architecture files built with the teams and defend them in front of the architect network. I was dealing with production planning applications (4 applications). Then, I became a Supply Chain business architect to update processes to fit changes in the program I was introducing. Finally, I became an enterprise architect for a Supply Chain (200+ applications for which hundreds of people are working), so I became a prescriber. So I've carried out some studies for C-levels of Michelin groups to propose technical and business transformation that were evaluated to millions of Euros, I've organized software purchasing and promoted projects where some new technologies made sense.",
      :fr
        "Durant mes entretiens d'embauche, j'avais exprimé mon souhait de devenir architecte entreprise (EA). Maintenant je suis un architecte certifié TOGAF (cliquez sur le titre pour voir mon certificat). J'ai donc commencé par faire de l'architecture solution afin de défendre les dossiers d'architecture construits avec les équipes auprès des réseaux d'architecte sur des solutions de planification de la production (4 applications). Puis je suis devenu architecte des processus de la chaîne logistique, et enfin architecte entreprise (200+ applications employant des centaines de personnes), ce qui m'a permis de devenir prescripteur. J'ai donc fait des études pour les exécutifs du groupe Michelin afin de proposer des transformations techniques et métiers de projets et programmes chiffrés en millions d'Euros, animer l'achat de logiciels, promouvoir de nouvelles technologies dans les projets où elles font sens ... "},
   :make-or-buy-optimization {:fr "`Make or buy` en horizon tactique",
                              :en "Tactical planning for make or buy"},
   :make-or-buy-optimization-desc
     {:fr
        "Outil standalone, intégré avec les Excels des utilisateurs optimisant les plans.",
      :en
        "Integrated tooling with users' spreadsheet which is optimizing their plans."},
   :make-or-buy-optimization-long-desc
     {:fr
        [:<>
         [:p
          "Ce qui est appelé renfort textile est un matériau complexe qui entre dans la composition du pneu, il est soit fabriqué, soit acheté par le groupe Michelin. Signer des contrats fixant à l'avance les prix entre un volume minimum et un maximum, et remplir les usines internes sont deux objectifs contradictoires avec les évolutions du marché. Ce problème est complexe à résoudre et j'ai pu utiliser le cadriciel de mon doctorat pour résoudre ce problème en une semaine. La solution est restée au moins une dizaine d'années en production."]
         [:p
          "Pour assister les décideurs, j'ai développé un moteur d'optimisation améliorant leur plan de production précédent."]
         [:h3 "Technologies"] [:p "C++, BCOOLIB"]],
      :en
        [:<>
         [:p
          "What is called textile reinforcement is a complex material that goes into the composition of the tire, it is either manufactured or purchased by the Michelin group. Signing contracts fixing prices in advance between a minimum and a maximum volume, and filling internal factories are two objectives contradictory to market developments. This problem is complex to solve and I was able to use the framework of my doctorate to solve this problem in a week. The solution remained in production for at least ten years."]
         [:p
          "To assist decision-makers, I developed an optimization engine improving their previous production plan."]
         [:h3 "Technologies"] [:p "C++, BCOOLIB"]]},
   :distribution-network {:fr "Sourcing de distribution",
                          :en "Distribution sourcing"},
   :distribution-network-desc
     {:fr
        [:<>
         " Flot maximum pour optimiser le réseau de distribution de Michelin"],
      :en "Graph flow optimization to optimize Michelin distribution network"},
   :distribution-network-long-desc
     {:fr
        [:<>
         [:p
          "Alors qu'un bug non anticipé est apparu en plein déploiement, et pour ne pas mettre à l'arrêt un programme impliquant une centaine de personnes, j'ai dû réécrire en urgence des algorithmes d'optimisation de flot qui calcule et optimise le réseau de distribution de Michelin (des millions de couple produits/location). En PLSQL pour s'intégrer facilement à l'architecture, j'ai en deux semaines réécrit ces algorithmes qui sont toujours en production une dizaine d'années après."]
         [:h3 "Technologies"] [:p "Oracle PLSQL"]],
      :en
        [:<>
         [:p
          "An unanticipated bug appeared in the middle of deployment, and in order not to stop a program involving a hundred people, I had to urgently rewrite flow optimization algorithms that calculate and optimize the Michelin distribution network (millions of product/location pairs). In PLSQL to easily integrate into the architecture, I rewrote these algorithms in two weeks, which are still in production ten years later."]
         [:h3 "Technologies"] [:p "Oracle PLSQL"]]},
   :dss {:en "Decision support system", :fr "Outils d'aide à la décision"},
   :dss-desc
     {:en "Production-ready optimization tools and prototypes during the PhD.",
      :fr
        "Outil d'optimisation en production et prototypes dans le cadre du doctorat."},
   :dss-long-desc
     {:en
        [:<>
         [:p
          "I developed decision support tools: CPFERV for the scheduling of spare parts workshops at PSA, a scheduling tool for hot forging workshops at Aubert & Duval and SMPP for planning for about twenty Michelin tire factories. I also developed prototypes: planning of Péchiney rolling mills, planning of Michelin tire test tracks. This includes optimization engines, user interfaces to enter data, explore optimization results. Some of them were done completely independently, others in a small team."]
         [:h3 "Technologies"]
         [:p "C++, Borland C++ VCL, BCOOLIB, Visual Basic, Microsoft OCX"]],
      :fr
        [:<>
         [:p
          "J'ai développé des outils d'aide à la décision : CPFERV pour l'ordonnancement des ateliers de pièces de rechange à PSA, un outil d'ordonnancement des ateliers de forge à chaud d'Aubert & Duval et SMPP pour la planification pour une vingtaine de manufacture pneumatique de Michelin. J'ai aussi développé des prototypes : planification des lamineurs de Péchiney, planification des pistes de tests de pneumatique de Michelin. Cela inclut les moteurs d'optimisation, des interfaces utilisateurs pour saisir les données, explorer les résultats d'optimisation. Certains d'entre eux étaient fait en complète autonomie, d'autres en petite équipe."]
         [:h3 "Technologies"]
         [:p "C++, VCL de Borland C++, BCOOLIB, Visual Basic, Microsoft OCX"]]},
   :bcoo {:fr "BCOOLIB", :en "BCOOLIB"},
   :bcoo-desc {:fr "Bibliothèque de Composants d’Optimisation orientée Objets",
               :en "Object oriented optimization components library"},
   :bcoo-long-desc
     {:fr
        [:<>
         "Tout mon savoir-faire en recherche opérationnelle pour l'industrie que j'ai acquis en thèse a été inclus dans cette bibliothèque. L'objectif était de capitaliser et d'accélérer le développement des projets ultérieurs. Cet objectif a été atteint car il a été le support des articles de recherches, mais aussi de la plupart des applications industrielles."
         [:h3 "Technologies"] [:p "C++, VCL de Borland C++"]],
      :en
        [:<>
         "All my know-how in operational research for industry that I acquired in my thesis was included in this library. The objective was to capitalize and accelerate the development of subsequent projects. This objective was achieved because it was the support for research articles, but also for most industrial applications."
         [:h3 "Technologies"] [:p "C++, VCL from Borland C++"]]},
   :jewelry-website {:en "Jewelry e-commerce",
                     :fr "Site e-ecommerce de bijouterie"},
   :jewelry-website-desc {:en "Php5 - mysql paradox db - Borland C++",
                          :fr "Php5 - mysql paradox db - Borland C++"},
   :jewelry-website-long-desc
     {:en
        [:<>
         [:p
          "To complement the activity of a family jewelry store, I built an online sales site. The site was in operation for about three years, until the physical store was profitable and preferred."]
         [:p
          "The website was built in php/mysql, generating dynamic pages on the server based on customer requests and the content of the database. The formatting was done manually in css, at a time when the standardization of different browsers made the subject difficult. A backend in Borland C++ allowed to manage and download the product catalog. The site offered payment and CMS functionalities, in order to delegate part of its update."]
         [:h3 "Technologies"] [:p "Php, mysql, Borland C++"]],
      :fr
        [:<>
         [:p
          "Pour compléter l'activité d'une bijouterie familiale, j'ai construit un site de vente en ligne. Le site a été en fonction pendant environ trois ans, jusqu'à ce que le magasin physique soit rentable et privilégié."]
         [:p
          "Le site web a été construit en php/mysql, générant des pages dynamiques sur le serveur en fonction des requêtes des clients et du contenu de la base de données. La mise en forme manuellement faite en css, à une époque où la standardisation des différents navigateurs rendaient le sujet difficile. Un backend en Borland C++ permettait de gérer et de télécharger le catalogue produit. Le site offrait des fonctionnalités de paiement et de CMS, afin de déléguer une partie de sa mise à jour."]
         [:h3 "Technologies"] [:p "Php, mysql, Borland C++"]]},
   :isima {:fr "ISIMA", :en "ISIMA"},
   :isima-desc
     {:fr
        "Formation initiale : Systèmes d’Information et Aide à la Décision - 1998",
      :en
        "Initial training : Decision Support System and Information System - 1998"},
   :isima-long-desc
     {:fr
        "In my initial training, I learned: ADA, Assembler, C, Fortran, LISP, data structure, Matlab, algorithms, Java, numerical programming, Prolog. These courses are accompanied by two projects and two 6-month internships",
      :en
        "In my initial training, I learned: ADA, Assembler, C, Fortran, LISP, data structure, Matlab, algorithms, Java, numerical programming, Prolog. These courses are accompanied by two projects and two 6-month internships"},
   :jewelry-ecommerce {:en "Jewelry stock management",
                       :fr "Gestion de stock d'une bijouterie"},
   :jewelry-ecommerce-desc {:fr "Un logiciel utilisé quotidiennement",
                            :en "A daily used software"},
   :jewelry-ecommerce-long-desc
     {:fr
        [:<>
         "A une époque où les logiciels de gestion professionnels étaient rares, j'ai construit le logiciel de gestion de stock de la bijouterie familiale afin de maintenir le stock de la bijouterie, faire la caisse, suivre le fichier client. "
         [:h3 "Technologies"] [:p "GFA Basic"]],
      :en
        [:<>
         "At a time when professional management software was rare, I built the inventory management software for the family jewelry store to maintain the jewelry store's stock, do the cash register, and track the customer file. "
         [:h3 "Technologies"] [:p "GFA Basic"]]},
   :demo-making {:fr "Démo et jeux", :en "Demo making and games"},
   :demo-making-desc {:fr "Se faire plaisir en apprenant",
                      :en "Have fun while learning"},
   :demo-making-long-desc
     {:en
        [:<>
         [:p
          "As a self-taught person, I discovered software development by creating games, first in text mode and then in graphic mode. And finally, I spent a lot of time making demos, technically advanced software with an artistic aim: vector balls, rasters, overscans, 3D wireframe."]
         [:p
          "It was a time without Internet, I had few books at my disposal and no software library to facilitate the work. So I had to learn to do everything myself, manage mouse interruptions to draw the cursor, rediscover how to draw lines with divisions by two (register shifts), persistence..."]
         [:h3 "Technologies"]
         [:ul [:li "Z80 Assembler - Amstrad CPC 464"]
          [:li "GFA Basic - Atari ST"]
          [:li "Motorola 68000 Assembler - Atari ST"]]],
      :fr
        [:<>
         [:p
          "En autodidacte, j'ai découvert le développement logiciel en créant des jeux, d'abord en mode texte puis en mode graphique. Et finalement, j'ai passé beaucoup de temps à faire des démos, des logiciels techniquement poussés à visée artistique : des vectors balls, des rasters, des overscans, de la 3D en wireframe."]
         [:p
          "C'était une époque sans Internet, j'avais peu de livres à ma disposition et aucune bibliothèque logicielle pour faciliter le travail. Il fallait donc tout apprendre à faire soi-même, gérer soi-même les interruptions de la souris pour dessiner le curseur, redécouvrir comment tracer des lignes avec des divisions par deux (décalages de registres), la persistance..."]
         [:h3 "Technologies"]
         [:ul [:li "Assembleur Z80 - Amstrad CPC 464"]
          [:li "GFA Basic - Atari ST"]
          [:li "Assembleur Motorola 68000 - Atari ST"]]]}})

(def items
  [[:hephaistox {:href :hephaistox-gh}] [:storrito {}] [:plm {}]
   [:event-stock {:img-url :kafka, :href :seb}] [:archi {:href :togaf}]
   [:make-or-buy-optimization {}] [:distribution-network {}]
   [:dss {:img-url :optimization}] [:bcoo {}]
   [:jewelry-website {:img-url :web-caumond, :href :web-caumond-archive}]
   [:isima {:start "01/09/1998", :end "01/09/2001", :company "ISIMA"}]
   [:jewelry-ecommerce {}] [:demo-making {}]])

(def tr (partial klang/tr dic))

(defn v-it
  [l]
  (let [current-tr (partial tr l)
        cv-items (kvheadered-list/defaulting* items
                                              tr
                                              klinks/image-link
                                              klinks/external-link)]
    [:<> [:h1.text (current-tr :computer-science)]
     [:div.text (current-tr :intro)] [kvspace/vertical-spacing]
     [kvheadered-list/detailed-list (get cv-items l) :small]]))
