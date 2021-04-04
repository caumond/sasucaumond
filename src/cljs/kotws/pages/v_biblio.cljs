(ns kotws.pages.v-biblio
  (:require [kotws.ml :as ml]
            [re-frame.core :as rf]
            [kotws.events :as events]
            [kotws.subs :as subs]
            ))

(def books [
            {:img         "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/1323/9780132350884.jpg"
             :name        "Clean Code"
             :description :clean-code/desc
             :sumup       :clean-code/sumup}
            {:img            "images/pages/biblio/DDD.jpg"
             :name           "Domain-Driven Design: Tackling Complexity in the Heart of Software"
             :link           "https://www.dddcommunity.org/book/evans_2003/"
             :description    :ddd-evans/desc
             :biblio-details "#/biblio-details-ddd"}
            {:img         "https://images.fr.shopping.rakuten.com/photo/1141133651.jpg"
             :name        "Clean Architecture"
             :description :clean-architecture/desc}
            {:img         "https://m.media-amazon.com/images/I/41odjJlPgHL.jpg"
             :name        "Refactoring"
             :description :refactoring/desc}
            {:img         "https://images-na.ssl-images-amazon.com/images/I/41sY2b6MKiL._SX381_BO1,204,203,200_.jpg"
             :name        "Clojure programming"
             :description :clojure-programming/desc}
            {:img         "https://images-na.ssl-images-amazon.com/images/I/61vpyYrpIoL.jpg"
             :name        "Platforms"
             :description :platforms/desc}
            ])

(def tr (partial ml/tr  {:en {:resume-title        "Sum-up:"
                        :biblio-title        "Bibliography"
                        :biblio-intro        "These are some noticeable books I took pleasure to read:"
                        :next                "Next"
                        :prev                "Prev"
                        :platforms           {:desc  "What it is ? How it works ? How to build a platform ?"
                                              :sumup ""}
                        :clojure-programming {:desc  "Describing clojure in details"
                                              :sumup ""}
                        :clean-architecture  {:desc  "How to design apps"
                                              :sumup ""}
                        :ddd-evans           {:desc  "A reference on the DDD method, this book is full of recipes, practical examples. More than the method, the book offers the reason why: why the method, why we want to avoid that situation, ..."
                                              :sumup ""}
                        :clean-code          {:desc  "How to clean code. This book explains the S.O.L.I.D. principles, how to format code, and how it is important to look at code as a writer look to a book. There's a language."
                                              :sumup "Lorem ispum"}}
                   :fr {:resume-title        "Synthèse"
                        :biblio-title        "Bibliography"
                        :biblio-intro        "Je vous souhaite autant de plaisir que moi à lire ces ouvrages"
                        :platforms           {:desc  "What it is ? How it works ? How to build a platform ?"
                                              :sumup ""}
                        :clojure-programming {:desc  "Describing clojure in details"
                                              :sumup ""}
                        :clean-architecture  {:desc "Comment concevoir des apps"}
                        :ddd-evans           {:desc  "Une référence dans le monde du DDD, ce livre est plein de recette et d'exemples pratiques. Plus qu'une liste de méthode, ce livre explique pourquoi: le pourquoi de la méthode, pourquoi on souhaite éviter cette situation, ..."
                                              :sumup ""}
                        :clean-code          {:desc  "Comment nettoyer du code. Ce livre explique les principes S.O.L.I.D., le formattage du code. Ce qui m'a frappé dans ce livre c'est l'importance du mot language dans 'language de programmation'"
                                              :sumup "Lorem ispum"}
                        :next                "Suiv."
                        :prev                "Préc."}
                   }))

(defn biblio-panel []
  (let [slide-idx (rf/subscribe [::subs/slide-idx])]
    [:<>
     [:h1 (tr [:biblio-title])]
     [:p (tr [:biblio-intro])]

     (let [book (nth books @slide-idx)]
       [:div.biblio-item
        [:h2 (:name book)]
        [:a {:href (:biblio-details book)}[:img {:src (:img book)}]]
        [:div.page-menu
         [:i.button.fa.fa-angle-left {:on-click #(rf/dispatch (if (= 0 @slide-idx)
                                             [::events/change-slide-idx :abs (dec (count books))]
                                             [::events/change-slide-idx :rel -1]))}]
         [:div
          (doall
           (for [i (take (count books) (iterate inc 1))]
             ^{:key (str "page count-" i)} [:button {:class    (if (= (dec i) @slide-idx)
                                                                 "selected-button"
                                                                 "unselected-button")
                                                     :on-click #(rf/dispatch [::events/change-slide-idx :abs (- i 1)])} i ]))]

         [:i.button.fa.fa-angle-right {:on-click #(rf/dispatch (if (= (dec (count books)) @slide-idx)
                                                                 [::events/change-slide-idx :abs 0]
                                                                 [::events/change-slide-idx :rel 1]
                                                                 ))}]]
        [:h4 (tr [:resume-title])
         (when-not (nil? (:link book))
           [:a {:href (:link book)}[:i.fa.fa-shopping-cart]])]
        [:p (tr [(:description book)])]
        ]
       )]))
