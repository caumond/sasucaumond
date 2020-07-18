(ns kotws.pages.footer
  (:require [re-com.core :as re-com]))


(defn footer []
  [re-com/box
   :size "auto"
   :child [re-com/label :class "copyright" :label "Copyright 2020 Caumond - All Rights Reserved."]])
