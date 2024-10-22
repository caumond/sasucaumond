(ns kotws.pages.v-about
  "About panel."
  (:require [kotws.multi-language :as ml]
            [kotws.components.table :as ktable]
            [kotws.components.lists :as klists]))

(defn tr
  [k]
  (-> {:about-title {:en "About", :fr "A propos"},
       :intro-sources {:en "This site is built with:",
                       :fr "Ce site est construit à partir de:"},
       :w3-template {:en "w3 schools for its templates w3.css",
                     :fr "w3 schools pour ses templates w3.css"},
       :reitit {:fr "Gestion des routes backend et frontend.",
                :en "Backend and frontend routes"},
       :reframe {:fr "React en Clojure", :en "React in Clojure"},
       :ring {:fr "Serveur http", :en "Http server"},
       :introduce-sasu {:fr "Ces activités sont réalisées par la ",
                        :en "These activities are carried over by "}}
      (ml/tr* k)))

(defn inspiration-sources
  []
  (-> [{:name "w3-template",
        :url "https://www.w3schools.com/w3css/tryw3css_templates_portfolio.htm"}
       {:name "reitit", :url "https://github.com/metosin/reitit"}
       {:name "reframe", :url "https://github.com/day8/re-frame"}
       {:name "ring", :url "https://github.com/ring-clojure/ring"}]
      ml/defaulting
      (ml/translate-keys [:description] tr)))

(defn v-about-panel
  []
  [:<> [:h1 "SASU CAUMOND"]
   [:div (tr :introduce-sasu)
    [:a {:href "https://www.societe.com/societe/caumond-905156402.html"}
     "SASU CAUMOND (cf. societe.com)"]
    [ktable/simple ["SIREN" "905156402"] ["SIRET" "90515640200018"]]] [:hr]
   [:p (tr :intro-sources)] (klists/bullet (inspiration-sources))])

(defn about-panel [] (v-about-panel))
