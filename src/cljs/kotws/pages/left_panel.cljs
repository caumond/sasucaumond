(ns kotws.pages.left-panel
  (:require [re-com.core :as re-com]
            [kotws.multi-language :as ml]
            ))



(defn panel []
  [:ul
   [:li [:a {:href "#/"} "Home"]]
   [:li {:class "dropdown"}
    [:a {:href "#/blog-cc-clojure"} "Blog"]
    [:div {:class "dropdown-content"}
     [:a {:href "#"} "Link 1"]
     [:a {:href "#"} "Link 2"]
     ]
    ]
   [:li [:a {:href "#/coi"} "COI"]]
   [:li [:a {:href "#/cv"} "CV"]]
   [:li [:a {:href "#/biblio" } "Biblio"]]
   [:li [:a {:href "#/about"} (ml/get-msg :about)]]
   ]
  )
