(ns kotws.pages.v-cv
  (:require
   [cljs-time.core :as time]
   [kotws.ml :as ml]))

;; private
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def tr
  (partial ml/tr
     {:fr {:cv {:intro   "Ma carrière a démarrer en 2010"
                :intro-2 "After some years developing mainly games, I started. I started my career as a phd student in operational research, teaching sciences. I started in Unilog - a software firm, working @Michelin. consultant in the industry, where I developed Supply Chain, Operations Research and I.T skills. I demonstrated a will and ability to be disruptive and pragmatic."}
           }
      :en {:cv {:intro   "My career has been focused on three pillars: development, Industry / Supply Chain / Logistics metier, and optimization research. My experience described below gives some insights on that."
                :intro-2 "After some years developing mainly games, I started. I started my career as a phd student in operational research, teaching sciences. I started in Unilog - a software firm, working @Michelin. consultant in the industry, where I developed Supply Chain, Operations Research and I.T skills. I demonstrated a will and ability to be disruptive and pragmatic."
                }}}))

(defn years-of-experience []
  (-
    (time/year (time/now))
    2001)
  )
;; public
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn cv-panel []
  [:div
   [:div#cv
    [:p (tr [:cv/intro])]
    [:p (tr [:cv/intro-2])]

    [:div.w3-panel.w3-grey.w3-card.w3-display-container.w3-cell-row
     [:div.w3-panel.w3-white.w3-card.w3-display-container.w3-cell

      [:p.entreprise (tr ["Michelin"])]]
     [:div.w3-cell.w3-cell-row
      [:div.w3-cell [:p.years.w3-light-grey (tr ["2016-2019"])]]
      [:div.w3-panel.w3-white.w3-card.w3-display-container.w3-cell
       [:h1 "ENTERPRISE ARCHITECT"]
       [:h2 (years-of-experience)
        " years of experience"]
       [:h3 "Enterprise Architect – Supply Chain Planning"]
       [:h4 "Perimeter"]
       [:ul
        [:li "From the purchasing of Raw Materials to finished product delivery"]
        [:li "Operational to strategical planning"]
        [:li "All business lines and world-wide"]
        ]
       [:h4 "Main activities"]
       [:ul
        [:li "C-Level enterprise study"]
        [:li "Provides framework to SC projects and programs"]
        [:li "5 years roadmaps"]
        [:li "Software purchasing (S&OP, ERP OEM, Integrated Planning …)"]
        ]
       [:h4 "Main achievements"]
       [:ul
        [:li "Framework for "
         [:a {:href   "https://www.usinenouvelle.com/article/michelin-veut-reduire-ses-frais-generaux-de-500-millions-d-euros-d-ici-2020.N396442"
              :target "blank"}
          "OPE transformation program on industry" ]]
        [:li [:a {:href   "https://www.strategieslogistique.com/Michelin-ameliore-son-S-OP-avec"
                  :target "blank"}
              "Framework & sourcing for group S&OP tooling with JDA"]]
        [:li "Stock reference architecture for event driven architecture"]
        [:li "Target and Roadmaps for Post manufacturing, Offtake, OEM"]
        [:li [:a {:href "https://www.supplychaindigital.com/technology/exclusive-interview-girish-rishi-ceo-jda-software" :blank "blank"}
              "First purchasing in the group of an A.I. focus software"]]
        ]]
      [:div.w3-panel.w3-white.w3-card.w3-display-container
       [:p.years "2013-2016"]
       [:h3 "Upstream« Supply Chain » business architect"]
       [:h4 "Perimeter:"]
       [:ul
        [:li "Planning process for upstream industry"]
        ]
       [:h4 "Main activities:"]
       [:ul
        [:li "Animate business ambitions with C level"]
        [:li "Build architecture rules and business process"]
        ]
       [:h4 "Main achievements:"]
       [:ul
        [:li "Reshape program objectives with C-level,"]
        [:li "PLM / product B.O.M. and routing data model for planning, quality, manufacturing costing and purchasing,"]
        [:li "New decentralized planning process for the 5 upstream industries"]
        ]]]
     ]

    [:p.years "2008-2013"]
    [:h3 "IT Supply Chain Consultant / IT Architect"]
    [:h4 "Perimeter"]
    [:ul [:li "Production and distribution planning, forecasting, stocks policies"]
     ]
    [:h4 "Main activities"]
    [:ul [:li "Deployment, change management, setup and support"]]
    [:h4 "Main achievements"]
    [:ul [:li "DRP deployment"]]

    [:p.years "2006-2008"]
    [:p.entreprise "UNILOG"]
    [:h3 "Consultant IT Supply Chain"]
    [:h4 "Perimeter"]
    [:ul [:li "Distribution planning, stock, policies"]]
    [:h4 "Main activities"]
    [:ul [:li "Deployment, change management and support"]]
    [:h4 "Main achievements"]
    [:ul [:li "Renewed distribution process for 3 product lines"]]

    [:p.years "2001-2006"]
    [:p.entreprise "Auvergne University"]
    [:h3 "Operations Research PhD"]
    [:h4 "Main activities"]
    [:ul
     [:li "Teaching in Unversity"]
     [:li "Researcher"]]
    [:h4 "Articles "]
    [:ul
     [:li [:a {:target "blank"
               :href   "https://www.sciencedirect.com/science/article/abs/pii/S0305054806002930"} "A memetic algorithm for the job-shop with time-lags: A. Caumond, P. Lacomme, N. Tchernev"]]
     [:li [:a {:target "blank"
               :href   "https://www.sciencedirect.com/science/article/abs/pii/S0377221708004608"}
           "An MILP for scheduling problems in an FMS with one vehicle: A.Caumond, P.Lacomme, A.Moukrim, N.Tchernev"]]
     ]

    [:h1 "Formation"]
    [:p "TOGAF 9-"
     [:a {:target "blank"
          :href   "docs/TOGAF 9 Certification -Certificate-Certified.pdf"} "certified"]
     " & "
     [:a {:target "blank"
          :href   "docs/TOGAF 9 Certification -Certificate-Foundation.pdf"} "foundations"]
     ]
    [:p "BASICS APICS certified"]
    [:p "Computer Science engineering degree " [:a {:target "blank"
                                                    :href   "https://www.isima.fr/accueil-english/"}
                                                "@ISIMA"]]
    [:p "Operations Research Ph.D." [:a {:target "blank"
                                         :href   "https://scholar.google.com/scholar?hl=fr&as_sdt=0%2C5&q=CAUMOND&btnG="} " @Auvergne University"]]

    [:h1 "Developer for personal projects"]
    [:p "Games and demos on 68000 assembly language on an " [:a {:target "blank"
                                                                 :href   "https://fr.wikipedia.org/wiki/Atari_ST"} "Atari ST 1040"]]
    [:p "Games in Z80 assembly language on a " [:a {:target "blank"
                                                    :href   "https://fr.wikipedia.org/wiki/Amstrad_CPC_464"} "Amstrad CPC 464"]]
    ]]
  )
