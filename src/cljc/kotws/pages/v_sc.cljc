(ns kotws.pages.v-sc
  (:require [kotws.language :as klang]
            [kotws.components.v-headered-list :as kvheadered-list]))

(def dic
  {:hephaistox {:fr "Hephaistox", :en "Hephaistox"},
   :hephaistox-desc {:fr "Mon offre chaîne logistique pour les PMIs",
                     :en "My SC offer for small Entreprises."},
   :hephaistox-long-desc
     {:fr
        "Avec mati, mon associé, nous avons créé Hephaistox pour apporter ces connaissances aux PMIs en mode conseil, cette offre complète aborde tous les aspects d'un projet.",
      :en "Hephaistox"},
   :founder {:fr "Industrie / Chaîne logistique",
             :en "Supply Chain and industry"},
   :introa {:fr "Introduction", :en "Introduction"},
   :intro
     {:en "I've discovered the supply chain with my.",
      :fr
        "J'ai découvert la chaîne logistique et ses problèmes avec mes stages d'école d'ingénieur."},
   :introa-desc
     {:fr
        "L'idée de fonder une entreprise sur la technique m'a longtemps suivi, mais je n'étais ni mûr ni j'avais un sujet sur lequel je voulais démarrer. En sortant de doctorat, j'ai préféré intégrer une Entrerprise comme Michelin qui m'a permis de découvrir de nombreux domaines différnts, tout en étant intégré dans l'Industrie."},
   :plm-start {:fr "Création, promotion et mise en oeuvre de la vision.",
               :en "Creation, selling and materialization the vision"},
   :plm-start-long-desc
     {:en
        "Starting in 2018, my first mission was to build the vision in an Entreprise Architecture study. Then, I communicate that vision to teams and executives to trigger inscription in investments plans. As a product owner and project manager, I looked for customers, build the team and materialize the vision. One of the challenge was to conciliate short and long term ambitions.",
      :fr
        "Commencée en 2018 dans une étude d'architecture Entreprise, ma première mission a été de construire une vision, de la communiquer dans les équipes et aux `executive` pour la faire inscrire dans les plans d'investissement. Puis, en tant que product owner et chef projet, j'ai cherché des premiers clients du produit, monté l'équipe et matéralisé la vision. Un des challenges a été de concilier les ambitions courts et longs termes."},
   :plm {:en "Product owner of an in-house PLM",
         :fr "'Product owner' - Cycle de vie produit (PLM)"},
   :plm-desc {:fr "Construction d'un PLM (Product Lifecycle Management)",
              :en "Building an in-house PLM"},
   :plm-long-desc
     {:fr
        "Un PLM est un outil de gestion du cycle de vie du produit, permettant de créer un référentiel de produits, gammes et nomenclatures.

Management d'une équipe d'une dizaine de personnes",
      :en
        "A PLM is a product lifecycle management tool, providing a product, bill of materials and routings referential.

About ten people to manage"},
   :market-knowledge {:en "Kowledge of main Supply Chain software package",
                      :fr
                        "Connaissance des principaux progiciels Supply Chain"},
   :market-knowledge-desc
     {:fr
        "Ce poste a été l'occasion de rencontrer régulièrement les principaux vendeurs de logiciels Supply Chain: OMP, JDA, ORACLE, INFOR et d'approfondir leurs offres.",
      :en
        "That position was an opportunity to meet main Supply Chain software vendors: OMP, JDA, ORACLE, INFOR and understand their offers."},
   :market-knowledge-long-desc {:fr "", :en ""},
   :downstream-ope {:fr "Etudes cadres d'un programme de transformation majeur",
                    :en "Framework studies for a major transformation program"},
   :downstream-ope-long-desc
     {:en
        "Participant à l'équipe d'architecture du programme OPE (cf. le lien), nous avions en charge de trouver des solutions (métiers et informatiques) quand elles font évoluer plusieurs métiers et équipes. Les missions: cadrer les interactions entre les métiers, superviser l'exécution des projets.
        Some studies to illustrate this activity: Offtakers integration in group process, taking group strategy, fiscality, customs and logistics into account. Study on OPE transformation program next step on finished product plants.",
      :fr
        "As a team member of the architecture team of OPE program (cf. the hyperlink), we had in charge to find business and I.T. solutions when they concern many teams and metiers. The missions are: define interactions between metiers, supervise projects execution."},
   ; ********************************************************************************
   :software-purchasing {:fr "Achat de logiciel de chaîne logistique",
                         :en "Supply Chain software package purchasing"},
   :software-purchasing-desc {:en "", :fr ""},
   :software-purchasing-long-desc
     {:en
        "As an enterprise architect, I was the focal point for major software license purchases in the supply chain domain. A JDA S&OP module (see article in the link), a project on an ERP specialized in the automotive industry for integration with automotive customers and their specificities. An integrated supply chain tool for a subsidiary. This consists of writing documents related to the supplier (Request for Information, Request for Quotation, Request for Proposal), `RFI/RFQ/RFP`, aligning actors for decision-making, software purchase.",
      :fr
        "En tant qu'architecte entrerpise, j'étais le point focal pour les achats de licence logicielle majeure en chaîne logistique. Un module S&OP de JDA (cf. article dans le lien), un projet sur un ERP spécialisé dans l'automobile pour intégration avec les clients automobiles et leurs spécificités. Un outil supply chain intégré pour une filiale. Cela consiste dans la rédaction des documents en lien avec le fournisseur (Request for Information, Request for Quotation, Request for Proposal), `RFI/RFQ/RFP`, aligner les acteurs pour la prise de décision, l'achat du logiciel."},
   :apics {:fr "Certification BASICS à l'APICS",
           :en "Certification for BASICS - APICS"},
   :apics-long-desc {:fr "", :en ""},
   :apics-desc
     {:en
        "I was certified with MGCM with a BASICS level of APICS. Supply chain oriented, dealing with methods and tools, this training gives a comprehensive panorama of supply chain. I followed and learned the main part of the CPIM but had to stop to focus on the upstream program which was running in parallel.",
      :fr
        "J'ai été certifié par MGCM pour le niveau BASICS de l'APICS. Orientée Supply Chain, outils et méthodes, cette formation fournit un panorama complet de la supply chain. J'ai travaillé une bonne partie du CPIM mais eu dû arrêter pour privilégier le programme amont qui se déroulait en parrallèle."},
   :upstream-ope {:fr "Transformation métier", :en ""},
   :upstream-ope-desc
     {:fr "Dans l'équipe coeur d'un programme de 60 millions d'Euros",
      :en "In the core team of a 60 million Euro program"},
   :upstream-ope-long-desc
     {:fr
        "Au démarrage du programme OPE, les 60 sites de production de semis-finis sont gérés complétement localement. Ma contribution consiste à concevoir les processus supply chain, construire le modèle de planification dans un PLM, intégrer la planification avec l'ERP et l'outil de gestion de magasin (WMS). Dans une position très exigeante, j'ai dû aligner avec des équipes engagées, souvent tendues et être un acteur majeur de l'arrêt du programme tel qu'il était et de son redémarrage dans une nouvelle forme.",
      :en
        "At the start of the OPE program, the 60 semi-finished production sites are managed entirely locally. My contribution consists of designing the supply chain processes, building the planning model in a PLM, integrating planning with the ERP and the warehouse management tool (WMS). In a very demanding position, I had to align with committed, often tense teams and be a major player in stopping the program as it was and restarting it in a new form."},
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
        "Deployment in factories in Asia and South America. Construction and deployment of an automatic production planning solution, support for a factory under construction in the production of robust planning for its start-up."},
   :drp {:fr "Expert planning de distribution - DRP",
         :en "Distribution Resource Planning expert - DRP"},
   :drp-desc {:fr "Expert du progiciel de Manugistics",
              :en "Manugistics software package expert"},
   :drp-long-desc
     {:fr
        "En tant que consultant du progiciel qui délocalise les produits dans le réseau de distribution et par ainsi gère les pénuries, j'ai participé au déploiement de ces nouvelles méthodes, paramétré et accompagner le changement. Le déploiement s'est fait sur plusieurs années et a concerné 90% des ventes de pneumatiques du groupe Michelin.",
      :en
        "As a consultant for the software package that relocates products in the distribution network and thus manages shortages, I participated in the deployment of these new methods, did setup and change management. The deployment took place over several years and concerned 90% of the Michelin group's tire sales."},
   :ecommerce {:fr "Build and practise of an order to cash process.",
               :en "Practical order to cash knowledge"},
   :ecommerce-desc {:fr "Un des premiers site web joaillier Français - 2006",
                    :en "One of the first french jewerly website - 2006"},
   :ecommerce-long-desc
     {:fr
        "J'ai construit un processus order to cash intégrant les contraintes de la bijouterie aux débuts du e-commerce. Peu de sites e-commerces comparables existaient, et le coût du panier moyen nécessitait une attention particulière au client et une résistance aux escrocs.",
      :en
        "I built an order-to-cash process that incorporated the constraints of jewelry in the early days of e-commerce. Few comparable e-commerce sites existed, and the cost of the average basket required special attention to the customer and resistance to scammers."},
   :training {:fr "Ecole d'ingénieur", :en "Engineering school"},
   :training-desc
     {:fr
        "ISIMA - Filière simulation, modélisation et optimisation des systèmes industriels.",
      :en
        "ISIMA - Simulation, modeling and optimization of industrial systems"},
   :training-long-desc
     {:en
        "At school, I've learned the basics of modeling, complex system simulation, production systems, and operational research: Markov chain, constraint and linear programming, heuristics, and metaheuristics.",
      :fr
        "A l'école, j'ai appris les rudiments de la modélisation, de la simulation des systèmes complexes, des systèmes de production et de recherche opérationnelle: les chaînes de Markov, programmation par contraintes, programmation linéaire,  heuristiques et métaheuristiques."}})

