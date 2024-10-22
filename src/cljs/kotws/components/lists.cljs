(ns kotws.components.lists
  "Component to list values."
  (:require [clojure.string :as str]))

(defn one-per-row
  "List of elements to display, one per row.

  * `title` (optional) is displayed as the title of the list.
  * `icon-labels` ordered list of pairs (icon, label and url)."
  [title icon-labels]
  (-> [:div.w3-container (when (string? title) [:h4 [:b title]])]
      (concat (->> icon-labels
                   (mapv (fn [[icon label url]]
                           [:a
                            (cond-> {}
                              url (assoc :href
                                    url :class
                                    "w3-hover-opacity"))
                            [:div.w3-block.w3-left-align
                             {:class (str/join " "
                                               [(if url
                                                  "w3-button w3-hover-opacity"
                                                  " w3-section")])}
                             [:i.fa.w3-margin-right {:class icon}] label]]))))
      vec))

(defn small-buttons
  "List icon-labels to display, as small buttons all on the same row.

  * `title` (optional) is displayed as the title of the list.
  * `icon-labels` ordered list of pairs (icon, label and url)."
  [title icon-labels]
  (-> [:div.w3-container (when (string? title) [:h4 [:b title]])]
      (concat (->> icon-labels
                   (mapv (fn [[icon label url :as entry]]
                           (when (seq entry)
                             [:a (when url {:href url})
                              [:p.w3-button.w3-mobile
                               (when url {:class "w3-hover-opacity"})
                               [:i.fa {:class icon}] label]])))))
      vec))

(defn bullet
  "Simple bullet list

  * `data` should be a list of pair `name` and `url`."
  [data]
  (-> (concat [:ul.w3-ul]
              (->> data
                   (map (fn [{:keys [name url description]}]
                          ^{:key name}
                          [:li [:i.fa.fa-circle.w3-margin-right]
                           [:b
                            [:a.w3-margin-right
                             (when url {:href url, :target "blank"}) name ":"]]
                           description]))))
      vec))
