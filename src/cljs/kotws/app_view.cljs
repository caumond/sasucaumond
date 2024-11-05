(ns kotws.app-view
  "Changing view depending on the menu clicked for instance."
  (:require [re-frame.core :as rf]
            [kotws.page-place-holder :as kws-page-place-holder]
            [kotws.subs :as subs]
            [kotws.components.v-space :as kvspace]
            [kotws.app-view.c-footer :refer [c-footer]]
            [kotws.app-view.c-header :refer [c-header]]
            [kotws.app-view.c-left :refer [c-left]]))

(defn c-panel-el
  []
  (let [active-panel @(rf/subscribe [::subs/active-panel])]
    [:<> [c-header "7vh"]
     [:div.w3-row {:style {:max-width "1600px", :min-height "76vh"}}
      [:div.w3-container.w3-quarter.left-menu [:div.w3-card [c-left]]]
      [:div.w3-col.w3-hide-small.w3-hide-medium {:style {:width "4vw"}}
       [:p " "]]
      [:div.w3-rest.printable-content.w3-card.w3-container
       (kws-page-place-holder/page active-panel) [kvspace/vertical-spacing]]]
     [kvspace/vh-spacing] [c-footer "15vh"]]))
