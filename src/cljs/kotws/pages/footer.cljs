(ns kotws.pages.footer)

(defn footer []
  [:footer 
   [:p
    "Copyright " [:span {:dangerouslySetInnerHTML {:__html "&copy;"}}] " 2020 Caumond - All rights reserved"]
   ])
