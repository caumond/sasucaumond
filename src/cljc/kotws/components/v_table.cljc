(ns kotws.components.v-table
  "Display elements of the table"
  (:require [kotws.components.items :as kcitems]))

(defn defaulting
  [items tr langs]
  (-> items
      kcitems/default-name
      (kcitems/default-with-kws [[:label :name ""]])
      (kcitems/translate [:label] langs tr)))

(def defaulting* (memoize defaulting))

(defn simple
  "Simple stripped and bordered table for elements in `name` `cells`."
  [items]
  [:table.w3-table.w3-bordered
   (->> items
        (reduce (fn [hiccup-item [_ {:keys [label cells]}]]
                  (conj hiccup-item
                        [:tr [:td (when label [:p.text label])]
                         [:td [:p.text (first cells)]]]))
          [:tbody]))])
