(ns kotws.pages.v-sc
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]
            [kotws.components.v-space :as kvspace]
            [kotws.components.v-headered-list :as kvheadered-list]))

(def dic
  {:sc-title {:fr "Industrie / Chaîne logistique",
              :en "Supply Chain and industry"},
   :intro
     {:en
        [:<>
         [:p
          "I see the Supply Chain as a story of people whose collaboration we want to improve, in the interest of the Company. The main tool for this is to have the right data in the right place and at the right time. This is why I have cultivated my skills in IT and mathematical optimization. As a consultant, I consider that my job is:"]
         [:ul
          [:li
           "To choose the tools and methods adapted to your problem, whether in terms of cost, burden on people, available data and their quality."]
          [:li
           "To implement these tools and methods, with a high degree of requirement in the management of change and the ergonomics of the tools."]]
         [:p
          "Through my experience in various contexts (individual company, small workshops, industrial group, research team), and in different industries (automobile, jewelry, metallurgy, ...), I feel ready to take on all challenges, from the simplest problem to complex problems, even very complex."]
         [:p
          "I am able to work in the field, with managers and senior executives on objectives and framing, and to ensure the link between the two. Direct by nature, I prefer to \"agree on our disagreements\" than to remain silent. Indeed, the supply chain must make communications fluid, I try to do the same. Pragmatic, I would still do with the reality on the ground."]],
      :fr
        [:<>
         [:p
          "Je vois la chaîne logistique comme une histoire d'Hommes dont on veut améliorer la collaboration, dans l'intérêt de l'Entreprise. L'outil majeur pour cela est d'avoir la bonne donnée au bon endroit et au bon moment. C'est pourquoi j'ai cultivé mes compétences en informatique et optimisation mathématique. En tant que consultant, je considère que mon métier est :"]
         [:ul
          [:li
           "De choisir les outils et méthodes adaptés à votre problématique, que ce soit en termes de coût, de charge sur les personnes, de données disponibles et de leur qualité."]
          [:li
           "De mettre en place ces outils et méthodes, avec un haut degré d'exigence dans la conduite du changement et l'ergonomie des outils."]]
         [:p
          "Par mon expérience dans des contextes variés (entreprise individuelle, petits ateliers, groupe industriel, équipe de recherche), et dans différentes industries (automobile, bijouterie, métallurgie, ...), je me sens prêt à relever tous les défis, du problème le plus simple aux problèmes complexes, voire très complexes."]
         [:p
          "Je suis capable de travailler sur le terrain, avec des dirigeants et hauts dirigeants sur les objectifs et cadrage, et de m'assurer du lien entre les deux. De nature directe, je préfère \"être d'accord sur nos désaccords\" que de taire. En effet, la chaîne logistique doit rendre fluide les communications, j'essaie de faire même. Pragmatique, je ferais quand même avec la réalité du terrain."]]},
   :hephaistox {:fr "Hephaistox", :en "Hephaistox"},
   :hephaistox-desc {:fr "Mon offre chaîne logistique pour les PMIs",
                     :en "My SC offer for small and medium-sized enterprises"},
   :hephaistox-long-desc
     {:fr
        [:<>
         [:p
          "Hephaistox est une offre en cours de préparation. Dans laquelle, j'ai appris la création d'entreprise, la prospection et l'élaboration d'une solution cloud."]
         [:p
          "Co-fondé avec mati, développeur de haut niveau, Hephaistox complète le \"conseil\" par une offre logicielle et méthodologique pour conforter les industriels dans leur prise de décision, afin d'aligner les équipes sur un même scénario."]
         [:p "Les projets peuvent être:"]
         [:ul [:li "Achat de machine,"]
          [:li "Installation d'une nouvelle gamme de produits,"]
          [:li "La reconfiguration d'un atelier,"]
          [:li "La signature de contrat d'achat cadre."]]
         [:p "Les méthodes sont:"]
         [:ul
          [:li
           "la modélisation, une méthode scientifique pour limiter l'effort à ce qui est important,"]
          [:li
           "l'optimisation, une méthode mathématique pour chercher une bonne solution,"]
          [:li
           "la simulation pour confronter les hypothèses à leur vraissamblance interne et vis-à-vis des experts."]]],
      :en
        [:<>
         [:p
          "Hephaistox is an offer currently being prepared in which I learned about business creation, prospecting and the development of a cloud solution."]
         [:p
          "Co-founded with mati, a high-level developer, Hephaistox completes the \"consulting\" with a software and methodological offer to support manufacturers in their decision-making, in order to align teams on the same scenario."]
         [:p "Projects can be:"]
         [:ul [:li "Purchase of machine,"]
          [:li "Installation of a new range of products,"]
          [:li "Reconfiguration of a workshop,"]
          [:li "Signing a framework purchase contract."]]
         [:p "The methods are:"]
         [:ul
          [:li
           "modeling, a scientific method to limit the effort to what is important,"]
          [:li "optimization, a mathematical method to find a good solution,"]
          [:li
           "simulation to confront hypotheses with their internal plausibility and with respect to experts."]]]},
   :plm {:en "Product manager of an in-house PLM",
         :fr "Chef projet de l'outil de cycle de vie produit (PLM)"},
   :plm-desc
     {:fr
        "Un PLM est un outil de gestion du cycle de vie du produit, permettant de créer un référentiel de produits, gammes et nomenclatures et de gérer les évolutions de chacun et leurs éventuels impacts sur le reste de la chaîne de production.",
      :en
        "A PLM is a product lifecycle management tool, allowing you to create a repository of products, ranges and nomenclatures and to manage the developments of each and their possible impacts on the rest of the production chain."},
   :plm-long-desc
     {:fr
        [:<>
         [:p
          "Suite à mon expérience d'architecte métier sur le programme OPE amont, j'ai acquis une vision précise de ce que devait être les références produits pour les usines de produits finis. Les deux programmes auquel j'ai participé ont géré leur nomenclature, il restait les 60 usines de fabrication de pneus, le coeur de la valeur ajoutée de Michelin."]
         [:ul
          [:li
           "Chef de projet: j'ai trouvé un premier client, un périmètre raisonnable, construit une équipe métier et informatique,"]
          [:li
           "Responsable produit: construire la vision technico-fonctionnelle du nouveau processus et son outillage"]]
         [:p
          "Sur un sujet tellement technique, c'était une gageure de partager une vision, avec les décideurs, les clients et les équipes internes."]],
      :en
        [:<>
         [:p
          "Following my experience as a business architect on the upstream OPE program, I acquired a precise vision of what the product references should be for the finished product factories. The two programs I participated in managed their nomenclature, all that remained were the 60 tire manufacturing plants, the heart of Michelin's added value."]
         [:ul
          [:li
           "Project manager: I found a first customer, a reasonable scope, built a business and IT team,"]
          [:li
           "Product manager: build the technical-functional vision of the new process and its tools"]]
         [:p
          "On such a technical subject, it was a challenge to share a vision with decision-makers, customers and internal teams."]]},
   :downstream-ope-long-desc
     {:en
        "As a team member of the architecture team of the OPE program (cf. the hyperlink), we were in charge of finding business, and I.T. solutions when they concerned many teams and metiers. The missions are: to define interactions between metiers and supervise project execution.
        Some studies illustrate this activity: Offtakers integration in group process, taking group strategy, fiscality, customs, and logistics into account.",
      :fr
        "Participant à l'équipe d'architecture du programme OPE (cf. le lien), nous avions en charge de trouver des solutions (métiers et informatiques) quand elles font évoluer plusieurs métiers et équipes. Les missions: cadrer les interactions entre les métiers, superviser l'exécution des projets. Quelques études illustrant les activités:
l'intégration de la sous traitance dans les sociétés du group en prenant en compte la stratégie du groupe, la fiscalité et la logistique. L'intégration d'activités post manufacturing dans le réseau de distribution. L'intégration des contraintes des fabricants des équipements d'origine (OEM qui représente un tiers du chiffre d'affaire du groupe en Europe)."},
   :ea {:fr "Architecte Entreprise (EA) de la chaîne logistique",
        :en "Supply chain entreprise Architect (EA)"},
   :ea-desc {:fr "Responsable groupe de l'architecture de la chaîne logistique",
             :en "Group Manager of Supply Chain Architecture"},
   :ea-long-desc
     {:fr
        [:<>
         [:div
          "L’architecture entreprise (EA) est le poste que j’ai visé en démarrant ma carrière chez Michelin car il permet d’avoir une vision d’ensemble des logiciels de la chaîne logistique du groupe Michelin, et d’animer, d’influencer leurs décisions structurantes."]
         [:ul [:li "Études niveau exécutifs,"]
          [:li
           "Animer l’achat de progiciels, point focal pour les achats majeurs de licence logicielle: rédaction des documents en lien avec le fournisseur (Request for Information, Request for Quotation, Request for Proposal), `RFI/RFQ/RFP`, aligner les acteurs pour la prise de décision."
           [:ul
            [:li
             "Un projet sur un ERP spécialisé dans l'automobile pour intégration avec les clients automobiles et leurs spécificités"]
            [:li
             "Un module de JDA pour le processus Sales & Operation du groupe,"]
            [:li "Un outil de chaîne logistique intégré pour une filiale"]]]
          [:li
           "Étude de cadrage pour le programme de transformation OPE aval (un programme à plusieurs dizaines de millions). J'étais intégré dans la petite équipe d'architecture du programme OPE pour définir les solutions inter-applications et inter-métiers. Quelques études illustrant les activités:"
           [:ul
            [:li
             "L'intégration de la sous traitance dans les sociétés du group en prenant en compte la stratégie du groupe, la fiscalité et la logistique."]
            [:li
             "L'intégration d'activités post manufacturing dans le réseau de distribution."]
            [:li
             "L'intégration des contraintes des fabricants des équipements d'origine (OEM qui représente un tiers du chiffre d'affaire du groupe en Europe)"]]]
          [:li
           "Cadrage de l’outil de planification des ventes et des opérations (S&OP)"]
          [:li
           "Intelligence Artificielle pour la chaîne logistique: contrairement à l'avis initial du management, faire comprendre l'intérêt économique et compétitif de préférer créer une équipe interne que d’acheter du logiciel"]
          [:li
           "Faire et entretenir son réseau parmi les vendeurs de logiciels de chaîne logistique: OMP, JDA, ORACLE, INFOR, ..."]]],
      :en
        [:<>
         [:div
          "Enterprise Architecture (EA) is the position I aimed for when I started my career at Michelin because it allows me to have an overview of the software in the Michelin group's Supply Chain, and to lead and influence their structuring decisions."]
         [:ul [:li "Executive level studies,"]
          [:li
           "Lead the purchase of software packages, focal point for major software license purchases: drafting documents in connection with the supplier (Request for Information, Request for Quotation, Request for Proposal), `RFI/RFQ/RFP`, aligning stakeholders for decision-making."
           [:ul
            [:li
             "A project on an ERP specialized in the automobile industry for integration with automobile customers and their specificities"]
            [:li "A JDA module for the group's Sales & Operation process,"]
            [:li "An integrated supply chain tool for a subsidiary"]]]
          [:li
           "Scoping study for the downstream OPE transformation program (a program worth several tens of millions). I was integrated into the small OPE program architecture team to define inter-application and inter-business solutions. Some studies illustrating the activities:"
           [:ul
            [:li
             "The integration of subcontracting in the group companies by taking into account the group's strategy, taxation and logistics."]
            [:li
             "The integration of post-manufacturing activities in the distribution network."]
            [:li
             "The integration of the constraints of the original equipment manufacturers (OEM which represents a third of the group's turnover in Europe)"]]]
          [:li "Scoping of the sales and operations planning tool (S&OP)"]
          [:li
           "Artificial Intelligence for the supply chain: contrary to the initial opinion of management, make people understand the economic and competitive interest of preferring to create an internal team rather than buying software"]
          [:li
           "Build and maintain your network among supply chain software vendors: OMP, JDA, ORACLE, and INFOR"]]]},
   :apics {:fr "Certification BASICS à l'APICS",
           :en "Certification for BASICS - APICS"},
   :apics-desc {:fr "BASICS acquis, niveau CPIM",
                :en "BASICS acquired, CPIM level"},
   :apics-long-desc
     {:en
        "I was certified with MGCM with a BASICS level of APICS (certification not renewed). Supply chain oriented, dealing with methods and tools, this training gives a comprehensive panorama of the supply chain. I followed and learned the main part of the CPIM but had to stop to focus on the upstream program which was running in parallel.",
      :fr
        "J'ai été certifié par MGCM pour le niveau BASICS de l'APICS (certification non renouvelée). Orientée chaîne logistique, outils et méthodes, cette formation fournit un panorama complet du sujet. J'ai travaillé une bonne partie du CPIM mais eu dû arrêter pour privilégier le programme amont qui se déroulait en parallèle."},
   :business-archi-upstream-ope {:fr "Architecte métier",
                                 :en "Business transformation"},
   :business-archi-upstream-ope-desc
     {:fr "Dans l'équipe coeur d'un programme de 60 millions d'Euros",
      :en "In the core team of a 60 million Euro program"},
   :business-archi-upstream-ope-long-desc
     {:fr
        [:<>
         "Un architecte métier construit les processus d'une transformation, il imagine les processus qui savent tirer partie de l'informatique."
         [:ul
          [:li
           "Au démarrage du programme OPE, les 60 sites de production de semi-finis sont gérés complètement localement. La surcapacité et la flexibilité de cette industrie fait qu'elle s'adapte. Mais les à-coups du marché et les contraintes de matières premières amènent de nouveaux changements. Ma contribution consiste à concevoir les processus de la chaîne logistique, construire le modèle de planification dans un PLM, intégrer la planification avec l'ERP et l'outil de gestion de magasin (WMS). Dans une position très exigeante, j'ai dû aligner avec des équipes engagées, souvent tendues et être un acteur majeur de l'arrêt du programme tel qu'il était et de son redémarrage dans une nouvelle forme : "]
          [:li
           "Architecture Business, construction du modèle de données de planification"]
          [:li "Process leader pour le planning de production "]]
         [:p
          "Le modèle de planification est un élément majeur de transformation du programme, car les références produit étaient fortement empruntes de connaissances non formelles, foncièrement inadaptées aux solutions informatiques. J'ai fait émergé ces concepts et réconcilié des visions très différentes. D'un point de vue technique industrielle, on ne sait pas homologuer et qualifier un produit à l'avance pour tous ses usages. Ce qui rends la notion de référence produit très particulière."]],
      :en
        [:<>
         "A business architect builds the processes of a transformation, he imagines the processes that know how to take advantage of IT."
         [:ul
          [:li
           "At the start of the OPE program, the 60 semi-finished production sites are managed entirely locally. The overcapacity and flexibility of this industry allow it to adapt. But market fluctuations and raw material constraints bring new changes. My contribution consists of designing the supply chain processes, building the planning model in a PLM, integrating planning with the ERP and the warehouse management tool (WMS). In a very demanding position, I had to align with committed, often tense teams and be a major player in stopping the program as it was and restarting it in a new form: "]
          [:li "Business Architecture, construction of the planning data model"]
          [:li "Process leader for production planning "]]
         [:p
          "The planning model is a major element in the transformation of the program, because the product references were heavily borrowed from non-formal knowledge, fundamentally unsuited to IT solutions. I brought out these concepts and reconciled very different visions. From an industrial technical point of view, we do not know how to approve and qualify a product in advance for all its uses. Which makes the notion of product reference very particular."]]},
   :pp-consultant {:fr "Expert et architecte planification de production",
                   :en "Production Planning Expert and Architect"},
   :pp-consultant-desc
     {:fr "Expert (solution consultant) d'une application de master planning",
      :en "Expert (solution consultant) of a master planning application"},
   :pp-consultant-long-desc
     {:fr
        [:<>
         [:p
          "SMPP était l'outil automatisé de planification de production des manufactures de produits finis de Michelin. Comme premier poste avec un contrat Michelin, il était donc naturel de devenir le consultant interne référent sur la planification de production. A ce poste, j'ai donc réalisé les missions suivantes :"]
         [:ul
          [:li
           "Formation métier à la planification de production et à l'outil,"]
          [:li
           "Déploiement sur deux usines asiatiques et une d'Amérique du sud."]
          [:li
           "Modifier l'outil SMPP pour assister le démarrage de l'usine prévue pour le marché d'Amérique du sud,"]
          [:li
           "Puis cadrer le démarrage d'un outil de planification sur les 60 usines de semi-finis."]]],
      :en
        [:<>
         [:p
          "SMPP was the automated production planning tool for Michelin's finished product factories. As my first position with a Michelin contract, it was therefore natural to become the internal consultant responsible for production planning. In this position, I therefore carried out the following missions:"]
         [:ul [:li "Training in production planning and the tool,"]
          [:li "Deployment on two Asian factories and one in South America."]
          [:li
           "Modify the SMPP tool to support the start-up of the factory planned for the South American market,"]
          [:li
           "Then assist the start-up of a planning tool on the 60 semi-finished factories."]]]},
   :deployment-consultant {:fr "Expert planning de distribution - DRP",
                           :en "Distribution Resource Planning expert - DRP"},
   :deployment-consultant-desc {:fr "Expert du progiciel de Manugistics",
                                :en "Manugistics software package expert"},
   :deployment-consultant-long-desc
     {:fr
        [:<>
         "J’ai commencé ma carrière dans le privé en devenant expert en planification de la distribution. La planification de distribution gére:"
         [:ul
          [:li
           "la demande à chaque point de vente / référence par comparaison entre les prévisions de vente et ce qui a été réellement vendu,"]
          [:li
           "la couverture des aléas par les \"normes de stock\". La remontée du besoin en prenant en compte les temps de transports, et des stocks déjà disponibles dans le réseau de distribution,"]
          [:li
           "ce qui est réellement disponible en démarrant par ce qui est promis par l'industrie (c'est à dire le besoin remonté contraint par les capacités industrielles),"]
          [:li
           " la gestion des pénuries et donc comment un manque de stock est priorisé entre deux destinations (en fonction des clients, des niveaux de stocks, …)."]]
         [:p ""]
         [:p
          "En tant qu'expert, j'étais la personne qui assurait que les besoins étaient pris en compte correctement par l'outil et en même temps faire évoluer cette demande pour mieux prendre en compte les nouvelles possibilités de l'outil. Ce déploiement a été réalisé sur environ 90% de la valeur de la production Michelin."]
         [:p ""]
         [:p
          "En parallèle de mes postes, j’ai développé deux outils d’optimisation utilisés en production sur plus de dix ans :"]
         [:ul
          [:li
           "Outil d’optimisation du réseau de distribution (Busaker & Gowen). Toutes les semaines depuis plus de 10 ans, cet outil calcule le réseau de distribution pour des dizaines de milliers de références. Ainsi, il est défini quel centre de distribution est alimenté par quel autre, jusqu'à remonter à l'usine qui produit l'articles."]
          [:li
           "Outil d’optimisation pour décider quoi acheter et quoi fabriquer (Make or buy) sur les fibres textiles, en fonction de l'évolution du besoin, du réalisé, et des contrats."]]],
      :en
        [:<>
         "I started my career in the private sector by becoming an expert in distribution planning. Distribution planning manages:"
         [:ul
          [:li
           "demand at each point of sale / reference by comparing sales forecasts and what was actually sold,"]
          [:li
           "covering unexpected events by \"stock norms\". Calculating the need by taking into account transport times and stocks already available in the distribution network,"]
          [:li
           "what is actually available by starting with what is promised by the industry (i.e. the need constrained by industrial capacities),"]
          [:li
           "shortage management and therefore how a lack of stock is prioritized between two destinations (depending on customers, stock levels, etc.)."]]
         [:p ""]
         [:p
          "As an expert, I was the person who ensured that needs were taken into account correctly by the tool and at the same time develop this demand to better take into account the new possibilities of the tool. This deployment was carried out on approximately 90% of the value of Michelin production."]
         [:p ""]
         [:p
          "In parallel with my positions, I developed two optimization tools used in production for more than ten years:"]
         [:ul
          [:li
           "Distribution network optimization tool (Busaker & Gowen). This tool has been calculating weekly, for more than 10 years, for tens of thousands of references, which distribution center is supplied from which factory."]
          [:li
           "Optimization tool to decide what to buy and what to manufacture (Make or buy) on textile fibers, according to the evolution of the need, the realized, and the contracts."]]]},
   :jewelry-ecommerce {:fr "Processus de prise de commande",
                       :en "Practical order to cash knowledge"},
   :jewelry-ecommerce-desc
     {:fr "Un des premiers site web joaillier Français - 2006",
      :en "One of the first French jewelry websites - 2006"},
   :jewelry-ecommerce-long-desc
     {:fr
        "Aux débuts du e-commerce, j'ai construit seul un site de e-commerce en bijouterie avec son processus de prise de commande (order to cash). Peu de sites e-commerces comparables existaient, il fallait donc tout inventer. En particulier, le coût du panier moyen nécessitait une attention particulière au client et une résistance aux escrocs.",
      :en
        "In the early days of e-commerce, I built solely a jewelery e-commerce site with its order taking process (order to cash). In particular, the cost of the average basket required spectial attention to the customer and resistance to scammers."},
   :phd {:fr "Doctorat en recherche opérationnelle",
         :en "PhD in operation research"},
   :phd-desc {:fr "Découvrir l'industrie à travers la recherche opérationnelle",
              :en "Discovering the industry through operational research"},
   :phd-long-desc
     {:fr
        [:div
         "Grâce à une bourse ministérielle (MENRT) obtenue au mérite pendant le DEA, j'ai eu les conditions idéales pour naviguer entre la théorie et la pratique avec des industries variées:"
         [:ul [:li "PSA : Équilibrage des lignes d'assemblage automobiles."]
          [:li "PSA : Ordonnancement des chantiers polyvalents de ferrage."]
          [:li "ERAMET : Ordonnancement des ateliers de forge à chaud."]
          [:li
           "MICHELIN : Planification automatisée des ateliers de manufacture pneumatiques (déployé sur 20 sites)."]
          [:li "MICHELIN : Planification des pistes de tests."]]
         [:p
          "Ces cas pratiques m'ont permis de découvrir ces industries, d'étudier leurs contraintes afin de proposer des solutions réalistes."]],
      :en
        [:div
         "Thanks to a ministerial scholarship (MENRT) obtained on merit during the DEA, I had the ideal conditions to navigate between theory and practice with various industries:"
         [:ul [:li "PSA: Balancing of automobile assembly lines."]
          [:li "PSA: Scheduling of multipurpose ironwork sites."]
          [:li "ERAMET: Scheduling of hot forging workshops."]
          [:li
           "MICHELIN: Automated planning of tire manufacturing workshops (deployed on 20 sites)."]
          [:li "MICHELIN: Planning of test tracks."]]
         [:p
          "These practical cases allowed me to discover these industries, to study their constraints in order to propose realistic solutions."]]}})