(def sc-steps
  (letfn
    [(f [l]
       (->
         [[:hephaistox
           {:img-url "images/hephaistox_logo.png",
            :href "https://hephaistox.com"}]
          [:plm
           {:img-url "images/PLM.png",
            :href
              "https://fr.wikipedia.org/wiki/Gestion_du_cycle_de_vie_(produit)"}]
          [:plm-start {:href "", :img-url "images/PLM.png"}]
          [:downstream-ope
           {:img-url "",
            :href
              "https://www.usinenouvelle.com/article/michelin-veut-reduire-ses-frais-generaux-de-500-millions-d-euros-d-ici-2020.N396442"}]
          ;; ********************************************************************************
          [:market-knowledge {:img-url "images/people_network.png"}]
          [:software-purchasing
           {:img-url "images/software_purchasing.png",
            :href
              "https://www.strategieslogistique.com/Michelin-ameliore-son-S-OP-avec"}]
          [:apics
           {:href "https://www.afrscm.fr/762_p_44059/cpim.html",
            :img-url "images/cpim.png"}]
          [:upstream-ope
           {:href
              "https://www.usinenouvelle.com/article/michelin-veut-reduire-ses-frais-generaux-de-500-millions-d-euros-d-ici-2020.N396442",
            :img-url "images/ope_upstream.jpg"}]
          [:pp {:img-url "images/pp.png"}]
          [:drp
           {:img-url "images/drp.png",
            :href
              "https://en.wikipedia.org/wiki/Distribution_resource_planning"}]
          [:ecommerce
           {:href
              "https://web.archive.org/web/20060614232036/http:/www.bijouteriecaumond.fr/",
            :img-url "images/jewelry.png"}]
          [:training
           {:img-url "images/isima.png",
            :href
              "https://www.isima.fr/formations/formation-ingenieur/f3-systemes-dinformation-et-aide-a-la-decision/"}]]
         (klang/default-and-translate [:desc :name :long-desc]
                                      (partial klang/tr dic l))))]
    (->> klang/possible-langs
         (map (fn [l] [l (f l)]))
         (into {}))))

(defn v-sc
  [l]
  (let [tr (partial klang/tr dic l)]
    [:<> [:h1.text (tr :founder)] [:div.text (tr :intro)]
     (-> (get sc-steps l)
         kvheadered-list/detailed-list) [:hr]]))
