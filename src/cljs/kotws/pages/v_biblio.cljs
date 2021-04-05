(ns kotws.pages.v-biblio
  (:require [kotws.ml :as ml]
            [re-frame.core :as rf]
            [kotws.events :as events]
            [kotws.subs :as subs]
            ))

(def books [ {:title        "Clean Architecture"
              :sub-title    "A Cratsman's guide to software structure and design"
              :img         "images/pages/biblio/Clean architecture.jpg"
              :ml {:fr {:desc "Ce livre m'a inspiré et redonné envie de faire du développement. J'ai aimé voir énoncé les deux qualités d'un code: le comportement et l'architecture. Pas seulement l'auteur illustre clairement ces deux qualités, mais il montre aussi les moyens de les atteindre: les principes S.O.L.I.D. Ces principes sont aussi brillament énoncés et illustrés."}
                   :en {:desc "I started developping again more intensely after I read that book. It states that code has two qualities: behavior and architecture and I love it. Not only the author illustrates clearly that two qualities but also a mean to achieve them: the S.O.L.I.D. principles, themselves well explained and illustrated with simple examples."}}}

            {:title "Clean Code"
             :sub-title "A Handbook of Agile Software Craftsmanship"
             :img "images/pages/biblio/Clean code.jpg"
             :ml {:fr {:desc  "Après avoir lu `clean architecture`, ce livre explique comment mettre en oeuvre les mêmes principes mais au niveau de la programmation elle-même. Un aspect évoqué dans ce livre quoique peu développé m'a frappé: le nom des variables n'est pas simplement un élément technique pour le compilateur, il doit aussi raconter une histoire. Ces éléments seront plus développés dans les livres suivants."}
                  :en {:desc  "After the clean architecture, the clean code is explaining how to propagate the same principles (i.e. the S.O.L.I.D. principles) in the next level of details. One thing stroke me the first time I read: the name of the variables are not only a technical id, necessary for the compiler to distinguish variables but it should tell a story. This ring a bell to me, a bell the next books will help me to explore."}
                   }}

            {:title          "Domain-Driven Design"
             :sub-title      "Tackling Complexity in the Heart of Software"
             :img            "images/pages/biblio/DDD.jpg"
             :ml  {:fr {:desc "Une référence dans le monde du DDD, ce livre est plein de recettes et d'exemples pratiques. L'idée abordée dans clean code à travers le nommage des variables passe à un niveau supérieur. Ce livre énonce un aspect sociologique que j'ai ressenti dans l'industrie: Une application est un microcosme, avec son vocabulaire. Et bien sûr des éléments méthodologiques et des outils pour gérer la complexité."
                        :detailed-desc "Dans l'industrie, j'ai ressenti deux choses que le DDD vient tacler. D'abord une application n'ést pas qu'un objet technique, mais aussi social: celui des ingénieurs qui conçoivent les processus, ceux des analystes qui conçoivent l'application, ceux des développeurs qui la font, du support et des utilisateurs qui travailleront avec l'application pendant des dizaines d'années. Dans les expériences que j'ai vécu, chacun des groupes précédemment cités ajoute leur couche de complexité en créant son propre vocabulaire, et la conception qui va avec. De plus, il ne faut pas imaginer cette diversité à un instant, mais dans le temps, avec des groupes de personnes qui évoluent dans le temps, qui ont même tendance à se démarquer de leur propre prédécesseur. Le DDD énonce ceci, et explique le principe du language ubiquite. Je ne crois pas que la mesure de ce principe ait été prise dans l'industrie, et surtout du coût que représente sa non application."}
                   :en {:desc "A reference on the DDD method, this book is full of recipes and practical examples. The idea behind variables naming in clean code is going to next level here. This book raise a sociological aspect I felt in the industry: An application is a microcosm, with vocabularies. And of course, the book is giving methodology and tools to tackle that complexity"
                        :detailed-desc "In the industry, I discovered two phenomenons that DDD is dealing with. First, an application is not only a technical object but also social object: engineers who design process, analysts who design apps, developers who code, support and users who will work with the app for decades. In my experiences, each group add some complexity, has its own vocabulary, and the design coming with it. The worst is that picture is evolving with time, and each group replacing its predecessor introduce also a shift in the vocabulary. The DDD states that in details, and tell us about the ubiquitous language. I don't believe industry realize how much this principle is important, neither the cost spent because it is, most of the time, not."}}}

            {:title        "Clojure programming"
             :img         "images/pages/biblio/Clojure programming.jpg"
             :ml {:fr {:desc "Ce livre est un livre de chevet, après avoir appris les bases de clojure, il permet de bien appréhender les détails, l'esprit du language. La première lecture ne m'a pas suffit, il faut y revenir régulièrement, mais je ne pense que cela vienne du livre."}
                  :en {:desc "That book is a book to be on your bedside. After have learnt some basics of clojure, the book allow to understand details, the idiomatic way to use the language. My first reading was not enough, I had to re-open it regularly, which is not due to the book."}}}

            { :title        "Platform revolution"
             :sub-title "How networked markets are transforming the economy and how to make them work for you"
             :img         "https://images-na.ssl-images-amazon.com/images/I/61vpyYrpIoL.jpg"
             :ml {:fr {:desc "Même si je n'ai pas construit ma plateforme grace à ce livre, il m'a au moins permis de comprendre ce qu'étaient les plateformes. En particulier, j'ai mieux compris l'histoire de Microsoft, qui était un mystère pour moi auparavant."}
                  :en {:desc "If that book dead not permit me to build my own platform, it has, at least, allow me to better understand what is going on with platforms. Especially I've been able to understand the Microsoft effect, which was a mystery to me before that."}}}
            ])

