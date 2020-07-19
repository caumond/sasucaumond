(ns kotws.views
  (:require
   [re-frame.core :as re-frame]
   [re-com.core :as re-com]
   [kotws.subs :as subs]
   [kotws.multi-language :as ml]
   [kotws.pages.home.panel :refer [home-panel]]
   [kotws.pages.about.panel :refer [about-panel]]
   [kotws.pages.blog.cc-clojure.panel :refer [blog-cc-clojure-panel]]
   [kotws.pages.biblio.panel :refer [biblio-panel]]
   [kotws.pages.coi.panel :refer [coi-panel]]
   [kotws.pages.cv.panel :refer [cv-panel]]
   ))

;; main
(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    :blog-cc-clojure [blog-cc-clojure-panel]
    :coi [coi-panel]
    :cv [cv-panel]
    :biblio-panel [biblio-panel]
    [re-com/title :label (ml/get-msg :non-existing-panel panel-name) :level :level1]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [re-com/v-box
     :children [ [panels @active-panel]
                ]]))

