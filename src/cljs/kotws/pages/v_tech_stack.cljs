(ns kotws.pages.v-tech-stack
  (:require [kotws.ml :as ml]))

(def tr (partial ml/tr
                 {:en {:title    "My current preferred stack is:"
                       :sub-title "Find below the elements used for that website. It is my first website in clojure."
                       :clojure      {:desc "As a programming language used by default everywhere in the stack "}
                       :spacemacs    {:desc "As a full IDE integrated with clojure"}
                       :leiningen    {:desc "As an integration, templating, compilation tool"}
                       :cider        {:desc "As a clojure development to REPL tool, providing a full interactive experience in clojure development."}
                       :re-agent     {:desc "As a reactive UI provider"}
                       :clever-cloud {:desc "A cloud provider - deployment in docker mode"}
                       :git-lab      {:desc "As a configuration management system and PR/ER management tool"}
                       }
                  :fr {:title    "Ma stack technique préférée est "
                       :sub-title "Ci-dessous sont listés les éléments que j'ai utilisé pour ce site. Ce site est mon premier site en clojure."
                       :clojure      {:desc "Le language de programmation à utiliser partout sur la stack"}
                       :spacemacs    {:desc "IDE complétement intégré à clojure"}
                       :leiningen    {:desc "Comme outil d'intégration, de templating, de compilation"}
                       :cider        {:desc "Comme un outil intégrant le développement et le REPL, permettant une expérience interactive pendant le développement clojure"}
                       :re-agent     {:desc "Permet de faire des interfaces utilisateurs basées sur React"}
                       :clever-cloud {:desc "Hébergeur cloud - déploiement en mode docker"}
                       :git-lab      {:desc "Comme outil de gestion de configuration et de ticketing"}
                       }
                  }))

(def stack
  [{:name        :clojure
    :img         "images/pages/tech-stack/clojure.png"
    :href        "https://clojure.org"
    :description :clojure/desc}
   {:name        :spacemacs
    :img         "images/pages/tech-stack/spacemacs.svg"
    :href        "https://www.spacemacs.org/"
    :description :spacemacs/desc}
   {:name        :cider
    :img         "images/pages/tech-stack/cider.svg"
    :href        "https://docs.cider.mx/cider/index.html"
    :description :cider/desc}
   {:name        :leiningen
    :img         "images/pages/tech-stack/leiningen.jpg"
    :href        "https://leiningen.org/"
    :description :leiningen/desc}
   {:name        :re-frame
    :img         "images/pages/tech-stack/re-frame.png"
    :href        "https://github.com/day8/re-frame"
    :description :re-agent/desc}
   {:name        :clever-cloud
    :img         "images/pages/tech-stack/clever-cloud.svg"
    :href        "https://www.clever-cloud.com/en/"
    :description :clever-cloud/desc}
   {:name        :git-lab
    :img         "images/pages/tech-stack/git.svg"
    :href        "https://gitlab.com"
    :description :git-lab/desc}])

(defn tech-stack-panel[]
  [:<>
   [:h1 (tr [:title])]
   [:p (tr [:sub-title])]

   [:div.w3-row
    (doall
     (for [elt stack]
       ^{:key elt} [:div.tech-stack-item
                    [:a {:href (:href elt) :target "blank"}
                     [:h2 (:name elt)]
                     [:img {:src (:img elt)}]
                     [:p (tr [(:description elt)])]
                     ]]
       ))]])