(def tr (partial ml/tr  {:en {:desc-title        "Sum-up"
                              :desc-detailed-title "Content"
                              :biblio-title        "Bibliography"
                              :biblio-intro        "These are some noticeable books I took pleasure to read"}
                         :fr {:desc-title        "Synthèse"
                              :desc-detailed-title "Contenu"
                              :biblio-title        "Bibliography"
                              :biblio-intro        "Je vous souhaite autant de plaisir que moi à lire ces ouvrages"}
                         }))

(defn tr-book[book & args] (apply ml/tr (:ml book) args))

(defn biblio-panel []
  (let [slide-idx (rf/subscribe [::subs/slide-idx])]
    [:<>
     [:h1 (tr [:biblio-title])]
     [:p (tr [:biblio-intro])]

     (let [book (nth books @slide-idx)
           sub-title (:sub-title book)]
       [:div.biblio-item
        [:h2 (:title book)
         (when-not (nil? sub-title) " :")]
        (when-not (nil? sub-title)
          [:h3 sub-title])
        [:img {:src (:img book)}]
        [:div.page-menu
         [:i.button.fa.fa-angle-left {:on-click #(rf/dispatch (if (= 0 @slide-idx)
                                             [::events/change-slide-idx :abs (dec (count books))]
                                             [::events/change-slide-idx :rel -1]))}]
         (doall
          (for [i (take (count books) (iterate inc 1))]
            ^{:key (str "page count-" i)} [:button {:class    (if (= (dec i) @slide-idx)
                                                                "selected-button"
                                                                "unselected-button")
                                                    :on-click #(rf/dispatch [::events/change-slide-idx :abs (- i 1)])} i ]))

         [:i.button.fa.fa-angle-right {:on-click #(rf/dispatch (if (= (dec (count books)) @slide-idx)
                                                                 [::events/change-slide-idx :abs 0]
                                                                 [::events/change-slide-idx :rel 1]
                                                                 ))}]]
        [:p#desc [:span.p-title (tr [:desc-title])] ": " (tr-book book [:desc])]

        (when-not (nil? (get-in book [:ml :fr :detailed-desc]))
          [:p#detailed-desc
           [:span.p-title (tr [:desc-detailed-title])] ": "
           (tr-book book [:detailed-desc])]
          )
        ]
       )]))
