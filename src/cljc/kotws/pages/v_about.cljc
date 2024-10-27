(ns kotws.pages.v-about
  "About panel."
  (:require [kotws.language :as klang]
            [kotws.components.v-table :as kvtable]
            [kotws.components.v-lists :as kvlists]))

(def dic
  {:about-title {:en "About", :fr "A propos"},
   :intro-sources
     {:en
        "The project is built on the following dependencies. Note that they are few in number, which is in my conception of computing a guarantee of simplicity and stability.",
      :fr
        "Le projet est bâti sur les dépendances suivantes. Remarquez qu'elles sont peu nombreuses, ce qui est dans ma conception de l'informatique un gage de simplicité, de stabilité."},
   :w3-css-desc
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


(def inspiration-sources
  (letfn
    [(i [l]
       (->
         {:w3-css
            {:href
               "https://www.w3schools.com/w3css/tryw3css_templates_portfolio.htm"},
          :reitit {:href "https://github.com/metosin/reitit"},
          :reframe {:href "https://github.com/day8/re-frame"},
          :ring {:href "https://github.com/ring-clojure/ring"}}
         (klang/default-and-translate [:desc] (partial klang/tr dic l))))]
    (->> klang/possible-langs
         (mapv (fn [l] [l (i l)]))
         (into {}))))

(def ids
  (letfn [(i [_l]
            (-> {:SIREN {:cells ["905156402"]},
                 :SIRET {:cells ["90515640200018"]}}
                (klang/default-and-translate [] nil)))]
    (->> klang/possible-langs
         (mapv (fn [l] [l (i l)]))
         (into {}))))

(defn v-about
  [l]
  (let [tr (partial klang/tr dic l)]
    [:<> [:h1.text "SASU CAUMOND"]
     [:div.text (tr :introduce-sasu)
      [:a {:href "https://www.societe.com/societe/caumond-905156402.html"}
       "SASU CAUMOND (cf. societe.com)"] [kvtable/simple (get ids l)]] [:hr]
     [:p.text (tr :intro-sources)] (kvlists/bullet (get inspiration-sources l))
     [:a {:href "https://www.flaticon.com/free-icons/tire"} (tr :icons)]
     [:a {:href "https://fontawesome.com/v4/"} (tr :font-awesome)]]))
