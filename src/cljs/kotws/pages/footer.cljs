(ns kotws.pages.footer)

(defn footer []
  [:footer {:class "w3-container w3-padding-32 w3-dark-grey"}
   [:p
    "Copyright "
    [:span {:dangerouslySetInnerHTML {:__html "&copy;"}}]
    " 2020 Caumond - All rights reserved"]
   ])
