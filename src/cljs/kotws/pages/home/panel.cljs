(ns kotws.pages.home.panel
  (:require [kotws.multi-language :as ml]
            ))

(defn home-panel []
  [:div {:class "home-main"}
   [:div {:class "bg-image"}]
   [:div {:class "bg-text" }
    [:h1 "I'm Anthony CAUMOND"]
    [:p (ml/get-msg :home-intro)]
    ]]
  )
