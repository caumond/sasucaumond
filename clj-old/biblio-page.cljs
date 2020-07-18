(ns kotws.biblio)

(def books
  [
   {:img "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/1323/9780132350884.jpg"
    :name "Clean Code"
    :description "How to clean code"
    :sumup "lorem ipsum"}
   {:img "https://images.fr.shopping.rakuten.com/photo/1141133651.jpg"
    :name "Clean Architecture"
    :description "How to design apps"
    :sumup "lorem ipsum"}
   {:img "https://m.media-amazon.com/images/I/41odjJlPgHL.jpg"
    :name "Refactoring"
    :description "How to refactor apps"
    :sumup "lorem ipsum"}
   {:img ""
    :name "The joy of clojure"
    :description ""
    :sumup ""}
   {:img ""
    :name "Clojure programming"
    :description ""
    :sumup ""}
   {:img ""
    :name "Platforms"
    :description ""
    :sumup ""}
   ])


(defn biblio-page []
  [:div.main 
   [:p "These are the books I took pleasure to read:"]
   (for [book books]
     [:div 
      [:h2 (:name book)]
      [:div.book-image 
       [:img {:src (:img book)
              :width "250em"}]]]
     )]
  )
