(ns kotws.pages.v-about
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]
            [kotws.components.v-bullet :as kvbullet]
            [kotws.components.v-table :as kvtable]))

(def dic
  {:about-title {:en "About", :fr "A propos"},
   :intro-sources
     {:en
        "The project is built on the following dependencies. Note that they are few in number, which is in my conception of computing a guarantee of simplicity and stability.",
      :fr
        "Le projet est bâti sur les dépendances suivantes. Remarquez qu'elles sont peu nombreuses, ce qui est dans ma conception de l'informatique un gage de simplicité, de stabilité."},
   :w3-template-desc
     {:en
        "A css library for building simple, reactive sites (i.e. compatible with computer, pads or phone screen size).",
      :fr
        "Une bibliothèque css pour construire des sites simples, et `reactive` (i.e. compatible avec les écrans d'ordinateurs, téléphones ou tablettes ...)."},
   :ring {:fr "ring", :en "ring"},
   :reitit {:fr "reitit", :en "reitit"},
   :re-frame {:fr "re-frame", :en "re-frame"},
   :reitit-desc {:fr "Gestion des routes backend et frontend.",
                 :en "Backend and frontend routes"},
   :re-frame-desc {:fr "React en Clojure", :en "React in Clojure"},
   :ring-desc {:fr "Serveur http", :en "Http server"},
   :w3-template {:fr "w3-template", :en "w3-template"},
   :introduce-sasu {:fr "Ces activités sont réalisées par la ",
                    :en "These activities are carried over by "},
   :icons {:fr "Icones créées avec Freepik - Flaticon",
           :en "Icons created by Freepik - Flaticon"},
   :siren {:fr "SIREN", :en "SIREN"},
   :siret {:fr "SIRET", :en "SIRET"},
   :font-awesome {:fr "Icones créées avec Fontawesome",
                  :en "Icons created by fontawesome"}})

(def tr (partial klang/tr dic))

(def items {:w3-template {}, :reitit {}, :re-frame {}, :ring {}})

(def id-items
  {:siren {:cells ["905156402"]}, :siret {:cells ["90515640200018"]}})

(comment
  (klinks/external-link :w3-template)
  ;
)

(defn defaulting
  [items]
  (kvbullet/defaulting items tr klinks/external-link klang/possible-langs))

(def defaulting* (memoize defaulting))

(defn v-about
  [l]
  (let [current-tr (partial tr l)
        ids (kvtable/defaulting id-items tr klang/possible-langs)
        inspiration-sources (defaulting* items)]
    [:<> [:h1.text "SASU CAUMOND"]
     [:div.text (current-tr :introduce-sasu)
      (klinks/a klinks/external-links
                :sasu-societe
                "SASU CAUMOND (cf. societe.com)") [kvtable/simple (get ids l)]]
     [:p ""] [:p.text (current-tr :intro-sources)]
     [kvbullet/bullet (get inspiration-sources l)]
     (klinks/a klinks/external-links :flaticon [:p (current-tr :icons)])
     (klinks/a klinks/external-links
               :fontawesome
               [:p (current-tr :font-awesome)])]))
