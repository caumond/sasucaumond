(ns kotws.app-view
  "Changing view depending on the menu clicked for instance."
  (:require [re-frame.core :as rf]
            [kotws.page-place-holder :as kws-page-place-holder]
            [kotws.subs :as subs]
            [kotws.app-view.c-footer :refer [c-footer]]
            [kotws.app-view.c-header :refer [c-header]]
            [kotws.app-view.c-left :refer [c-left]]))

(defn c-header-el [] [:<> [c-header]])

(defn c-footer-el [] [:<> [c-footer]])

(defn c-panel-el
  []
  (let [active-panel @(rf/subscribe [::subs/active-panel])]
    [:<>
     [:div.w3-row-padding [:div.w3-quarter.left-menu [:div.w3-card [c-left]]]
      [:div.w3-threequarter.printable-content
       [:div.w3-card.w3-container
        (kws-page-place-holder/page active-panel)]]]]))
