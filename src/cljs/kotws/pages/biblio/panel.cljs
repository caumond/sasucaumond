(ns kotws.pages.biblio.panel
  (:require [kotws.multi-language :as ml]))

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

(defonce slideIndex (atom 1))

(defn showdivs [n]
  (let [biblio-items (. js/document getElementsByClassName "biblio-item")]
    (.log js/console "start")
    (for [biblio-item biblio-items]
      (set!
       (->  biblio-item
            (.-style)
            (.-display)
            )
       "none")
      )
    (.log js/console (get biblio-items 1))
    (set!
     (->  (get biblio-items n)
          (.-style)
          (.-display)
          )
     "block")
    )
  )

(defn plusdiv [c]
  (swap! slideIndex (partial + c))
  (showdivs @slideIndex)
  )

(defn setndiv [c]
  (reset! slideIndex c)
  (plusdiv c))

(defn biblio-panel []
  [:div
   [:h1 (ml/get-msg :biblio-title)]
   [:p (ml/get-msg :biblio-intro)]

   [:div {:class "w3-content"}
    (for [book books]
      [:div {:class "biblio-item"}
       [:h2 (:name book)]
       [:img {:src (:img book)}]
       [:h4 (ml/get-msg :resume-title)]
       [:p (:description book)]
       ]
      )]

   [:div {:class "w3-center"}
    [:div {:class "w3-section"}
     [:button {:class "w3-button w3-light-grey" :on-click #(plusdiv -1)} "< Prev"]
     [:button {:class "w3-button w3-light-grey" :on-click #(plusdiv 1)} "> Next"]
     ]
    (for [i (take (count books) (iterate inc 1))]
      [:button {:class "w3-button demo" :on-click #(setndiv i)} i ])
    ]]
  )
