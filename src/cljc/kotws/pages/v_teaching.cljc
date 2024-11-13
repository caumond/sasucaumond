(ns kotws.pages.v-teaching
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]
            [kotws.components.v-headered-list :as kvheadered-list]))

(def dic
  {:teaching {:fr "Enseignement", :en "Teaching"},
   :introduction
     {:fr
        [:div [:h2 "500 heures+"]
         [:p
          "J'ai commencé 'enseignement comme un complément naturel à la recherche, et je me suis pris au jeu et j'ai apprécié: expliquer, coacher, faire du mentoring, j'ai eu plusieurs occasions de développer ces compétences et j'en ai tiré plus de plaisir que ce à quoi je m'attendais."]
         [:p
          "La plupart de ces expériences ont été complétées avec des encadrements de projets, stages, examens, orientations, recommandations, ... (NB 2001 signifie septembre 2001 - Juin 2002.). Les heures de cours sont exprimées en équivalent TD."]],
      :en
        [:div [:h2 "500+ hours"]
         [:p
          "I started teaching as a natural complement to research, and I got into it and enjoyed it: explaining, coaching, mentoring, I had several opportunities to develop these skills and I got more pleasure from them than I expected."]
         [:p
          "Most of these experiences were completed with project supervision, internships, exams, orientations, recommendations, ... (NB 2001 means September 2001 - June 2002.). The course hours are expressed in TD equivalent."]]},
   :vacataire-2001 {:fr "Vacataire pendant le DEA",
                    :en "Temporary Worker during master's degree in research"},
   :vacataire-2001-desc
     {:fr "2001-2002, Université Blaise Pascal et Université d'Auvergne",
      :en "2001-2002, Blaise Pascal University and University of Auvergne"},
   :vacataire-2001-long-desc
     {:fr
        [:div
         [:ul
          [:li
           "30 heures d'ADA (langage de programmation fort typé), TP et TD - Licence MIAS"]
          [:li
           "20 heures de bases de données Microsoft Access. Concepts d'une base de données, modéliser, utiliser Microsoft Access - IUT GEA"]
          [:li
           "40 heures de Microsoft Word. Mise en forme, styles, publipostage - IUT GEA"]
          [:li
           "30 heures. Algorithmes de graphes: plus long chemins, algorithmes de flots, simplex - CNAM (cours du soir)"]]],
      :en
        [:div
         [:ul
          [:li
           "30 hours of ADA (strongly typed programming language), practical work and tutorials - MIAS degree"]
          [:li
           "20 hours of Microsoft Access databases. Concepts of a database, modeling, using Microsoft Access - IUT GEA"]
          [:li
           "40 hours of Microsoft Word. Formatting, styles, mail merge - IUT GEA"]
          [:li
           "30 hours. Graph algorithms: longest paths, flow algorithms, simplex - CNAM (evening classes)"]]]},
   :moniteur {:fr "Moniteur", :en "`Moniteur` 3 years position"},
   :moniteur-desc {:fr "2002-2005 - Université Blaise Pascal",
                   :en "2002-2005 - Blaise Pascal University"},
   :moniteur-long-desc
     {:fr
        [:div
         [:p "Le monitorat assure un service de 64 heures TD pendant 3 ans."]
         [:ul
          [:li "86 heures de Pascal et algorithmique - deux années - DEUG MIAS"]
          [:li
           "48 heures d'ADA - langage fort types utilisés par `DOD - Department Of Defense` - deux années - Licence MIAS"]
          [:li
           "13 heures de processus stochastiques (modélisation avec QNAP de files d'attentes, de chaînes de markov, de modèles de simulations, ...) - Maîtrise MIAS"]
          [:li "46 heures - C++ et programmation objets - Licence MIAS"]
          [:li
           "5 heures - Simulation à événements discrets - deux années - Maîtrise MIAS"]]],
      :en
        [:div
         [:p "The `moniteur` ensures a service of 64 hours TD for 3 years."]
         [:ul [:li "86 hours of Pascal and algorithms - two years - DEUG MIAS"]
          [:li
           "48 hours of ADA - strong language types used by `DOD - Department Of Defense` - two years - MIAS License"]
          [:li
           "13 hours of stochastic processes (modeling with QNAP of queues, markov chains, simulation models, ...) - MIAS Master"]
          [:li "46 hours - C++ and object programming - MIAS License"]
          [:li
           "5 hours - Discrete event simulation - two years - MIAS Master"]]]},
   :ater {:fr "Attaché temporaire enseignement et recherche",
          :en "`ATER` - 1 year temporary position"},
   :ater-desc {:fr "2005 - 2006 - Université Blaise Pascal",
               :en "2005 - 2006 - Blaise Pascal University"},
   :ater-long-desc
     {:fr
        [:div
         [:p
          "L'ATER est un poste temporaire, comme un CDD pour un enseignant chercheur."]
         [:ul
          [:li
           "13 heures de processus stochastiques (modélisation avec QNAP de files d'attentes, de chaînes de markov, de modèles de simulations, ...) - Maîtrise MIAS"]
          [:li "61 heures - C++ et programmation objets - Licence MIAS"]
          [:li "7 heures - Probabilité et statistiques - Licence MIAS"]
          [:li "16 heures - Programmation avancée - Licence MIAS"]
          [:li "6 heures - Outil et méthodes de résolution - Maîtrise MIAS"]]],
      :en
        [:div
         [:p
          "The ATER is a temporary position, like a fixed-term contract for a teacher-researcher."]
         [:ul
          [:li
           "13 hours of stochastic processes (modeling with QNAP of queues, Markov chains, simulation models, etc.) - MIAS Master"]
          [:li "61 hours - C++ and object programming - MIAS Degree"]
          [:li "7 hours - Probability and statistics - MIAS Degree"]
          [:li "16 hours - Advanced programming - MIAS Degree"]
          [:li "6 hours - Resolution tools and methods - MIAS Master"]]]},
   :pp-training {:fr "Formation en planification de production",
                 :en "Training in production planning"},
   :pp-training-desc {:fr "2007 - Michelin", :en "2007 - Michelin"},
   :pp-training-long-desc
     {:fr "60 H - Formation sur l'outil de planification de production.",
      :en "60 H - Training on the production planning tool."},
   :vacataire-sc {:fr "Vacataire en chaîne logistique",
                  :en "Temporary teacher in Supply chain"},
   :vacataire-sc-desc {:fr "2010 - Université d'Auvergne",
                       :en "2010 - Auvergne university"},
   :vacataire-sc-long-desc
     {:fr
        "30 heures - Introduction à la chaîne logistique, vue d'avion, et cas pratiques. Approfondissement sur le DRP (Demand Resource Planning).",
      :en
        "30 hours - Introduction to the supply chain, aerial view, and practical cases. In-depth study of DRP (Demand Resource Planning)."},
   :vacataire-isima {:fr "Vacataire informatique",
                     :en "Temporary teacher in IT"},
   :vacataire-isima-desc {:fr "2022, Université Blaise Pascal - ISIMA",
                          :en "2022, Blaise Pascal University - ISIMA"},
   :vacataire-isima-long-desc
     {:fr
        [:div
         [:ul
          [:li
           "30 heures - Comprendre les métiers de l'informatique. Vue d'ensemble des métiers possibles et préparation au décryptage des annonces."]
          [:li
           "40 heures - Comprendre les bases de donnés big data/nosql, leurs différences avec les bases de données relationnelles. Théorie sur les bases relationnelles, orientées graphes, orientées colonnes. Cas pratique, deux TPs par technologie:  Mongo, Neo4j, Redis, Oracle NoSQL"]]],
      :en
        [:div
         [:ul
          [:li
           "30 hours - Understanding IT jobs. Overview of possible jobs and preparation for deciphering ads."]
          [:li
           "40 hours - Understanding big data/nosql databases, their differences with relational databases. Theory on relational, graph-oriented, column-oriented databases. Some pratical work in two session for each technology: Mongo, Neo4j, Redis, Oracle NoSQL"]]]}})

(def items
  [[:vacataire-2001] [:moniteur] [:ater] [:pp-training] [:vacataire-sc]
   [:vacataire-isima]])

(def tr (partial klang/tr dic))

(defn v-teaching
  [l]
  (let [current-tr (partial tr l)
        teaching-items (kvheadered-list/defaulting* items
                                                    tr
                                                    klinks/image-link
                                                    klinks/external-link)]
    [:<> [:h1.text (current-tr :teaching)]
     [:div.text (current-tr :introduction)]
     [kvheadered-list/detailed-list (get teaching-items l) :small]
     [:p.text (current-tr :conclusion)]]))
