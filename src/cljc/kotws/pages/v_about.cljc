(ns kotws.pages.v-about
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]
            [kotws.components.v-table :as kvtable]
            [kotws.components.v-lists :as kvlists]))

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
   :reitit-desc {:fr "Gestion des routes backend et frontend.",
                 :en "Backend and frontend routes"},
   :reframe-desc {:fr "React en Clojure", :en "React in Clojure"},
   :ring-desc {:fr "Serveur http", :en "Http server"},
   :introduce-sasu {:fr "Ces activités sont réalisées par la ",
                    :en "These activities are carried over by "},
   :icons {:fr "Icones créées avec Freepik - Flaticon",
           :en "Icons created by Freepik - Flaticon"},
   :font-awesome {:fr "Icones créées avec Fontawesome",
                  :en "Icons created by fontawesome"}})

(def tr (partial klang/tr dic))

(def inspiration-sources-data
  {:w3-template {}, :reitit {}, :re-frame {}, :ring {}})

(def inspiration-sources
  (-> inspiration-sources-data
      klang/default-name
      (klang/urls [:href] klinks/external-links)
      (klang/translate-langs [:desc] klang/possible-langs tr)))

(def ids
  (-> {:SIREN {:cells ["905156402"]}, :SIRET {:cells ["90515640200018"]}}
      klang/default-name))

(defn v-about
  [l]
  (let [tr (partial tr l)]
    [:<> [:h1.text "SASU CAUMOND"]
     [:div.text (tr :introduce-sasu)
      [:a {:href (:url (klinks/external-link :sasu-societe))}
       "SASU CAUMOND (cf. societe.com)"]
      ;
      [kvtable/simple ids]] [:hr] [:p.text (tr :intro-sources)]
     [kvlists/bullet (get inspiration-sources l)]
     [:a {:href (:url (klinks/external-link :flaticon))} [:p (tr :icons)]]
     [:a {:href (:url (klinks/external-link :fontawesome))}
      [:p (tr :font-awesome)]]]))
