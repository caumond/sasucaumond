(ns kotws.components.table "Display elements of the table")

(defn simple
  "Simple stripped and bordered table for elements in `name` `cells`."
  [items]
  (->> items
       (reduce (fn [hiccup-item {:keys [name cells]}]
                 (conj hiccup-item
                       [:tr [:td [:p name]] [:td [:p.text (first cells)]]]))
         [:table.w3-table.w3-striped.w3-bordered])))

