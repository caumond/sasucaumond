(ns kotws.pages.header
  (:require [kotws.routes :refer [home-link about-link]]
            ))

(defn header []
  [:header
   [:p [:a {:href (home-link)} "Home"] " | "
    [:a {:href (about-link)} "About"]
    ]
   [:hr]
   ])
