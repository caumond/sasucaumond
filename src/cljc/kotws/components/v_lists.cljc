(ns kotws.components.v-lists "Component to list values.")

(defn one-per-row
  "List of elements to display, one per row.

  * `title` (optional) is displayed as the title of the list.
  * `items` is a map which values are:
      * `fa-icon` is a font awesome icon
      * `label` the name to add on the right of the icon
      * `href` address to point (applied to the rounding box)"
  ([items] (one-per-row nil items))
  ([title items]
   (-> [:div.w3-container (when (string? title) [:h4 [:b title]])]
       (concat (->> items
                    vals
                    (mapv (fn [{:keys [fa-icon label href], :as item}]
                            [:a
                             (cond-> {}
                               href (assoc :href
                                      (:url href) :class
                                      "w3-hover-opacity"))
                             [:div.w3-block.w3-left-align
                              {:class [(if href
                                         "w3-button w3-hover-opacity"
                                         "w3-padding w3-section-small")]}
                              [:i.fa.w3-margin-right
                               {:class (if fa-icon fa-icon "fa-circle")}]
                              label]]))))
       vec)))

(defn small-buttons
  "list items to display as small buttons all on the same row.

  * `title` (optional) is displayed as the title of the list.
  * `items` ordered list of maps (fa-icon label and href)."
  [title items]
  (-> [:div.w3-container (when (string? title) [:h4 [:b title]])]
      (concat (->> items
                   (mapv (fn [[_ {:keys [fa-icon label href], :as entry}]]
                           (when (seq entry)
                             [:a (when href {:href (:url href)})
                              [:div.w3-tooltip.w3-button
                               {:style {:overflow "visible"}}
                               [:p.fa
                                (cond-> {:class fa-icon}
                                  href (update :class
                                               #(str "w3-hover-opacity " %)))]
                               [:div.w3-text.w3-tag
                                {:style {:bottom "4em",
                                         :left "-1em",
                                         :position "absolute"}} label]]])))))
      vec))

(defn bullet
  "Simple bullet list

  * `items` is a map which values are:
      * `fa-icon` is a font awesome icon
      * `label` the name to add on the right of the icon
      * `href` address to point (applied to the rouding box)"
  [data]
  (-> (concat [:ul.w3-ul]
              (->> data
                   vals
                   (map (fn [{:keys [name href desc fa-icon],
                              :or {fa-icon "fa-circle"}}]
                          ^{:key name}
                          [:li.text [:i.fa.w3-margin-right {:class fa-icon}]
                           [:b.text
                            [:a.w3-margin-right
                             (when href {:href (:url href), :target "blank"})
                             name ":"]] desc]))))
      vec))
