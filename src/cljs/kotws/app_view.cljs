(ns kotws.app-view
  "Changing view depending on the menu clicked for instance."
  (:require [re-frame.core :as rf]
            [kotws.page-place-holder :as kws-page-place-holder]
            [kotws.subs :as subs]
            [kotws.app-view.footer :as footer]
            [kotws.app-view.header :as header]
            [kotws.app-view.left-panel :as left-panel]))

(defn v-header [] [:<> [header/header]])

(defn header-el [] (v-header))

(defn v-footer [] [:<> [footer/footer]])

(defn footer-el [] (v-footer))

(defn v-panel
  [active-panel]
  [:<>
   [:div.w3-row-padding [:div.w3-quarter [:div.w3-card-4 [left-panel/panel]]]
    [:div.w3-threequarter
     [:div.w3-card-4.w3-container (kws-page-place-holder/page active-panel)]]]])

(defn panel-el
  []
  (let [active-panel @(rf/subscribe [::subs/active-panel])]
    (v-panel active-panel)))
