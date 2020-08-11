(ns kotws.pages.footer
  (:require [re-com.core :as re-com]))


(defn footer []
  [re-com/h-box
   :size "auto"
   :children [[re-com/label
               :label "Copyright "]
              [:div {:dangerouslySetInnerHTML {:__html "&copy;"}}]
              [re-com/label
               :label " 2020 Caumond - All Rights Reserved."]
              ]])
