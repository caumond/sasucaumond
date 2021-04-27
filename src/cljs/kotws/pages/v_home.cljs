(ns kotws.pages.v-home
  (:require [kotws.ml :as ml]))

(def tr (partial ml/tr
                 {:en {:home-msg   "Professional website of Anthony CAUMOND"
                       :home-intro "This website presents me and my professional career. Have a look to my resume, you'll see it is based on three pilars: I.T. - supply chain - optimization. This website has been realized in clojure, to show how much I am eager to learn, re-frame for instance, to present my resume."
                       :it "COMPUTING"
                       :maths "MATHEMATICS"
                       :sc "SUPPLY CHAIN"
                       }
                  :fr {:home-msg    "Site professionnel d'Anthony CAUMOND"
                       :home-intro  "Ce site vous présente ma carrière professionnelle. Vous pourrez découvrir dans mon cv qu'elle est basée sur trois piliers : l'informatique, la supply chain et l'optimisation. Ce site a été réalisé en clojure, il montre à quel point j'aime apprendre, par exemple le re-frame pour déposer mon cv."
                       :maths "MATHEMATIQUES"
                       :sc "SUPPLY CHAIN"
                       :it "INFORMATIQUE"}
                  }))

(defn home-panel []
  [:<>
   [:h1 (tr [:home-msg])]
   [:p  (tr [:home-intro])]
   [:hr]

   [:a {:href "#/resume"}
    [:table#home-three-pilars
     [:tbody
      [:tr
       [:th]
       [:th
        [:p (tr [:it]) [:i.fa.fa-code.w3-margin-left]]
        [:img#it {:src "images/pages/it.png"}]
        ]
       [:th]
       ]
      [:tr
       [:th]
       [:th [:img#pilars {:src "images/pages/three-pilars.png"} ]]
       [:th]
       ]
      [:tr
       [:th
        [:p (tr [:sc]) [:i.fa.fa-industry.w3-margin-left]]
        [:img#sc {:src "images/pages/sc.png"}]
        ]
       [:th]
       [:th
        [:p (tr [:maths]) [:i.fa.fa-infinity.w3-margin-left]]
        [:img#math {:src "images/pages/math.png"}]
        ]
       ]]]
    ]])
