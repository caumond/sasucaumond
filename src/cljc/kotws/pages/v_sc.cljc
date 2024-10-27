(ns kotws.pages.v-sc
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]
            [kotws.components.v-headered-list :as kvheadered-list]))

(def dic
  {:sc-title {:fr "Industrie / Chaîne logistique",
              :en "Supply Chain and industry"},
   :intro
     {:en
        "I discovered the supply chain and its issues with my first engineering school internship. The supply chain is a story of people who have to work together. When I have to intervene, it is because there are decisions that can be improved and most of the time, this is because the decision-making process lacks information (scope or freshness). I.T. is king for transmitting information quickly. When the information is correct and the decisions can be improved, it is most of the time the decision is too complex to be made by a human brain, so we make the problem accessible by simplifying it. Operational research is the ideal tool to help with this decision-making use case.",
      :fr
        "J'ai découvert la chaîne logistique et ses problématiques avec mon premier stage d'école d'ingénieur. La chaîne logistique, c'est une histoire d'hommes qui doivent travailler ensemble. Lorsque j'ai à intervenir c'est qu'il y a des décisions qui peuvent être améliorées et la plupart du temps, cela vient du fait que la prise de décisions manquaient d'informations (périmètre ou fraicheur). L'informatique est reine pour faire transiter les informations rapidement. Quand les informations sont correctes et les décisions perfectibles, c'est la plupart du temps que la décision est trop complexe pour être prise par un cerveau humain, on rend donc le problème accessible en le simplifiant. La recherche opérationnelle est l'outil idéal pour aider ces prises de décision."},
   :intro-2
     {:en
        "The last possible case is that supply chain methods advance the company, most of the time by creating new processes. Of course, there are overlaps with operational research or computer science.",
      :fr
        "Le dernier cas possible, c'est que des méthodes de chaîne logistique font progresser l'entreprise, en créant de nouveaux processus la plupart du temps. Bien sûr il y a des adhérences avec la recherche opérationnelle ou l'informatique."},
   :hephaistox {:fr "Hephaistox", :en "Hephaistox"},
   :hephaistox-desc {:fr "Mon offre chaîne logistique pour les PMIs",
                     :en "My SC offer for small and medium-sized enterprises"},
   :hephaistox-long-desc
     {:fr
        "Je vends mes conseils en chaîne logistique avec Hephaistox. C'est une occasion pour moi de continuer à rester en connexion avec l'industrie, à en découvrir d'autres.",
      :en
        "I am selling my supply chain consulting with Hephaistox. It is an opportunity for me to continue to stay connected with the industry, and to discover others."},
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
        "En tant que consultant du progiciel qui délocalise les produits dans le réseau de distribution et par là-même gère les pénuries, j'ai participé au déploiement de ces nouvelles méthodes, paramétrer et accompagner le changement. Le déploiement s'est fait sur plusieurs années et a concerné 90% des ventes de pneumatiques du groupe Michelin.",
      :en
        "As a consultant for the software package that relocates products in the distribution network and thus manages shortages, I participated in the deployment of these new methods, and did setup and change management. The deployment took place over several years and concerned 90% of the Michelin group's tire sales."},
   :jewelry-ecommerce {:fr "Processus de prise de commande",
                       :en "Practical order to cash knowledge"},
   :jewelry-ecommerce-desc
     {:fr "Un des premiers site web joaillier Français - 2006",
      :en "One of the first French jewelry websites - 2006"},
   :jewelry-ecommerce-long-desc
     {:fr
        "J'ai construit un processus de prise de commande intégrant les contraintes de la bijouterie aux débuts du e-commerce. Peu de sites e-commerces comparables existaient, et le coût du panier moyen nécessitait une attention particulière au client et une résistance aux escrocs.",
      :en
        "I built an order-to-cash process that incorporated the constraints of jewelry in the early days of e-commerce. Few comparable e-commerce sites existed, and the cost of the average basket required special attention to the customer and resistance to scammers."},
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
  [[:hephaistox {}] [:plm {}] [:plm-start {}] [:downstream-ope {}]
   [:market-knowledge {}] [:software-purchasing {}] [:apics {}]
   [:upstream-ope {}] [:pp {}] [:drp {}] [:jewelry-ecommerce {}] [:isima {}]])

(defn v-sc
  [l]
  (let [current-tr (partial tr l)
        sc-steps (kvheadered-list/defaulting* items
                                              tr
                                              klinks/image-link
                                              klinks/external-link)]
    [:<> [:h1.text (current-tr :sc-title)] [:div.text (current-tr :intro)]
     [:p ""] [:div.text (current-tr :intro-2)]
     [kvheadered-list/detailed-list (get sc-steps l) :small] [:hr]]))
