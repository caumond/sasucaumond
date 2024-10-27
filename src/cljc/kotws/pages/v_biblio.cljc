(ns kotws.pages.v-biblio
  (:require [kotws.components.v-slider :as kvslider]
            [kotws.links :as klinks]
            [kotws.lang :as klang]))

(def dic
  {:desc-title {:en "Sum-up", :fr "Synthèse"},
   :desc-detailed-title {:en "Content", :fr "Contenu"},
   :biblio-title {:en "Bibliography", :fr "Bibliographie"},
   :biblio-intro
     {:en
        "Here are some noticeable books I took pleasure to read and I'd like to share with you, as they're saying something about me.",
      :fr
        "Je vous souhaite autant de plaisir que moi à lire ces ouvrages, c'est pour ceci que je les partage avec vous, mais aussi parce qu'ils disent quelque chose de moi."},
   :ddd-desc
     {:fr
        "Une référence dans le monde du DDD, ce livre est plein de recettes et d'exemples pratiques. L'idée abordée dans clean code à travers le nommage des variables passe à un niveau supérieur. Ce livre énonce un aspect sociologique que j'ai ressenti dans l'industrie: Une application est un microcosme, avec son vocabulaire. Et bien sûr des éléments méthodologiques et des outils pour gérer la complexité.",
      :en
        "This book is a reference book in the DDD world, full of recipes and practical examples. The idea behind variable naming in clean code is going to the next level here. This book raises a sociological aspect I felt in the industry: An application is a microcosm, with vocabularies. And of course, the book gives methodology and tools to tackle that complexity."},
   :ddd-details
     {:fr
        "Dans l'industrie, j'ai ressenti deux choses que le DDD vient tacler. D'abord une application n'ést pas qu'un objet technique, mais aussi social: celui des ingénieurs qui conçoivent les processus, ceux des analystes qui conçoivent l'application, ceux des développeurs qui la font, du support et des utilisateurs qui travailleront avec l'application pendant des dizaines d'années. Dans les expériences que j'ai vécu, chacun des groupes précédemment cités ajoute leur couche de complexité en créant son propre vocabulaire, et la conception qui va avec. De plus, il ne faut pas imaginer cette diversité à un instant, mais dans le temps, avec des groupes de personnes qui évoluent dans le temps, qui ont même tendance à se démarquer de leur propre prédécesseur. Le DDD énonce ceci, et explique le principe du langage ubiquite. Je ne crois pas que la mesure de ce principe ait été prise dans l'industrie, et surtout du coût que représente sa non application.",
      :en
        "In the industry, I discovered two phenomenons that DDD is dealing with. First, an application is not only a technical object but also a social object: engineers who design processes, analysts who design apps, developers who code, but also support analysts and users who will work with the app for decades. In my experience, each group adds some complexity and has its own vocabulary, and the design coming with it. The worst is that the picture is evolving with time, and each group replacing its predecessor introduces also a shift in the vocabulary. The DDD states that in detail, and tells us about the ubiquitous language. I don't believe the industry realizes how much this principle is important, nor the cost spent because it is, most of the time, not."},
   :clojure-programming-desc
     {:fr
        "Ce livre a longtemps été mon livre de chevet, après avoir appris par ailleurs les bases de clojure, il permet de bien en appréhender les détails, l'esprit du langage. La première lecture ne m'a pas suffi, il faut y revenir régulièrement pour bien intégrer les éléments.",
      :en
        "This book has been my bedside book for a while. After I learned Clojure elsewhere, this book gave me more details and a deeper understanding of available mechanisms and opinions behind the language's choice. The first reading of it is not sufficient, ingesting all its content needs many scans."},
   :platform-revolution-desc
     {:fr
        "Ce livre m'a surtout donné une meilleure compréhension des plateformes, que je connaissais sans en comprendre les mécanismes. Cela m'a par exemple permis de mieux comprendre l'histoire de Microsoft ou des réseaux sociaux. Même si je ne construis pas de plateformes pour l'instant, ces principes sont très éclairants et peuvent être pris en compte dans n'importe quel contexte.",
      :en
        "That book gave me principally a better understanding of platforms, and artifacts I knew but didn't understand their principles before. With that in mind, I've better understood Microsoft's platform raising or the one of social networks. Even if I don't build a platform for now, those principles are enlightening and could be taken into account whatever the context is."},
   :clean-code-desc
     {:fr
        "Après avoir lu `clean architecture`, ce livre explique comment mettre en oeuvre les mêmes principes mais au niveau du code plutôt que de l'architecture. Un aspect évoqué dans ce livre quoique peu développé m'a frappé: le nom des variables n'est pas simplement un élément technique pour le compilateur, il doit aussi raconter une histoire. Ces éléments seront plus développés dans les livres suivants.",
      :en
        "After I've read `Clean Architecture` this book is an obvious following step, which is putting in place the same principles but at the code level instead of the architecture. One remark that was not developed enough but make me think about it, was the fact that variables / class / function names should tell a story. Those elements are more developed in some of the next books."},
   :clean-archi-desc
     {:fr
        "Ce livre m'a inspiré et redonné envie de faire du développement. Je trouve les règles détaillées et contraignantes, mais j'ai beaucoup aimé les observations. Par exemple, que le comportement et le fonctionnement doivent être distinguées, c'est-à-dire qu'un code qui fonctionne ne fait qu'une partie du travail, il doit être évolutif, lisible, ... Les règles énoncées montrent des leviers intéressant pour atteindre ces objectifs, quoiqu'un peu spécifique à la Programmation Orientée Objet.",
      :en
        "That book inspired me and made me develop again after some years of pause. They describe SOLID principles which are insightful even if I think that rules are too detailed and constraining, but I have appreciated their code observations. For instance, the behavior and functioning should be distinguished, and a code that is working is not enough, it should also be easy to modify, to extend, to read ... The rules detailed in the book are interesting levers to reach that objective, even if they are a little bit specific to Object Oriented Programming."}})

(def items
  {:clean-archi {:title "Clean Architecture",
                 :sub-title
                   "A Cratsman's guide to software structure and design"},
   :clean-code {:title "Clean Code",
                :sub-title "A Handbook of Agile Software Craftsmanship"},
   :ddd {:title "Domain-Driven Design",
         :sub-title "Tackling Complexity in the Heart of Software"},
   :clojure-programming {:title "Clojure programming",
                         :sub-title "Practical LISP for the java world"},
   :platform-revolution
     {:title "Platform revolution",
      :sub-title
        "How networked markets are transforming the economy and how to make them work for you"}})

(def tr (partial klang/tr dic))

(defn v-biblio
  [l selected opts-go-to opts-go-rel]
  (let [tr (partial klang/tr dic l)
        books (kvslider/defaulting* items
                                    tr
                                    klinks/image-link
                                    klinks/external-link
                                    klang/possible-langs)]
    [:<> [:h1.text (tr :biblio-title)] [:p.text (tr :biblio-intro)]
     (kvslider/subtitle-img-long-desc tr
                                      (get books l)
                                      selected
                                      opts-go-to
                                      opts-go-rel)]))
