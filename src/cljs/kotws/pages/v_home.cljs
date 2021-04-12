(ns kotws.pages.v-home
  (:require [kotws.ml :as ml]))

(def tr (partial ml/tr
                 {:en {:home-msg   "Professional website of Anthony CAUMOND"
                       :home-intro "This website presents me and my professional career. Have a look to my resume, you'll see it is based on three pilars: I.T. - supply chain - optimization:"}
                  :fr {:home-msg    "Site professionnel d'Anthony CAUMOND"
                       :home-intro  "Ce site me présente, moi et ma carrière professionnelle. Vous pourrez découvrir dans mon cv qu'elle est basée sur trois piliers: l'informatique, la supply chain et l'optimisation:"}
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
       [:th [:img#it {:src "images/pages/it.png"}]]
       [:th]
       ]
      [:tr
       [:th]
       [:th [:img#pilars {:src "images/pages/three-pilars.png"} ]]
       [:th]
       ]
      [:tr
       [:th [:img#sc {:src "images/pages/sc.png"}]]
       [:th]
       [:th [:img#math {:src "images/pages/math.png"}]]
       ]]]
    ]])
