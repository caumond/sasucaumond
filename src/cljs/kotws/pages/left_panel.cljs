(ns kotws.pages.left-panel
  (:require [re-com.core :as re-com]
            [kotws.multi-language :as ml]
            ))

(defn panel []
  [:ul
   {:class "left-panel"}
   [:li [:a {:href "#/"} "Home"]]
   [:li {:class "dropdown"}
    [:a {:href "#/blog-cc-clojure"} "Blog"]
    [:div {:class "dropdown-content"}
     [:a {:href "#"} "Link 1"]
     [:a {:href "#"} "Link 2"]
     ]
    ]
   [:li [re-com/hyperlink-href :label "COI" :href "#/coi"]]
   [:li [re-com/hyperlink-href :label "CV" :href "#/cv"]]
   [:li [:a {:href "#/biblio"} "Biblio"]]
   [:li [re-com/hyperlink-href :label "About" :href "#/about"]]
   ]
  )
