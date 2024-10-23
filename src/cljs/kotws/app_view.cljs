(ns kotws.app-view
  "Changing view depending on the menu clicked for instance."
  (:require [re-frame.core :as rf]
            [kotws.page-place-holder :as kws-page-place-holder]
            [kotws.subs :as subs]
            [kotws.app-view.v-footer :refer [v-footer]]
            [kotws.app-view.v-header :refer [v-header]]
            [kotws.app-view.v-left-panel :refer [v-left-panel]]))

(defn c-header-el [] [:<> [v-header]])

(defn c-footer-el [] [:<> [v-footer]])

(defn c-panel-el
  []
  (let [active-panel @(rf/subscribe [::subs/active-panel])]
    [:<>
     [:div.w3-row-padding [:div.w3-quarter [:div.w3-card [v-left-panel]]]
      [:div.w3-threequarter
       [:div.w3-card.w3-container
        (kws-page-place-holder/page active-panel)]]]]))
