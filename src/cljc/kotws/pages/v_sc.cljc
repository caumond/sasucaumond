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
   :plm {:en "Product owner of an in-house PLM",
         :fr "Cycle de vie produit (PLM)"},
   :plm-desc {:fr "Construction d'un PLM (Product Lifecycle Management)",
              :en "Building an in-house PLM"},
   :plm-long-desc
     {:fr
        "Une fois la vision connue et partagée, la première étape a été de lever les 30 millions d'Euros nécessaires, identifier la première marche à gravir (think big, start small, roll out fast), trouver des clients intéressés et monter l'équipe. A l'époque constituée d'une petite dizaine de personnes, construire l'équipe a été une gageure tant le sujet est difficile à faire émerger.",
      :en
        "Once the vision was known and shared, the first step was to raise the 30 million Euros needed, identify the first step to take (think big, start small, roll out fast), find interested customers, and build the team. At the time made up of about ten people, building the team was a challenge as the subject was difficult to bring out."},
   :plm-start {:fr "Un PLM de l'amont et l'aval",
               :en "Creation, selling, and materialization of the vision"},
   :plm-start-desc {:fr "Orienter le groupe dans son prochain grand programme",
                    :en "Guiding the group in its next major program"},
   :plm-start-long-desc
     {:en
        "A PLM is a product lifecycle management tool, that allows you to create a repository of products, ranges, and bills of materials and to manage the changes of each and their possible impacts on the rest of the production chain. The two programs I participated in dealt with their bill of materials, leaving untouched the 60 tire manufacturing plants - the heart of Michelin's added value. In a team of three people, I was an important, committed, and exposed collaborator in building this vision, presenting it, taking the comments and bringing out a consensual but meaningful synthesis.",
      :fr
        "Un PLM est un outil de gestion du cycle de vie du produit, permettant de créer un référentiel de produits, gammes et nomenclatures et de gérer les évolutions de chacun et leurs éventuels impacts sur le reste de la chaîne de production. Les deux programmes auquel j'ai participé traiter de leur nomenclature, il restait les 60 usines de construction de pneus, le coeur de la valeur ajoutée de Michelin. Dans une équipe de trois personnes, j'ai été un collaborateur important, engagé et exposé pour construire cette vision, l'exposer, prendre les remarques et faire émerge une synthèse consensuelle mais pleine de sens."},
   :downstream-ope {:fr "Etudes cadres d'un programme de transformation majeur",
                    :en "Framework studies for a major transformation program"},
   :downstream-ope-desc
     {:en "Framing another program worth several tens of millions of euros",
      :fr "Cadrage d'un autre programme de plusieurs dizaines de millions d'€"},
   :downstream-ope-long-desc
     {:en
        "As a team member of the architecture team of the OPE program (cf. the hyperlink), we were in charge of finding business, and I.T. solutions when they concerned many teams and metiers. The missions are: to define interactions between metiers and supervise project execution.
        Some studies illustrate this activity: Offtakers integration in group process, taking group strategy, fiscality, customs, and logistics into account.",
      :fr
        "Participant à l'équipe d'architecture du programme OPE (cf. le lien), nous avions en charge de trouver des solutions (métiers et informatiques) quand elles font évoluer plusieurs métiers et équipes. Les missions: cadrer les interactions entre les métiers, superviser l'exécution des projets. Quelques études illustrant les activités:
l'intégration de la sous traitance dans les sociétés du group en prenant en compte la stratégie du groupe, la fiscalité et la logistique. L'intégration d'activités post manufacturing dans le réseau de distribution. L'intégration des contraintes des fabricants des équipements d'origine (OEM qui représente un tiers du chiffre d'affaire du groupe en Europe)."},
   :market-knowledge
     {:en "Knowledge of the main Supply Chain software package",
      :fr "Connaissance des principaux progiciels de la chaîne logistique"},
   :market-knowledge-long-desc
     {:fr
        "Ce poste a été l'occasion de rencontrer régulièrement les principaux vendeurs de logiciels de chaîne logistique: OMP, JDA, ORACLE, INFOR et d'approfondir leurs offres.",
      :en
        "That position was an opportunity to meet the main Supply Chain software vendors: OMP, JDA, ORACLE, and INFOR, but also to understand their offers."},
   :market-knowledge-desc
     {:en "Supply Chain Professionals Network",
      :fr "Réseau des professionnels de la chaîne logistique"},
   :software-purchasing {:fr "Achat de logiciel de chaîne logistique",
                         :en "Supply Chain software package purchasing"},
   :software-purchasing-desc {:fr "Négocier du logiciel",
                              :en "Software trading"},
   :software-purchasing-long-desc
     {:en
        "As an enterprise architect, I was the focal point for major software license purchases in the supply chain domain. A JDA S&OP module (see article in the link), a project on an ERP specialized in the automotive industry for integration with automotive customers and their specificities. An integrated supply chain tool for a subsidiary. This consists of writing documents related to the supplier (Request for Information, Request for Quotation, Request for Proposal), `RFI/RFQ/RFP`, aligning actors for decision-making, and software purchase.",
      :fr
        "En tant qu'architecte entreprise, j'étais le point focal pour les achats majeurs de licence logicielle en chaîne logistique. Un module S&OP de JDA (cf. article dans le lien), un projet sur un ERP spécialisé dans l'automobile pour intégration avec les clients automobiles et leurs spécificités. Un outil de chaîne logistique intégré pour une filiale. Cela consiste dans la rédaction des documents en lien avec le fournisseur (Request for Information, Request for Quotation, Request for Proposal), `RFI/RFQ/RFP`, aligner les acteurs pour la prise de décision, l'achat du logiciel."},
   :apics {:fr "Certification BASICS à l'APICS",
           :en "Certification for BASICS - APICS"},
   :apics-desc {:fr "BASICS acquis, niveau CPIM",
                :en "BASICS acquired, CPIM level"},
   :apics-long-desc
     {:en
        "I was certified with MGCM with a BASICS level of APICS. Supply chain oriented, dealing with methods and tools, this training gives a comprehensive panorama of the supply chain. I followed and learned the main part of the CPIM but had to stop to focus on the upstream program which was running in parallel.",
      :fr
        "J'ai été certifié par MGCM pour le niveau BASICS de l'APICS. Orientée chaîne logistique, outils et méthodes, cette formation fournit un panorama complet du sujet. J'ai travaillé une bonne partie du CPIM mais eu dû arrêter pour privilégier le programme amont qui se déroulait en parallèle."},
   :upstream-ope {:fr "Transformation métier", :en "Business transformation"},
   :upstream-ope-desc
     {:fr "Dans l'équipe coeur d'un programme de 60 millions d'Euros",
      :en "In the core team of a 60 million Euro program"},
   :upstream-ope-long-desc
     {:fr
        "Au démarrage du programme OPE, les 60 sites de production de semi-finis sont gérés complétement localement. Ma contribution consiste à concevoir les processus de la chaîne logistique, construire le modèle de planification dans un PLM, intégrer la planification avec l'ERP et l'outil de gestion de magasin (WMS). Dans une position très exigeante, j'ai dû aligner avec des équipes engagées, souvent tendues et être un acteur majeur de l'arrêt du programme tel qu'il était et de son redémarrage dans une nouvelle forme.",
      :en
        "At the start of the OPE program, the 60 semi-finished production sites are managed entirely locally. My contribution consists of designing the supply chain processes, building the planning model in a PLM, and integrating planning with the ERP and the warehouse management tool (WMS). In a very demanding position, I had to align with committed, often tense teams and be a major player in stopping the program as it was and restarting it in a new form."},
   :pp {:fr "Expert planning de production",
        :en "Production and distribution planning"},
   :pp-desc
     {:fr
        "Expert (solution consultant) d'une application de master planning des usines produits finis",
      :en
        "Expert (solution consultant) of a master planning application for finished product factories"},
   :pp-long-desc
     {:fr
        "Déploiement sur des usines d'Asie et d'Amérique du sud. Construction et déploiement d'une solution de planification de production automatique, accompagnement d'une usine en construction dans la fabrication de planning robuste pour son démarrage.",
      :en
        "Deployment in factories in Asia and South America. Construction and deployment of an automatic production planning solution, and support for a factory under construction in the production of robust planning for its start-up."},
   :drp {:fr "Expert planning de distribution - DRP",
         :en "Distribution Resource Planning expert - DRP"},
   :drp-desc {:fr "Expert du progiciel de Manugistics",
              :en "Manugistics software package expert"},
   :drp-long-desc
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
           "Outil d’optimisation du réseau de distribution (Busaker & Gowen). Cet outil calcule hebdomadairement, depuis plus de 10 ans, pour des dizaines de milliers de références, centre de distribution est alimenté de quelle usine."]
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
        "Aux débuts du e-commerce, j'ai construit seul un site de e-commerce en bijouterie. Peu de sites e-commerces comparables existaient, il fallait donc tout inventer. En particulier, le coût du panier moyen nécessitait une attention particulière au client et une résistance aux escrocs.",
      :en
        "In the early days of e-commerce, I built a jewelry e-commerce site on my own. Few comparable e-commerce sites existed, so we had to invent everything. In particular, the cost of the average basket required special attention to the customer and resistance to scammers."},
   :isima {:fr "Ecole d'ingénieur", :en "Engineering school"},
   :isima-desc
     {:fr
        "ISIMA - Filière simulation, modélisation et optimisation des systèmes industriels.",
      :en
        "ISIMA - Simulation, modeling, and optimization of industrial systems"},
   :isima-long-desc
     {:en
        "At school, I've learned the basics of modeling, complex system simulation, production systems, and operational research: Markov chain, constraint and linear programming, heuristics, and metaheuristics.",
      :fr
        "A l'école, j'ai appris les rudiments de la modélisation, de la simulation des systèmes complexes, des systèmes de production et de recherche opérationnelle: les chaînes de Markov, programmation par contraintes, programmation linéaire,  heuristiques et métaheuristiques."}})

(def tr (partial klang/tr dic))

(def items
  [[:hephaistox {:company "SASU Caumond", :start ""}]
   [:plm {:company "Michelin", :start "", :end "31/10/2021"}]
   [:ea {:company "Michelin", :start "", :end ""}]
   [:downstream-ope {:company "Michelin", :start "", :end ""}]
   [:market-knowledge {:company "Michelin", :start "", :end ""}]
   [:software-purchasing {:company "Michelin", :start "", :end ""}]
   [:apics {:company "Michelin", :start "", :end ""}]
   [:upstream-ope {:start "01/07/2008", :end "01/04/2013", :company "Michelin"}]
   [:pp {:start "01/07/2008", :end "01/04/2013", :company "Michelin"}]
   [:drp {:start "01/06/2006", :end "01/07/2008", :company "Unilog"}]
   [:jewelry-ecommerce {:start "01/05/2005", :end "01/07/2007"}]
   [:isima {:start "01/09/1998", :end "01/09/2001", :company "ISIMA"}]])

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
