(ns kotws.components.table "Display elements of the table")

(defn simple
  "Simple stripped and bordered table."
  [& data]
  (-> [:table.w3-table.w3-striped.w3-bordered]
      (concat (->> data
                   (mapv (fn [[f s]] [:tr [:td [:p f]] [:td [:p.text s]]]))))
      vec))
