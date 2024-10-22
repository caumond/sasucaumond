(ns kotws.app-view.header
  "Header of all pages."
  (:require [re-frame.core :as rf]
            [kotws.subs :as subs]
            [kotws.events :as events]))

(defn v-header
  "Display the header reused for all pages.

  * when `display-menu-bns?` = `true`, "
  [language]
  [:<>
   [:div.w3-bar
    [:a.w3-right
     {:on-click #(rf/dispatch [::events/change-language :fr]),
      :class (when (= :fr language) "secondary-bg secondary-text")}
     [:button.w3-button "fr"]]
    [:a.w3-right
     {:on-click #(rf/dispatch [::events/change-language :en]),
      :class (when (= :en language) "secondary-bg secondary-text")}
     [:button.w3-button "en"]]]])

(defn header
  "Component displaying the header."
  []
  (v-header @(rf/subscribe [::subs/language])))
