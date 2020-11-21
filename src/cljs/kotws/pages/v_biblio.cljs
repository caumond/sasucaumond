(ns kotws.pages.v-biblio
  (:require [kotws.multi-language :as ml]
            [re-frame.core :as rf]
            [kotws.events :as events]
            [kotws.subs :as subs]
            ))

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
  (let [slide-idx (rf/subscribe [::subs/slide-idx])]
    [:div
     [:h1 (ml/get-msg :biblio-title)]
     [:p (ml/get-msg :biblio-intro)]

     (let [book (nth books @slide-idx)]
       [:div {:class "biblio-item w3-content w3-center"}
        [:h2 (:name book)]
        [:img {:src (:img book)}]
        [:h4 (ml/get-msg :resume-title)]
        [:p (:description book)]
        ]
       )

     [:div {:class "w3-center"}
      [:div {:class "w3-section"}

       (if (= 0 @slide-idx)
         [:span {:class "w3-button w3-light-grey"
                 :on-click #(rf/dispatch [::events/change-slide-idx :abs (dec (count books))])} "< Prev"]
         [:button {:class "w3-button w3-light-grey "
                   :on-click #(rf/dispatch [::events/change-slide-idx :rel -1])} "< Prev"]
         )
       (if (= (dec (count books))
              @slide-idx)
         [:span {:class "w3-button w3-light-grey"
                 :on-click #(rf/dispatch [::events/change-slide-idx :abs 0])} "Next >"]
         [:button {:class "w3-button w3-light-grey"
                   :on-click #(rf/dispatch [::events/change-slide-idx :rel 1])} "Next >"]
         )
       ]

      (for [i (take (count books) (iterate inc 1))]
        ^{:key (str "page count-" i)} [:button {:class (str "w3-button demo"
                                                            (if (= (dec i) @slide-idx) " w3-red"))
                            :on-click #(rf/dispatch [::events/change-slide-idx :abs (- i 1)])} i ])
      ]])
  )
