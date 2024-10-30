(ns kotws.app-view.v-header
  (:require [kotws.lang :as klang]
            [kotws.components.v-lang :as kvlang]))

(defn v-header
  "Display the header reused for all pages."
  [current-language switch-lang]
  [:<> [kvlang/lang-bar klang/possible-langs current-language switch-lang]])
