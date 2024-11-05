(ns kotws.pages.v-it
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]
            [kotws.components.v-headered-list :as kvheadered-list]
            [kotws.components.v-space :as kvspace]))

(def dic
  {:computer-science {:fr "Informatique", :en "Computer science"},
   :intro
     {:en
        "I started software development when I was 10, when much less resources were available. This is a passion that has accompanied me all my life long, as a side project, a tool, and now as a support of the offer of my enterprise.",
      :fr
        "Le développement informatique est une passion constante chez moi. Démarré tôt, vers 10 ans, j'ai toujours voulu la rendre appliquée aux problèmatiques qui m'entouraient. En arrivant en école d'ingénieur, je cherchais un domaine d'application, et la recherche opérationnelle ainsi que l'industrie à laquelle elle s'applique ont été des terrains de jeux privilégiés pour explorer les différents aspects de l'informatique."},
   :hephaistox {:fr "Hephaistox", :en "Hephaistox"},
   :hephaistox-desc
     {:fr "Open source pour aider les PMIs dans leur prise de décision",
      :en
        "Small and medium industries open source softwares for decision support."},
   :hephaistox-long-desc
     {:fr
        "Dans le cadre d'Hephaistox, je mets à disposition mes connaissances à travers des librairies libres. L'objectif est d'alimenter l'activité de conseil d'Hephaistox tout en assurant à nos clients une certaine autonomie dans la mise à jour ces outils. Le rayonnement d'Hephaistox et le juste retour à la communauté sont aussi un moteur important pour moi. Cette solution offre de la simulation à événements discrets, des outils d'optimisation, un monorepo, la grande majorité de ces outils sont indépendants de la technologie des interfaces utilisateurs mais des composants web sont mis à disposition pour ces applications.",
      :en
        "For Hephaistox, I'm working to deliver my knowledge through open-source libraries. The objective is to feed the consulting activities of Hephaistox while reassuring our customers and giving them some autonomy in any update of the solution we build for them. The influence of Hephaistox and giving back to the community are also important drivers for me. That solution offers a discrete event simulator, optimization tools, and a monorepo. Most of those tools are agnostic of the UI technology, but some web components are available."},
   :storrito {:fr "Storrito", :en "Storrito"},
   :storrito-desc {:fr "Développeur Clojure fullstack.",
                   :en "Fullstack Clojure developper."},
   :storrito-long-desc
     {:fr
        "Pendant une année, afin de préparer Hephaistox, j'ai participé au projet Storrito qui permet de planifier à l'avance la publication de stories, de reels sur Instagram. Mon objectif était d'apprendre Clojure, réapprendre les bases de développements, intégrer les contraintes d'un projet disponible dans le `cloud`.",
      :en
        "To prepare for the Hephaistox offer, I've spent a year on Storrito's application. With Storrito you could schedule in advance your Instagram's reals and stories. My objective was to learn Clojure(script), learn again development bases, and integrate the constraints of a cloud highly available application."},
   :plm {:en "Industrial configuration management",
         :fr "Gestion de configuration industrielle"},
   :plm-desc {:fr "Conception d'un PLM pour l'industrie",
              :en "Indutrial PLM design"},
   :plm-long-desc
     {:fr
        "Un PLM sert à gérer les différentes version de tous les produits d'une industrie et surtout animer la compatibilité et le cycle de vie des produits à travers tous les métiers de l'industrie: la qualité, l'obtention, le planning, la fabrication, le stockage, la livraison client, ... En m'inspirant de la gestion de configuration de git, j'ai fortement contribué à la création de cette conception et à sa diffusion.",
      :en
        "A PLM is a product lifecycle management, for the industry this is software that stores the different versions of a product but also the compatibility of them. It concerns all the production-oriented departments of an industry: design, quality, obtention, planning, manufacturing, storage, and customer delivery ... Based on git public knowledge of configuration management, I was one of the main contributors to this design and its diffusion."},
   :event-stock {:fr "Les flux d'événements pour gérer le stock",
                 :en "Event flows to manage inventory"},
   :event-stock-desc {:fr "Décaler la qualité de la connaissance du stock",
                      :en "Shifting the quality of stock knowledge"},
   :event-stock-long-desc
     {:fr
        "La connaissance du stock est un problème récurrent dans l'industrie, de l'extérieur on ne soupçonne pas à quel point il y a des imprécisions. Bien sûr il y a des industries meilleures que d'autres, mais toutes ont fortement intérêt à s'améliorer sur le sujet. L'idée est de créer une image résiliente du stock à partir des mouvements de stock. On construit un état de stock à partir des événements de stocks tout en ajoutant la contrainte: un élément de stock n'est qu'à un seul endroit, dans un seul état. Autant il est facile d'accumuler les erreurs quand on compte combien de produits entrent et sortent, autant quand un individu est muni d'un code barre, on peut beaucoup moins se tromper. Soit le produit n'est pas à l'endroit que l'on croit car on a râté un événement (mais le prochain mouvement rattrapera cette erreur), soit le produit est définitivement sorti et le délai de vieillissement, le prochain inventaire corrigeront cette erreur. Bien sûr que l'image ne sera pas parfaite, mais elle sera beaucoup plus résiliente.",
      :en
        "Knowledge of stock is a recurring problem in the industry, from the outside we do not suspect to what extent there are inaccuracies. Of course there are industries better than others, but all have a strong interest in improving on the subject. The idea is to create a resilient image of stock from stock movements. We build a stock status from stock events while adding the constraint: a stock item is only in one place, in one state. As much as it is easy to accumulate errors when we count how many products come in and go out, when an individual is equipped with a bar code, we can be much less mistaken. Either the product is not in the place we think because we missed an event (but the next movement will catch up on this error), or the product is definitely out and the aging period, the next inventory will correct this error. Of course the image will not be perfect, but it will be much more resilient."},
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
        "Outil standalone, intégré avec les excels des utilisateurs optimisant les plans.",
      :en
        "Integrated tooling with users' spreadsheet which is optimizing their plans."},
   :make-or-buy-optimization-long-desc
     {:fr
        "Ce qui est appelé renfort textile est un matériau complexe qui entre dans la composition du pneu, il est soit fabriqué, soit acheté par le groupe Michelin. Signer des contrats fixant à l'avance les prix entre un volume minimum et un maximum, et remplir les usines internes sont deux objectifs contradictoires avec les évolutions du marché. Ce problème est complexe à résoudre et j'ai pu utiliser le cadriciel de mon doctorat pour résoudre ce problème en une semaine. La solution est restée au moins une dizaine d'années en production.",
      :en
        "Reinforced fabric is a complex material used in tire making. In Michelin, it is both internally made and bought. There are some contradictory objectives: fitting the unstable demand and signing in advance some contracts with suppliers to fix prices in some minimum / maximum corridors together with amortizing internal plants. I've been able to build such a tool in one week, and it's been used for at least ten years every month. Its simplicity and robustness come from the framework I've built during my PhD."},
   :distribution-network {:fr "Sourcing de distribution",
                          :en "Distribution sourcing"},
   :distribution-network-desc
     {:fr "Flot maximum pour optimiser le réseau de distribution de Michelin",
      :en "Graph flow optimization to optimize Michelin distribution network"},
   :distribution-network-long-desc
     {:fr
        "Alors qu'un bug non anticipé est apparu en plein déploiement, j'ai dû réécrire en urgence des algorithmes d'optimisation de flot qui calcule et optimise le réseau de distribution de Michelin (des millions de couple produits/location). En PLSQL pour s'intégrer facilement à l'architecture, j'ai en deux semaines réécrit ces algorithmes qui sont toujours en production une dizaine d'années après.",
      :en
        "After a bug appeared during deployment, I had to rewrite in an emergency the flow optimization algorithm which was computing the Michelin distribution network (millions of products/location couple). Written in PLSQL to integrate easily into the existing architecture, I wrote the algorithms in two weeks and they were still in production ten years later."},
   :dss {:en "Decision support system", :fr "Outils d'aide à la décision"},
   :dss-desc
     {:en "Production-ready optimization tools and prototypes during the PhD.",
      :fr
        "Outil d'optimisation en production et prototypes dans le cadre du doctorat."},
   :dss-long-desc
     {:en
        "I've built a decision support system: `CPFERV` to schedule PSA's spare part workshops, a scheduling tooling for the Aubert & Duval's forge workshop, and SMPP to schedule around twenty tire manufacturing plants of Michelin group. I've also developed prototypes: scheduling rolling mills of Pechiney, and tire test tracks of Michelin.  This includes all the optimization engines, some UI to set data, tweak optimization parameters, and explore optimization results. Some of them were done with complete autonomy, some in small teams.",
      :fr
        "J'ai développé des outils d'aide à la décision: CPFERV pour l'ordonnancement des ateliers de pièces de rechange à PSA, un outil d'ordonnancement des ateliers de forge à chaud d'Aubert & Duval et SMPP pour la planification pour une vingtaine de manufacture pneumatique de Michelin. J'ai aussi développé des prototypes: planification des lamineurs de Péchiney, planification des pistes de tests de pneumatique de Michelin. Cela inclut les moteurs d'optimisation, des interfaces utilisateurs pour saisir les données, explorer les résultats d'optimisation. Certains d'entre eux étaient fait en complète autonomie, d'autres en petite équipe."},
   :bcoo {:fr "BCOOLIB", :en "BCOOLIB"},
   :bcoo-desc {:fr "Bibliothèque de Composants d’Optimisation orientée Objets",
               :en "Object oriented optimization components library"},
   :bcoo-long-desc
     {:fr
        "Tout mon savoir-faire en recherche opérationnelle pour l'industrie que j'ai acquis en thèse a été inclus dans cette bibliothèque. L'objectif était de capitaliser et d'accélérer le développement des projets ultérieurs. Cet objectif a été atteint car il a été le support des articles de recherches, mais aussi de la plupart des applications industrielles.",
      :en
        "All my know-how in operational research for industry that I acquired in my thesis was included in this library. The objective was to capitalize and accelerate the development of subsequent projects. This objective was achieved because it was the support for research articles, but also for most industrial applications."},
   :jewelry-website {:en "Jewelry e-commerce",
                     :fr "Site e-ecommerce de bijouterie"},
   :jewelry-website-desc {:en "Php5 - mysql paradox db - Borland C++",
                          :fr "Php5 - mysql paradox db - Borland C++"},
   :jewelry-website-long-desc
     {:en
        "The website was operational and worked for roughly three years. The website's objective was to create an extra activity for the family jewelry. A backend in Borland C++ was developed to manage and upload product catalogs. The website contains some e-payments and CMS to delegate some site updates.",
      :fr
        "Le site web était opérationnel et fonctionnait pendant environ trois ans, permettant d'offrir une activité supplémentaire à la bijouterie familiale. Un backend en Borland C++ permettait de gérer et de télécharger le catalogue produit. Le site offrait des fonctionnalités de paiement et de CMS, afin de déléguer une partie de sa mise à jour."},
   :isima {:fr "ISIMA", :en "ISIMA"},
   :isima-desc
     {:fr
        "Formation initiale: Systèmes d’Information et Aide à la Décision - 1998",
      :en
        "Initial training: Decision Support System and Information System - 1998"},
   :isima-long-desc
     {:fr
        "ADA, Assembleur, C, fortran, LISP, structure de données, matlab, algorithmique, java, programmation numérique, prolog. Ces cours sont assortis de deux projets et de deux stages de 6 mois",
      :en
        "ADA, Assembly, C, Fortran, LISP, data structure, matlab, algorithmic, java, numerical programming, prolog. Two stages and two internships of six months long."},
   :jewelry-ecommerce {:en "Jewelry stock management",
                       :fr "Gestion de stock d'une bijouterie"},
   :jewelry-ecommerce-desc {:fr "Un logiciel utilisé quotidiennement",
                            :en "A daily used software"},
   :jewelry-ecommerce-long-desc
     {:fr
        "A une époque où les logiciels de gestion professionnels étaient rares, j'ai construit le logiciel de gestion de stock de la bijouterie familiale en Gfa Basic.",
      :en
        "At a time when professional software was quite scarce, I built in GFA Basic the stock management tool for the family jewelry."},
   :demo-making {:fr "Démo et jeux", :en "Demo making and games"},
   :demo-making-desc {:fr "Se faire plaisir en apprenant",
                      :en "Have, fun while, learning"},
   :demo-making-long-desc
     {:en
        "I discovered development with game creation. Games were in text mode or graphical mode. But I spent a lot of time developing demos: vector balls, rasters, overscan, 3D wireframe.",
      :fr
        "J'ai découvert le développement logiciel en créant des jeux, d'abord en mode texte puis en mode graphique. Et finalement, j'ai passé beaucoup de temps à faire des démos, des logiciels techniquement poussé à visée artistique : des vectors balls, des rasters, des overscans, de la 3D en wireframe."},
   :coding-for-fun {:fr "Langage de développement",
                    :en "GFA basic & 68000 assembly"},
   :coding-for-fun-desc {:fr "Assembleur Z80, 68000 et GFA basic",
                         :en "Z80 assembly, 68000 and GFA basic"},
   :coding-for-fun-long-desc
     {:fr
        "J'ai appris ces langages en autodidacte. C'était une époque sans Internet, avec peu de livres, peu de bibliothèques logicielles. J'ai par exemple dû à redécouvrir comment tracer des lignes qu'avec des décalages de registres.",
      :en
        "I've learned these languages by myself. It was a time with no Internet, few books, and few software libraries. I had, for instance, to rediscover how to draw lines with registry shifts."}})

(def items
  [[:hephaistox {:href :hephaistox-gh}] [:storrito {}] [:plm {}]
   [:event-stock {:img-url :kafka, :href :seb}] [:archi {:href :togaf}]
   [:make-or-buy-optimization {}] [:distribution-network {}]
   [:dss {:img-url :optimization}] [:bcoo {}]
   [:jewelry-website {:img-url :web-caumond, :href :web-caumond-archive}]
   [:isima {:start "01/09/1998", :end "01/09/2001", :company "ISIMA"}]
   [:jewelry-ecommerce {}] [:demo-making {}]
   [:coding-for-fun {:img-url :z80, :href :z80}]])

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
