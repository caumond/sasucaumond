(ns kotws.core
  (:require
   [reagent.core :as reagent ;;:refer [atom]
    ]
   [reagent.dom :as rdom]
   [reagent.session :as session]
   [reitit.frontend :as reitit]
   [clerk.core :as clerk]
   [accountant.core :as accountant]
   [kotws.about :refer [about-page]]
   [kotws.cv :refer [cv-page]]
   [kotws.coi :refer [coi-page]]
   [kotws.biblio :refer [biblio-page]]
   ))

;; -------------------------
;; Routes

(def router
  (reitit/router
   [["/" :index]
    ["/cv" :cv]
    ["/center-of-interest" :coi]
    ["/biblio" :biblio]
    ["/about" :about]]))

(defn path-for [route & [params]]
  (if params
    (:path (reitit/match-by-name router route params))
    (:path (reitit/match-by-name router route))))

;; -------------------------
;; Page components

(defn home-page []
  (fn []
    [:div.main
     [:h1 "Welcome to kotws"]
     ]))


;; -------------------------
;; Translate routes -> page components

(defn page-for [route]
  (case route
    :index #'home-page
    :about #'about-page
    :cv #'cv-page
    :coi #'coi-page
    :biblio #'biblio-page
    ))


;; -------------------------
;; Page mounting component

(defn current-page []
  (fn []
    (let [page (:current-page (session/get :route))]
      [:div
       [:header
        [:p [:a {:href (path-for :index)} "Home"] " | "
         [:a {:href (path-for :cv)} "CV"] " | "
         [:a {:href (path-for :coi)} "Center of Interests"] " | "
         [:a {:href (path-for :about)} "About"] " | "
         [:a {:href (path-for :biblio)} "Biblio"]
         ]
        [:hr]
        ]
       [page]
       [:footer
        [:hr]
        [:p "kotws website - 2020"]]])))

;; -------------------------
;; Initialize app

(defn mount-root []
  (rdom/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (clerk/initialize!)
  (accountant/configure-navigation!
   {:nav-handler
    (fn [path]
      (let [match (reitit/match-by-path router path)
            current-page (:name (:data  match))
            route-params (:path-params match)]
        (reagent/after-render clerk/after-render!)
        (session/put! :route {:current-page (page-for current-page)
                              :route-params route-params})
        (clerk/navigate-page! path)
        ))
    :path-exists?
    (fn [path]
      (boolean (reitit/match-by-path router path)))})
  (accountant/dispatch-current!)
  (mount-root))
