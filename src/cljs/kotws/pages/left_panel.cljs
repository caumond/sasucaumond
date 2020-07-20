(ns kotws.pages.left-panel
  (:require [re-com.core :as re-com]
            [kotws.multi-language :as ml]
            ))

(defn panel []
  [:ul
   {:class "left-panel"}
   [re-com/label :label "coucou"]
   [:li [re-com/hyperlink-href :label "Home" :href "#/"]]
   [:li [re-com/hyperlink-href :label "Blog" :href "#/blog-cc-clojure"]]
   [:li [re-com/hyperlink-href :label "COI" :href "#/coi"]]
   [:li [re-com/hyperlink-href :label "CV" :href "#/cv"]]
   [:li [re-com/hyperlink-href :label "Biblio" :href "#/biblio"]]
   [:li [re-com/hyperlink-href :label "About" :href "#/about"]]
   ]
  )
