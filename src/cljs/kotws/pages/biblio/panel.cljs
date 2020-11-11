(ns kotws.pages.biblio.panel
  (:require [re-com.core :as re-com]
            [kotws.multi-language :as ml]))

(def books
  [
   {:img "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/1323/9780132350884.jpg"
    :name "Clean Code"
    :description "How to clean code. This book explains the S.O.L.I.D. principles, how to format code, and how it is important to look at code as a writer look to a book. There's a language."
    :sumup "lorem ipsum"}
   {:img "https://images.fr.shopping.rakuten.com/photo/1141133651.jpg"
    :name "Clean Architecture"
    :description "How to design apps"
    :sumup "lorem ipsum"}
   {:img "https://m.media-amazon.com/images/I/41odjJlPgHL.jpg"
    :name "Refactoring"
    :description "How to refactor apps"
    :sumup "lorem ipsum"}
   {:img "https://images-na.ssl-images-amazon.com/images/I/71PfJRu9+lL.jpg"
    :name "The joy of clojure"
    :description "Good introduction to clojure, numerous recipes, good practises and language philosophy descriptions."
    :sumup ""}
   {:img "https://images-na.ssl-images-amazon.com/images/I/41sY2b6MKiL._SX381_BO1,204,203,200_.jpg"
    :name "Clojure programming"
    :description ""
    :sumup ""}
   {:img "https://images-na.ssl-images-amazon.com/images/I/61vpyYrpIoL.jpg"
    :name "Platforms"
    :description ""
    :sumup ""}
   ])


(defn biblio-panel []
  [re-com/v-box
   :children [
              [re-com/title :level :level1 :label (ml/get-msg :biblio-title)]
              [re-com/p (ml/get-msg :biblio-intro)]

              [re-com/v-box :children (for [book books]
                                        [re-com/border
                                         :class "biblio-item"
                                         :child [re-com/v-box
                                                 :children [ [:h2 (:name book)]
                                                            [:img#book-image {:src (:img book)}]
                                                            [:div.resume
                                                             [:h4 (ml/get-msg :resume-title)]
                                                             [re-com/p (:description book)]
                                                             ]
                                                            ]
                                                 ]]
                                        )]
              ]]
  )
