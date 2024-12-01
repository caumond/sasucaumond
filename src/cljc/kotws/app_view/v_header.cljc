(ns kotws.app-view.v-header
  "Display the header reused for all pages."
  (:require [kotws.lang :as klang]
            [kotws.components.v-langs :as kvlangs]))

(defn v-header
  [current-language switch-lang size]
  [:header.w3-bar.w3-row {:style {:height size, :min-height "3em"}}
   [kvlangs/lang-bar klang/possible-langs current-language switch-lang]])
