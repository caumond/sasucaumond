(ns kotws.components.v-table "Display elements of the table")

(defn simple
  "Simple stripped and bordered table for elements in `name` `cells`."
  [items]
  [:table.w3-table.w3-striped.w3-bordered
   (->> items
        (reduce (fn [hiccup-item [_ {:keys [name cells]}]]
                  (conj hiccup-item
                        [:tr [:td [:p.text name]]
                         [:td [:p.text (first cells)]]]))
          [:tbody]))])