(def tr (partial klang/tr dic))

(def items
  [[:hephaistox {:company :sasu-caumond, :start "31/10/2021"}]
   [:plm
    {:company :michelin,
     :start "01/01/2019",
     :end "31/10/2021",
     :skills [:technical-vulgarisation :plm :project-management
              :executive-coaching]}]
   [:ea
    {:company :michelin,
     :start "01/01/2016",
     :end "01/01/2019",
     :img-url :archi,
     :skills [:ea :software-purchasing :executive-coaching :erp :ia]}]
   [:apics {:company :mgcm, :start "", :end ""}]
   [:business-archi-upstream-ope
    {:start "01/04/2013",
     :end "01/01/2016",
     :company :michelin,
     :skills [:plm :process-modelling :data-modelling :pp],
     :img-url :upstream-ope}]
   [:pp-consultant
    {:img-url :pp,
     :start "01/07/2008",
     :end "01/04/2013",
     :company :michelin,
     :skills [:pp :consulting :architecture]}]
   [:deployment-consultant
    {:img-url :drp,
     :href :drp,
     :start "01/06/2006",
     :end "01/07/2008",
     :company :unilog,
     :skills [:drp :stock-norms :make-or-buy :consulting]}]
   [:jewelry-ecommerce
    {:start "01/05/2005",
     :end "01/07/2007",
     :skills [:o2c :ecommerce :web-development]}]
   [:phd
    {:start "2001",
     :end "2006",
     :company :blaise-pascal-university,
     :skills [:or :scheduling :pp]}]])

(defn v-sc
  [l]
  (let [current-tr (partial tr l)
        sc-steps (kvheadered-list/defaulting* items
                                              tr
                                              klinks/image-link
                                              klinks/external-link)]
    [:<> [:h1.text (current-tr :sc-title)] [:div.text (current-tr :intro)]
     [kvspace/vertical-spacing]
     [kvheadered-list/detailed-list (get sc-steps l) :small] [:p ""]]))

;;TODO Mettre la photo sur malt, et sur le CV
;;TODO Envoyer les mails
;;TODO Post sur linkedin
