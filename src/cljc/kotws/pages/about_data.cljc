(ns kotws.pages.about-data
  "About panel."
  (:require [kotws.multi-language :as kmulti-language]
            [kotws.components.table :as ktable]
            [kotws.components.lists :as klists]))

(def dic
  {:about-title {:en "About", :fr "A propos"},
   :intro-sources {:en "This site is built with:",
                   :fr "Ce site est construit à partir de:"},
   :w3-template-desc {:en "w3 schools for its templates w3.css",
                      :fr "w3 schools pour ses templates w3.css"},
   :reitit-desc {:fr "Gestion des routes backend et frontend.",
                 :en "Backend and frontend routes"},
   :reframe-desc {:fr "React en Clojure", :en "React in Clojure"},
   :ring-desc {:fr "Serveur http", :en "Http server"},
   :introduce-sasu {:fr "Ces activités sont réalisées par la ",
                    :en "These activities are carried over by "}})

(defn inspiration-sources
  [l]
  (-> {:w3-template
         {:href
            "https://www.w3schools.com/w3css/tryw3css_templates_portfolio.htm"},
       :reitit {:href "https://github.com/metosin/reitit"},
       :reframe {:href "https://github.com/day8/re-frame"},
       :ring {:href "https://github.com/ring-clojure/ring"}}
      (kmulti-language/default-and-translate
        [:desc]
        (partial kmulti-language/tr dic l))))

(inspiration-sources :en)

(defn ids
  [_l]
  (-> {:SIREN {:cells ["905156402"]}, :SIRET {:cells ["90515640200018"]}}
      (kmulti-language/default-and-translate [] nil)))

(defn v-about-panel
  [l]
  (let [tr (partial kmulti-language/tr dic l)]
    [:<> [:h1 "SASU CAUMOND"]
     [:div (tr :introduce-sasu)
      [:a {:href "https://www.societe.com/societe/caumond-905156402.html"}
       "SASU CAUMOND (cf. societe.com)"] [ktable/simple (ids l)]] [:hr]
     [:p (tr :intro-sources)] (klists/bullet (inspiration-sources l))]))
