(ns kotws.pages.v-home
  (:require [kotws.ml :as ml]))

(def tr (partial ml/tr
           {:en {:home-intro "I'm Anthony Caumond, I built my career on three
my initial training. software engineer, designing and building software. Having a wide knowledge from Business / Entreprise Architect to developer. The kind of position I would dream about: As a product manager, on a complex system targeting industry / distribution using optimisation techniques. My day to day is a mix of long term vision and hands on core algorithms. Animating complex design of systems. Add somewhere modelling skills"
                 :home-msg   "Professional website of Anthony CAUMOND"
                 :it         "Information Technology"}
            :fr {:home-intro  "Je suis Anthony Caumond. Ma carrière professionnelle est construite sur trois piliers: l'informatique, la supply chain et l'optimisation. Foncièrement full stack, j'aime les projets d'une petite équipe de haut niveau, adressant des sujets complexes ambitieux. Ajouter les compétences de modélisation - optimisation"
                 :home-intro2 "Pour moi, le poste idéal me permet de mettre en oeuvre ces trois compétences: "
                 :home-msg    "Site professionnel d'Anthony CAUMOND"
                 :it          "Informatique"}
            }))

(defn home-panel []
  [:<>
   [:h1 (tr [:home-msg])]
   [:p  (tr [:home-intro])]
   [:p  (tr [:home-intro2])]

   [:table#home-three-pilars
    [:tbody
     [:tr
      [:th]
      [:th [:a {:href "#/tech-stack"} [:img#it {:src "images/pages/it.png"}]]]
      [:th]
      ]
     [:tr
      [:th]
      [:th [:img#pilars {:src "images/pages/three-pilars.png"} ]]
      [:th]
      ]
     [:tr
      [:th [:a {:href "#/vision"} [:img#sc {:src "images/pages/sc.png"} ]]]
      [:th]
      [:th [:a {:href "#/maths"}[:img#math {:src "images/pages/math.png"}]]]
      ]]]])
