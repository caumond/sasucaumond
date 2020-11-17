(ns kotws.pages.biblio.panel
  (:require [kotws.multi-language :as ml]
            [re-frame.core :as rf])
  )

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

(defn limit [biblio-items]
  (reset! slideIndex
          (max 0 (min (- (count biblio-items) 1)
                      @slideIndex))))

(defn showdivs []
  (let [biblio-items (array-seq
                      (. js/document getElementsByClassName "biblio-item"))]
    (limit biblio-items)
    (doseq [biblio-item biblio-items]
      (set!
       (->  biblio-item
            (.-style)
            (.-display)
            )
       "none")
      )

    (set!
     (->  (nth biblio-items @slideIndex)
          (.-style)
          (.-display)
          )
     "block")
    )
  )

(defn plusdiv [c]
  (swap! slideIndex (partial + c))
  (showdivs)
  )

(defn setndiv [c]
  (reset! slideIndex c)
  (showdivs))

(defn biblio-panel []
  [:div
   [:h1 (ml/get-msg :biblio-title)]
   [:p (ml/get-msg :biblio-intro)]

   [:div {:class "w3-content w3-center"}
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
      [:button {:class "w3-button demo" :on-click #(setndiv (- i 1))} i ])
    ]]
  )
