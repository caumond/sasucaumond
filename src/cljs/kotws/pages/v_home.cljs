(ns kotws.pages.v-home
  (:require [kotws.ml :as ml]
            [kotws.subs :as subs]
            [re-frame.core :as rf]))

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
  [:div
   [:h1 (tr [:home-msg])]
   [:p (tr [:home-intro])]
   [:p (tr [:home-intro2])]

   [:table {:style {:width "80%" :margin-left "auto" :margin-right "auto"}}
    [:tbody
     [:tr
      [:th]
      [:th.w3-center [:a {:href "#/tech-stack"} [:img.home-image {:src "images/pages/it.png"}]]]
      [:th]
      ]
     [:tr
      [:th]
      [:th.w3-center [:img.home-image {:src "images/pages/three-pilars.png" :style { :margin-top "2vw"}} ]]
      [:th]
      ]
     [:tr
      [:th [:a {:href "#/vision"} [:img.home-image.w3-right {:src "images/pages/sc.png" :style { :margin-right "-10vw"}} ]]]
      [:th]
      [:th [:a {:href "#/maths"}[:img.home-image.w3-left {:src "images/pages/math.png" :style { :margin-left "-10vw"}}]]]
      ]]]])
