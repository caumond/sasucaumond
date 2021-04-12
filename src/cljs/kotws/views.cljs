(ns kotws.views
  (:require [re-frame.core :as rf]
            [kotws.subs :as subs]
            [kotws.ml :as ml]
            [kotws.pages.v-home :refer [home-panel]]
            [kotws.pages.v-about :refer [about-panel]]
            [kotws.pages.v-biblio :refer [biblio-panel]]
            [kotws.pages.v-tech-stack :refer [tech-stack-panel]]
            [kotws.pages.v-resume :refer [resume-panel]]
            [kotws.pages.v-vision :refer [vision-panel]]
            [kotws.pages.footer :as footer]
            [kotws.pages.header :as header]
            [kotws.pages.overlay :as overlay]
            [kotws.pages.left-panel :as left-panel]
            [breaking-point.core :as bp]
            ))

(def tr (partial ml/tr
                 {:en {:non-existing-panel "Fatal error: the panel `%1` is not setup in views"}
                  :fr {:non-existing-panel "Erreur fatale: le panel `%1` n'est pas paramétré dans les vues"}}))

(defn panel []
  (let [small-monitor? (rf/subscribe [::bp/small-screen?])
        show-left-panel? (rf/subscribe [::subs/show-left-panel])
        display-menu? (or (not @small-monitor?)
                          (and @small-monitor? @show-left-panel?))]
    [:<>
     [left-panel/panel]
     [overlay/panel]
     [:div#main-panel {:style (if display-menu? {} {:margin-top "0px" :margin-left "32px" :margin-bottom "32px"})}
      [header/header]
      [:div.content
       (let [active-panel (rf/subscribe [::subs/active-panel])]
         (case @active-panel
           :home-panel               [home-panel]
           :about-panel              [about-panel]
           :tech-stack-panel         [tech-stack-panel]
           :resume-panel             [resume-panel]
           :vision-panel             [vision-panel]
           :biblio-panel             [biblio-panel]
           [:p (tr [:non-existing-panel])]
           ))]

      [footer/footer]]
     ]))
