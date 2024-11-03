(ns kotws.pages.v-tech-stack
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]
            [kotws.components.v-headered-list :as kvheadered-list]))

(def dic
  {:title {:en "My technical stack is:", :fr "Ma pile technique:"},
   :sub-title
     {:en
        "I'm typically using the libraries and toolings below to build my apps.",
      :fr
        "J'utilise typiquement les librairies et outils ci-dessous pour construire mes applications."},
   :details {:en "Details", :fr "Détails"},
   :clojure {:en "Clojure", :fr "Clojure"},
   :clojure-desc {:en "Programming language for backends.",
                  :fr "Langage de programmation côté serveur."},
   :clojure-long-desc
     {:en
        "Clojure is my preferred language, here are some reasons why: the community is highly skilled, available, and benevolent, some small but stable libraries, immutability is at the core, data orientation is the norm",
      :fr
        "Clojure est mon langage préféré, voici quelques raisons: communauté hautement compétente, bienveillante et disponible, des librairies élémentaires mais stables, l'immutabilité au coeur, être orienté donnée est la norme."},
   :clojurescript {:en "Clojurescript", :fr "Clojurescript"},
   :clojurescript-desc {:en "Programming language for web frontends",
                        :fr "Le langage de programmation côté client web"},
   :clojurescript-long-desc
     {:en
        "In the continuity of clojure, making clojurescript for the web offers great advantages. Particularly to write only once the business code (because it must be agnostic of any technology) in files common to Clojure and Clojurescript.",
      :fr
        "Dans la continuité de clojure, faire du clojurescript pour le web offre de grands avantages. Particulièrement de n'écrire qu'une seule fois le code métier (car il doit être agnostique de toute technologie) dans des fichiers communs à Clojure et Clojurescript."},
   :babashka {:en "Babashka", :fr "Babashka"},
   :babashka-desc {:en "Scripting programming language.",
                   :fr "Le langage de programmation pour scripter"},
   :babashka-long-desc
     {:fr
        "Son temps de démarrage ultra rapide (basé sur Graalvm) permet de gérer les tâches du projet dans un langage très proche de Clojure.",
      :en
        "Its ultra-fast startup time (based on Graalvm) allows you to write project tasks in a language very close to Clojure."},
   :doom-emacs {:en "Doom", :fr "Doom"},
   :doom-emacs-desc {:en "Integrated Development Environment",
                     :fr "Environnement intégré de développement"},
   :doom-emacs-long-desc
     {:en
        "With Doom Emacs, I can simply make the most of Emacs without paying the whole cost up-front. The Emacs's editing features are crazily efficient, Clojure integration is perfect, and PC resource consumption is quite reasonable compared to other IDEs. Furthermore, the same setup works on Mac and Linux together.",
      :fr
        "Doom me permet de tirer le meilleur parti d'Emacs sans pour autant payer le ticket d'entrée dès le début. Les fonctionnalités d'édition d'emacs sont follement productives, l'intégration avec clojure parfaite, et l'empreinte sur les ressources du pc complétement raisonnable. Sans compter que la même configuration fonctionne à l'identique sur mes environnements Linux et Mac."},
   :re-frame {:en "Re-frame", :fr "Re-frame"},
   :re-frame-desc {:en "React in Clojure", :fr "Du react en Clojure"},
   :re-frame-long-desc
     {:en
        "Reframe is a lightweight library for many reasons. It is efficient at runtime, nothing is mandatory, and other behaviors could happen outside the framework. Reframe is nearly a de facto standard for Clojurescript frontend development.",
      :fr
        "Reframe est une libraire très légère à plus d'un titre, les outils sont efficaces à l'exécution, rien n'est obligatoire et d'autres comportements peuvent être réalisés complètement à l'extérieur, et c'est quasiment un standard 'de facto' pour les frontends clojure."},
   :clever-cloud {:en "Clever cloud", :fr "Clever cloud"},
   :clever-cloud-desc {:en "A souvereign and managed cloud provider.",
                       :fr
                         "Hébergeur français souverain simple et automatisé."},
   :clever-cloud-long-desc
     {:en
        "Clever cloud is perfectly suited to deploying JVM solutions, as is clojure. Simple and efficient, it is like the solutions I like to build: \"it just works!\"",
      :fr
        "Clever cloud est tout à fait adapté pour déployer les solutions JVMs, comme l'est clojure. Simple et efficace, il est à l'image des solutions que j'aime construire: \"ça marche tout simplement!\""},
   :git-hub {:en "Github", :fr "Github"},
   :git-hub-desc {:en "Code configuration management",
                  :fr "Gestion de configuration"},
   :git-hub-long-desc
     {:en
        "To store the code repositories, to interact with other developers, to publish open source code, and to automatize CICD.",
      :fr
        "D'abord pour stocker les repositories de code, interagir avec les autres développeurs, publier les open sources, et automatiser la CICD."}})

(def tr (partial klang/tr dic))

(def items
  {:clojure {},
   :clojurescript {},
   :babashka {},
   :doom-emacs {},
   :re-frame {},
   :clever-cloud {},
   :git-hub {}})

(defn c-tech-stack
  [l]
  (let [current-tr (partial tr l)
        tech-stack (kvheadered-list/defaulting* items
                                                tr
                                                klinks/image-link
                                                klinks/external-link)
        ts (get tech-stack l)]
    [:<> [:h1.text (current-tr :title)] [:p.text (current-tr :sub-title)]
     [kvheadered-list/header ts] [:p ""] [:h1.text (current-tr :details)]
     [kvheadered-list/detailed-list ts :small]]))
