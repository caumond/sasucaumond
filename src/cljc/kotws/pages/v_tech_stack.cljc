(ns kotws.pages.v-tech-stack
  (:require [kotws.language :as klang]
            [kotws.components.v-headered-list :as kvheadered-list]))

(def dic
  {:title {:en "My technical stack is:", :fr "Ma pile technique:"},
   :sub-title
     {:en
        "I'm typically using the libraries and toolings below to build my apps.",
      :fr
        "J'utilise typiquement les librairies et outils ci-dessous pour construire mes applications."},
   :clojure {:en "Programming language for backends.",
             :fr "Language de programmation côté serveur."},
   :clojure-desc
     {:en
        "Clojure is my preferred language, here are some reasons why: the community is highly skilled, available, and benevolent, some small but stable libraries, immutability is at the core, data orientation is the norm",
      :fr
        "Clojure est mon langage préféré, voici quelques raisons: communauté hautement compétente, bienveillante et disponible, des librairies élémentaires mais stables, l'immutabilité au coeur, être orienté donnée est la norme."},
   :clojurescript {:en "Programming language for web frontends",
                   :fr "Le language de programmation côté client web"},
   :clojurescript-desc
     {:en "",
      :fr
        "Dans la continuité de clojure, faire du clojurescript pour le web offre de grands avantages. Particulièrement de n'écrire qu'une seule fois le code métier (car il doit être agnostique de toute technologie) dans des fichiers communs à Clojure et Clojurescript."},
   :babashka {:en "Scripting programming language.",
              :fr "Le language de programmation pour scripter"},
   :babashka-desc
     {:fr
        "Son temps de démarrage ultra rapide (basé sur Graalvm) permet de gérer les tâches du projet dans un langage très proche de Clojure.",
      :en
        "Its ultra-fast startup time (based on Graalvm) allows you to write project tasks in a language very close to Clojure."},
   :doom-emacs {:en "Integrated Development Environment",
                :fr "Environnement intégré de développement"},
   :doom-emacs-desc
     {:en
        "With Doom Emacs, I can simply make the most of Emacs without paying the whole cost up-front. The Emacs's editing features are crazily efficient, Clojure integration is perfect, and PC resource consumption is quite reasonable compared to other IDEs. Furthermore, the same setup works on Mac and Linux together.",
      :fr
        "Doom me permet de tirer le meilleur parti d'Emacs sans pour autant payer le ticket d'entrée dès le début. Les fonctionnalités d'édition d'emacs sont follement productives, l'intégration avec clojure parfaite, et l'emprunte sur les ressources du pc complétement raisonnable. Sans compter que la même configuration fonctionne à l'identique sur mes environnements Linux et Mac."},
   :re-frame {:en "React in Clojure", :fr "Du react en Clojure"},
   :re-frame-desc
     {:en
        "Reframe is a lightweight library for many reasons. It is efficient at runtime, nothing is mandatory, and other behaviors could happen outside the framework. Reframe is nearly a de facto standard for Clojurescript frontend development.",
      :fr
        "Reframe est une libraire très légère à plus d'un titre, les outils sont efficaces à l'exécution, rien n'est obligatoire et d'autres comportements peuvent être réalisés complètement à l'extérieur, et c'est quasiment un standard 'de facto' pour les frontends clojure."},
   :clever-cloud {:en "A souvereign and managed cloud provider.",
                  :fr "Hébergeur français souverain simple et automatisé."},
   :clever-cloud-desc
     {:en "",
      :fr
        "Clever cloud est tout à fait adapté pour déployer les solutions JVMs, comme l'est clojure. Simple et efficace, il est à l'image des solutions que j'aime construire: \"ça marche tout simplement!\""},
   :git-hub {:en "Code configuration management",
             :fr "Gestion de configuration"},
   :git-hub-desc
     {:en
        "To store the code repositories, to interact with other developers, to publish open source code, and to automatize CICD.",
      :fr
        "D'abord pour stocker les repositories de code, interagir avec les autres développeurs, publier les open sources, et automatiser la CICD."}})

(def tech-stack
  (letfn
    [(t [l]
       (->
         {:clojure {:name "Clojure",
                    :img-url "images/tech_stack/clojure.png",
                    :href "https://clojure.org"},
          :clojurescript {:name "Clojurescript",
                          :img-url "images/tech_stack/clojurescript.png",
                          :href "https://clojurescript.org/"},
          :babashka {:name "babashka",
                     :img-url "images/tech_stack/babashka.png",
                     :href "https://github.com/babashka/babashka#installation"},
          :doom {:name "Doom emacs",
                 :img-url "images/tech_stack/doom.png",
                 :href "https://github.com/doomemacs/doomemacs"},
          :re-frame {:name "re-frame",
                     :img-url "images/tech_stack/re-frame.png",
                     :href "https://github.com/day8/re-frame"},
          :clever-cloud {:name "Clever cloud",
                         :img-url "images/tech_stack/clever-cloud.svg",
                         :href "https://www.clever-cloud.com/en/"},
          :github {:name "Git hub",
                   :img-url "images/gh.jpeg",
                   :href "https://github.com/caumond"}}
         (klang/default-and-translate [:desc :name] (partial klang/tr dic l))))]
    (->> klang/possible-langs
         (mapv (fn [l] [l (t l)]))
         (into {}))))

(defn c-tech-stack
  [l]
  (let [tr (partial klang/tr dic l)
        ts (get tech-stack l)]
    [:<> [:h1 (tr :title)] [:p (tr :sub-title)] [kvheadered-list/header ts]
     [:hr] [:h1 "Details:"] [kvheadered-list/detailed-list ts]]))
