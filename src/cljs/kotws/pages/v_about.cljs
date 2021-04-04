(ns kotws.pages.v-about
  (:require [kotws.ml :as ml]))

(def tr (partial ml/tr
           {:en {
                 :about-title "About"
                 :about-intro "This website gathers is my online resume, gathering my digital contributions."
                 :credit      {:title       "Inspiration"
                               :intro       "The followings inspired me - even gave some codes"
                               :aslam       {:text "@Aslam timeline code in the \"code pen\" website"}
                               :w3-template {:text "w3 schools for its templates w3.css"}
                               :my-wife     {:text "my wife for her talented advices in webdesign"}}
                 }
            :fr {
                 :about-title "A propos"
                 :about-intro "Ce site rassemble présente mon cv de manière détaillée, et regroupe mes contributions digitales"
                 :credit      {:title       "Sources d'inspiration"
                               :intro       "Les éléments suivants m'ont inspirés voir alimentés:"
                               :aslam       {:text "La ligne de temps fournie par @Aslam sur le site de \"code pen\""}
                               :w3-template {:text "w3 schools pour ces templates w3.css"}
                               :my-wife     {:text "Ma femme  pour ses conseils talentueux en webdesign"}
                               }

                 }}))

(def inspiration-sources
  [{:text      :credit.aslam/text
    :hyperlink "https://codepen.io/hunzaboy/pen/qBWRBXw"}
   {:text      :credit.w3-template/text
    :hyperlink "https://www.w3schools.com/w3css/tryw3css_templates_portfolio.htm"}
   {:text :credit.my-wife/text}]
  )

(defn about-panel []
  [:<>
   [:h1 (tr [:about-title])]
   [:p (tr [:about-intro])]

   [:div
    [:h1 (tr [:credit/title])]
    [:p (tr [:credit/intro])]
    [:ul.w3-ul
     (doall (for [credit-item inspiration-sources]
              ^{:key credit-item}[:li (if-let [credit-item-hyperlink (:hyperlink credit-item)]
                                        [:a.w3-margin {:href credit-item-hyperlink :target "blank"} [:i.fa.fa-search]]
                                        [:i.w3-margin.fa.fa-exclamation])
                                  (tr [(:text credit-item)])
                                  ]
              ))]
    ]]
  )
