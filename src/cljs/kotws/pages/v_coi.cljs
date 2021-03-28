(ns kotws.pages.v-coi
  (:require [kotws.subs :as subs]
            [re-frame.core :as rf]
            [kotws.multi-language :as ml]
            ))

(def dictionnary
  {:en {:coi-title "My current preferred stack is:"}
   :fr {:coi-title "Ma stack technique préférée est "}
   })

(def stack
  '({:name :clojure
     :img "http://clojure.org/images/clojure-logo-120b.png"
     :href "https://clojure.org"
     :description {:en "As a programming language used by default everywhere in the stack "
                   :fr "Le language de programmation à utiliser partout sur la stack"}}
    {:name :spacemacs
     :img "http://spacemacs.org/img/logo.svg"
     :href "https://www.spacemacs.org/"
     :description {:en "As a full IDE integrated with clojure"
                   :fr "IDE complétement intégré à clojure"}}
    {:name :leiningen
     :img "https://leiningen.org/img/leiningen.jpg"
     :href "https://leiningen.org/"
     :description {:en "As an integration, templating, compilation tool"
                   :fr "Comme outil d'intégration, de templating, de compilation"}}
    {:name :cider
     :img "https://cider.mx/img/cider_logo.svg"
     :href "https://docs.cider.mx/cider/index.html"
     :description {:en "As a clojure development to REPL tool, providing a full interactive experience in clojure development. Youpla boom.Youpla boom.Youpla boom.Youpla boom.Youpla boom.Youpla boom.Youpla boom.Youpla boom."
                   :fr "Comme un outil intégrant le développement et le REPL, permettant une expérience interactive pendant le développement clojure"}}
    {:name :re-agent
     :img "https://github.com/reagent-project/reagent/raw/master/logo/logo-text.png"
     :href "https://github.com/reagent-project/reagent"
     :description {:en "As a reactive UI provider"
                   :fr "Permet de faire des interfaces utilisateurs basées sur React"}}
    {:name :clever-cloud
     :img "https://www.clever-cloud.com/images/brand-assets/logos/v2/logo_on_white.svg"
     :href "https://www.clever-cloud.com/en/"
     :description {:en "As a cloud provider"
                   :fr "Hébergeur cloud"}}
    {:name :log-back
     :img "http://logback.qos.ch/images/logos/lblogo.jpg"
     :href "http://logback.qos.ch/"
     :description {:en "As an implementation for log management"
                   :fr "Implémentation de la gestion de log"}}
    {:name :quartzite
     :img "http://www.quartz-scheduler.org/images/Quartz_Logo_large.jpg"
     :href "https://github.com/michaelklishin/quartzite"
     :description {:en "As a scheduler for everywhere in the stack (frontend and backend)"
                   :fr "Permet de planifier les tâches partout dans la stack (front & back end)"}}
    {:name :git-lab
     :img "https://assets.gitlab-static.net/assets/illustrations/golden_tanuki-a88ad492b973a0ea6be2316b12aeb3a76ee4e926b3b217dc26d01a57033c9948.svg"
     :href "https://gitlab.com/dashboard/projects"
     :description {:en "As a configuration management system and PR/ER management tool"
                   :fr "Comme outil de gestion de configuration et de ticketing"}}
    {:name :see-saw
     :img "https://www.goodfreephotos.com/albums/vector-images/balance-and-seesaw-vector-clipart.png"
     :href "https://github.com/daveray/seesaw"
     :description {:en "To build heavy client-based on swing with clojure and multiplatform power"
                   :fr "Pour construire des applications en client lourd, basé sur swing et clojure, avec la puissance du multiplatforme"}}
    ))

(defn coi-panel[]
  (let [language (rf/subscribe [::subs/language])
        get-msg  (partial (ml/build-translate dictionnary) @language)]
    [:div#coi.w3-row-padding
     [:h1 (get-msg :coi-title)]
     (doall
       (for [elt stack]
         ^{:key elt} [:div#coi-item
                      [:a {:href (:href elt)}
                       [:h2 (:name elt)]
                       [:img.coi-image {:src (:img elt)}]
                       [:p
                        (@language (:description elt))]
                       ]]
         ))
     ])
  )
