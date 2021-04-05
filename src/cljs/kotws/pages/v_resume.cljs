(ns kotws.pages.v-resume
  (:require [re-frame.core :as rf]
            [kotws.subs :as subs]
            [kotws.events :as events]
            [kotws.ml :as ml]))


;;TODO Ajouter certification for TOGAF et Basic

;; private
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def tr
  (partial ml/tr
           {:fr {:what-is-it "Qu'est-ce?"
                 :public-reference "Référence publique"
                 :download "Télécharger le document"
                 :title "Curriculum vitae"
                 :intro "J'ai démarré l'informatique tôt, au collège. Ma carrière a démarré en 2001, à l'université en tant que doctorant."}
            :en {:title "Resume"
                 :public-reference "Public reference"
                 :download "Download the document"
                 :what-is-it "What is it?"
                 :intro "I started IT early, and developed first my Operations Research and then Supply Chain expertise, all along leveraging my IT skills. Now I have deep convictions about industry needs and future, and I would like to express them, being able to focus more on technical skills. I proved my ability to be both disruptive and pragmatic."}}))

(defn tr-item[item & args]
  (apply ml/tr (:ml item) args))

(def resume-timeline
  [{:icon     "fa-wrench"
    :evt-type "timeline__event--type1"
    :date     "2021"
    :ml {:en {:title "Product owner of an in-house PLM"
              :where "Michelin"}
         :fr {:title "'Product owner' d'un logiciel de gestion de cycle de vie produit (PLM)"
              :where "Michelin"}}
    :roles [{:icon      "fa-industry"
             :items [{:what-is-it "https://fr.wikipedia.org/wiki/Gestion_du_cycle_de_vie_(produit)"
                      :ml {:en {:text "Building an in-house PLM"
                                :details "About ten people to manage."}
                           :fr {:text "Construction d'un PLM spécifique (Product Lifecycle Management)"
                                :details "Management d'une équipe d'une dizaine de personnes"}}}
                     {:ml {:en {:text "Create, sell and materialize the vision"
                                :details "Started in 2018 in an Entreprise Architecture, building the vision was my first role for that application. I explained the why, the how to teams and the executives in Michelin. So, a project has been launched for which I became product owner and project manager. Then, sell to some users, trying to fill the gap between the target and their short term concerns. Now it has been started, the build of a generic enough application has started. With a focus on the modelling of our industry (targeting roughly 60 sites). I especially work on the configuration management concepts to design that app."}
                           :fr {:text "Crée, promeut et met en oeuvre la vision"
                                :details "Commencé en 2018 dans une étude d'architecture Entreprise, mon premier rôle sur ce PLM (gestion de cycle de vie produit) a été de construire une vision expliquant le pourquoi et un début de comment, de la communiquer dans les équipes et les `executive`, et de la faire inscrire dans les plans d'investissement. Puis, en tant que product owner et chef projet, j'ai cherché des premiers clients permettant.
 monté l'équipe et matéralisé la vision en cherchant une approche répondant à la fois aux ambitions des utilisateurs du site et de nos ambitions longs termes. Mon rôle a été particulièrement important dans la conception de cette application, et des mécanismes de gestion de configuration en particulier."}}}
                     {:ml {:en {:text "Team leader"
                                :details "About ten people to manage."}
                           :fr {:text "Team leader"
                                :details "Management d'une équipe d'une dizaine de personnes"}}}
                     ]}
            {:icon      "fa-code"
             :items [{:what-is-it "https://fr.wikipedia.org/wiki/Clojure"
                      :ml {:en {:text "Clojure prototyping"
                                :details "Development in clojure of elaborate mappings in huge maps, iterate on a product routing and bill of materials model using data and malli to validate the schema."}
                           :fr {:text "Prototypage en clojure"
                                :details "Développement en clojure de mappings élaborés à l'intérieur de grandes `map`. Itérations sur le modèle de produits, gammes et nomenclatures à partir de données et de validations de schémas en malli."}}}
                     {:ml {:en {:text "Application design "
                                :details "Design some complex concepts around release management and change orders."}
                           :fr {:text "Conception de l'application"
                                :details "Conception de concepts complexes autour de la gestion de configuration: la gestion des versions et les ordres de changements."}}}]}
            ]}

   {:icon     "fa-ruler-combined"
    :evt-type "timeline__event--type2"
    :date     "08-2020"
    :ml {:en {:title "Supply Chain Entreprise Architect"
              :where "Michelin"}
         :fr {:title "Architecte entreprise pour la supply chain"
              :where "Michelin"}}
    :roles [{:icon "fa-industry"
             :items [{:ml {:en {:text "C-Level entreprise studies"
                                :details "Offtakers integration - Original Equipment Manufacturers integration - Transformation program opportunity"}
                           :fr {:text "Etudes entreprise pour les executives"
                                :details"Intégration de la sous traitance - des OEM - Opportunité pour un programme de transformation"}}}
                     {:ml {:en {:text "Software package purchasing"
                                :details "Supply chain integrated solution - Automotive industry ERP for OEMs integration"}
                           :fr {:text "Achat de progiciels entreprises"
                                :details "ERP spécialisé dans l'automobile pour intégration avec les OEMs"}}}
                     {:public-reference "https://www.usinenouvelle.com/article/michelin-veut-reduire-ses-frais-generaux-de-500-millions-d-euros-d-ici-2020.N396442"
                      :ml {:en {:text "Framework studies for a major transformation program"}
                           :fr {:text "Etudes cadres d'un programme de transformation majeur"}}}
                     {:public-reference "https://www.strategieslogistique.com/Michelin-ameliore-son-S-OP-avec"
                      :ml   {:en {:text "Sales and Operations framework and sourcing with JDA"
                                  :details "Finalize purchasing of software package, frame the project"}
                             :fr {:text "Cadrage et achat d'un S&OP avec JDA"
                                  :details "Finalisation de l'achat du progiciel, cadrage du projet"}}}
                     {:ml {:en {:text "First attempt of group A.I. software purchasing"
                                :details "In a group which curiosity for A.I. is awaking, this study has to formalize what is the need for software package or in-house competency. The conclusion was to develop in-house."}
                           :fr {:text "Première tentative d'achat d'un progiciel d'intelligence artificielle au niveau du groupe"
                                :details "Dans un groupe s'éveillant pour l'IA, cette étude a dû formaliser le besoin de progiciels ou de compétences internes. La conclusion a été de développer en interne."}}}
                     {:download "docs/togaf.pdf"
                      :ml {:en {:text "TOGAF certification"}
                           :fr {:text "Certification TOGAF"}}}
                     ]}
            {:icon "fa-code"
             :items [{:ml {:en {:text "Kownledge of main Supply Chain software package"
                                :details ""}
                           :fr {:text "Connaissance des principaux progiciels Supply Chain"
                                :details ""}}}
                     {:ml {:en {:text "Practise of Enterprise Architecture"
                                :details "200+ software in my perimeters"}
                           :fr {:text "Pratique de l'architecture entreprise"
                                :details "Plus de 200 logiciels dans mon périmètre"}}}
                     {:public-reference "https://videos.confluent.io/watch/Uny8xop6vWZut5Hb5CaNpA?"
                      :ml {:en {:text "Launch of an event streaming app - the so called booster stock"
                                :details "Création de la vision - Product owner"}
                           :fr {:text "Lancement d'une application de streaming d'événements - le booster stock"
                                :details "Création de la vision - Product owner"}}}
                     ]}]
    }
   {:icon "fa-ruler-horizontal"
    :evt-type "timeline__event--type3"
    :date "2015"
    :ml {:en {:title "I.T. Architect and Supply Chain consultant"
              :where "Michelin"}
         :fr {:title "Architecte I.T. et consultant Supply chain"
              :where "Michelin"}}
    :roles [{:icon "fa-industry"
             :items [{:ml {:en {:text "Production planning forecasting"
                                :details ""}
                           :fr {:text "Expert d'une solution de planning de production"
                                :details ""}}}
                     {:ml {:en {:text "Deployment change management, setup and support of DRP software package"
                                :details ""}
                           :fr {:text "Déploiement, gestion du changement, installation et support d'un progiciel DRP"
                                :details ""}}}
                     ]}
            {:icon "fa-code"
             :items [{:ml {:en {:text "Solution Architecture"
                                :details ""}
                           :fr {:text "Architecte solution"
                                :details ""}}}
                     ]}]}
   {:icon "fa-chalkboard-teacher"
    :evt-type "timeline__event--type1"
    :date "2008"
    :ml {:en {:title "I.T. Supply Chain consultant"
              :where "Unilog - A Logica CMG compagny"}
         :fr {:title "I.T. consultant Supply chain"
              :where "Unilog - A Logica CMG compagny"}}
    :roles [{:icon "fa-industry"
             :items [{:ml {:en {:text "Distribution planning - stock policies"
                                :details ""}
                           :fr {:text "Planning de distribution - normes de stocks"
                                :details ""}}}
                     {:ml {:en {:text "Deployment change management, setup and support of DRP software package"
                                :details "3 product lines"}
                           :fr {:text "Déploiement, gestion du changement, installation et support d'un progiciel DRP"
                                :details "3 product lines"}}}
                     ]}
            {:icon "fa-code"
             :items [{:ml {:en {:text "PLSQL"
                                :details ""}
                           :fr {:text "PLSQL"
                                :details ""}}}
                     {:ml {:en {:text "C++ Tactical planning optimization tool"
                                :details ""}
                           :fr {:text "Outil tactique d'optimisation en C++"
                                :details ""}}}
                     ]}
            {:icon "fa-infinity"
             :items [{:ml {:en {:text "Distribution network optimization"
                                :details "Solving thousands of minimum flow algorithms (one per article reference) thanks to busaker and gowen. Design, development and integration of the solution."}
                           :fr {:text "Optimisation du réseau de distribution"
                                :details "Résolution de milliers (un par référence article) de problème de flots minimum, grâce à l'algorithme de busaker et gowen. Conception, développement et intégration de la solution."}}}
                     {:ml {:en {:text "Planning tactique des renforts textiles - Iterative metaheuristics"
                                :details ""}
                           :fr {:text "Planning tactique des renforts textiles - Iterative metaheuristics"
                                :details ""}}}
                     ]}]}

   {:icon "fa-shopping-cart"
    :evt-type "timeline__event--type3"
    :date "2006"
    :ml {:en {:title "E-commerce website"
              :where "Family jewelry"}
         :fr {:title "Site e-commerce"
              :where "Bijouterie familiale"}}
    :roles [{:icon "fa-industry"
             :items [{:ml {:en {:text "Practical order to cash knwoledge"
                                :details ""}
                           :fr {:text "Connaissance pratique d'un order to cash"
                                :details ""}}}]}
            {:icon "fa-code"
             :items [{:ml {:en {:text "Php5 - mysql paradox db - Borland C++"
                                :details "The website was operational and worked during roughly two years. Targeting family jewerly, a backend in Borland C++ was developped to manage and upload product catalog. The website by itself contains some e-payment and CMS to delegate some site update"}
                           :fr {:text "Php5 - mysql paradox db - Borland C++"
                                :details "Le site web était opérationnel et fonctionnait pendant environ deux ans. Ciblant la bijouterie familiale, un backend en Borland C++ permettait de gérer et de télécharger le catalogue produit. Le site offrait des fonctionnalités de paiement et de CMS, afin de déléguer une partie de sa mise à jour."}}}]}]}

   {:icon "fa-university"
    :evt-type "timeline__event-type1"
    :date "2001"
    :ml {:en {:title "Operation Research PhD and teacher"
              :where "Blaise Pascal University"}
         :fr {:title "Docteur en recherche opérationnelle et enseignant"
              :where "Université Blaise Pascal"}}
    :roles [{:icon "fa-industry"
             :items [{:ml {:en {:text "Industrial Proof Of Concepts"
                                :details ""}
                           :fr {:text "P.O.C. industriels"
                                :details ""}}}
                     {:ml {:en {:text "PSA – Assembly line optimization"
                                :details ""}
                           :fr {:text "PSA - Optimisation des lignes d'assemblage"
                                :details ""}}}
                     {:ml {:en {:text "PSA - Workshop optimization"
                                :details ""}
                           :fr {:text "PSA - Optimisation des chantiers polyvalents"
                                :details ""}}}
                     {:ml {:en {:text "Eramet – Forging workshop optimization"
                                :details ""}
                           :fr {:text "Eramet - Optimisation des ateliers de forge à chaud"
                                :details ""}}}
                     {:ml {:en {:text "Michelin – Test tracks time tabling"
                                :details ""}
                           :fr {:text "Michelin - Gestion d'emploi du temps des pistes d'essais"
                                :details ""}}}
                     {:ml {:en {:text "Michelin – Plant simulation"
                                :details ""}
                           :fr {:text "Michelin - Simulation et optimisation des usines"
                                :details ""}}}
                     ]}
            {:icon "fa-code"
             :items [{:ml {:en {:text "UI and backend in Borland C++"
                                :details ""}
                           :fr {:text "Interfaces utilisateurs et backend en Borland C++"
                                :details ""}}}
                     {:ml {:en {:text "C++ Framework for iterative optimization"
                                :details ""}
                           :fr {:text "Cadriciel pour l'optimisation itérative"
                                :details ""}}}
                     ]}
            {:icon "fa-university"
             :items [{:ml {:en {:text "Phd thesis and Articles"
                                :details ""}
                           :fr {:text "Article et thèse"
                                :details ""}}}
                     {:ml {:en {:text "C.O.R. - Timelag"
                                :details ""}
                           :fr {:text "C.O.R. - Timelage"
                                :details ""}}}
                     {:ml {:en {:text "E.J.O.R. - Transportation"
                                :details ""}
                           :fr {:text "E.J.O.R. - Transports"
                                :details ""}}}
                     {:ml {:en {:text "Iterative methods"
                                :details ""}
                           :fr {:text "Méthodes itératives"
                                :details ""}}}
                     {:ml {:en {:text "Integer linear programming"
                                :details ""}
                           :fr {:text "Programmation linéaire en nombres entiers"
                                :details ""}}}
                     {:ml {:en {:text "Graph optimization"
                                :details ""}
                           :fr {:text "Optimisation de graphes"
                                :details ""}}}

                     ]}
            ]}
   {:icon "fa-school"
    :where-link "https://www.isima.fr/"
    :ml {:en {:title "Computer science Engineering degree"
              :where "ISIMA"}
         :fr {:title "Ecole d'ingénieurs en informatique"
              :where "ISIMA"}}
    :roles [{:icon "fa-code"
             :items [{:ml {:en {:text "Computer science Engineering degree"
                                :details ""}
                           :fr {:text "Ecole d'ingénieurs en informatique"
                                :details ""}}}]}]}
   {:icon "fa-user-alt"
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
                                :details "A une époque où les logiciels de gestion professionnels étaient rares, j'ai eu l'occasion d'en construire en gfa basic, permettant de gérer le stock de la bijouterie familiale."}}}
                     {:ml {:en {:text "GFA basic & 68000 assembly"
                                :details "I used mainly that two languages for the above achievements. I also had the opportunity to use Z80 and code machine."}
                           :fr {:text "Assembleur Z80 et 68000"
                                :details "J'ai majoritairement utilisé ces deux languages pour les réalisations ci-dessus. J'ai aussi eu l'occasion de faire du Z80 et du language machine."}}}]}]}
   ])

;; public
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn resume-panel []
  [:<>
   [:a {:href "docs/caumond-resume.pdf" :target "blank"}[:i.fa.fa-download.w3-margin.w3-right]]
   [:h1 (tr [:title])]
   [:p (tr [:intro])]

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
                     [:i.arrow.fa.fa-angle-down {:class (when-not detailed-shown? "w3-hide")}]
                     [:i.arrow.fa.fa-angle-right {:class (when detailed-shown? "w3-hide")}]
                     text-item
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
       ))]
   ]
  )
