(ns kotws.pages.v-tech-stack
  (:require [kotws.ml :as ml]))

(def tr (partial ml/tr
           {:en {:coi-title    "My current preferred stack is:"
                 :clojure      {:desc "As a programming language used by default everywhere in the stack "}
                 :spacemacs    {:desc "As a full IDE integrated with clojure"}
                 :leiningen    {:desc "As an integration, templating, compilation tool"}
                 :cider        {:desc "As a clojure development to REPL tool, providing a full interactive experience in clojure development."}
                 :re-agent     {:desc "As a reactive UI provider"}
                 :clever-cloud {:desc "As a cloud provider"}
                 :git-lab      {:desc "As a configuration management system and PR/ER management tool"}
                 }
            :fr {:coi-title    "Ma stack technique préférée est "
                 :clojure      {:desc "Le language de programmation à utiliser partout sur la stack"}
                 :spacemacs    {:desc "IDE complétement intégré à clojure"}
                 :leiningen    {:desc "Comme outil d'intégration, de templating, de compilation"}
                 :cider        {:desc "Comme un outil intégrant le développement et le REPL, permettant une expérience interactive pendant le développement clojure"}
                 :re-agent     {:desc "Permet de faire des interfaces utilisateurs basées sur React"}
                 :clever-cloud {:desc "Hébergeur cloud"}
                 :git-lab      {:desc "Comme outil de gestion de configuration et de ticketing"}
                 }
            }))

(def stack
  [{:name        :clojure
    :img         "http://clojure.org/images/clojure-logo-120b.png"
    :href        "https://clojure.org"
    :description :clojure/desc}
   {:name        :spacemacs
    :img         "http://spacemacs.org/img/logo.svg"
    :href        "https://www.spacemacs.org/"
    :description :spacemacs/desc}
   {:name        :leiningen
    :img         "https://leiningen.org/img/leiningen.jpg"
    :href        "https://leiningen.org/"
    :description :leiningen/desc}
   {:name        :cider
    :img         "https://cider.mx/img/cider_logo.svg"
    :href        "https://docs.cider.mx/cider/index.html"
    :description :cider/desc}
   {:name        :re-agent
    :img         "https://github.com/reagent-project/reagent/raw/master/logo/logo-text.png"
    :href        "https://github.com/reagent-project/reagent"
    :description :re-agent/desc}
   {:name        :clever-cloud
    :img         "https://www.clever-cloud.com/images/brand-assets/logos/v2/logo_on_white.svg"
    :href        "https://www.clever-cloud.com/en/"
    :description :clever-cloud/desc}
   {:name        :git-lab
    :img         "https://assets.gitlab-static.net/assets/illustrations/golden_tanuki-a88ad492b973a0ea6be2316b12aeb3a76ee4e926b3b217dc26d01a57033c9948.svg"
    :href        "https://gitlab.com/dashboard/projects"
    :description :git-lab/desc}])

(defn tech-stack-panel[]
  [:div#coi.w3-row-padding
   [:h1 (tr [:coi-title])]
   (doall
     (for [elt stack]
       ^{:key elt} [:div#coi-item
                    [:a {:href (:href elt)}
                     [:h2 (:name elt)]
                     [:img.coi-image {:src (:img elt)}]
                     [:p (tr [(:description elt)])]
                     ]]
       ))
   ]
  )
