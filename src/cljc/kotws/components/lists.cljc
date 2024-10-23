(ns kotws.components.lists "Component to list values.")

(defn one-per-row
  "List of elements to display, one per row.

  * `title` (optional) is displayed as the title of the list.
  * `items` ordered list of map with keys `icon`, `label` and `href`."
  ([items] (one-per-row nil items))
  ([title items]
   (-> [:div.w3-container (when (string? title) [:h4 [:b title]])]
       (concat (->> items
                    (mapv (fn [{:keys [icon label href]}]
                            [:a
                             (cond-> {}
                               href (assoc :href
                                      href :class
                                      "w3-hover-opacity"))
                             [:div.w3-block.w3-left-align
                              {:class [(if href
                                         "w3-button w3-hover-opacity"
                                         " w3-section")]}
                              [:i.fa.w3-margin-right {:class icon}] label]]))))
       vec)))

(defn small-buttons
  "list items to display as small buttons all on the same row.

  * `title` (optional) is displayed as the title of the list.
  * `items` ordered list of maps (icon label and href)."
  [title items]
  (-> [:div.w3-container (when (string? title) [:h4 [:b title]])]
      (concat (->> items
                   (mapv (fn [{:keys [icon label href], :as entry}]
                           (when (seq entry)
                             [:a (when href {:href href})
                              [:div.w3-tooltip.w3-button.w3-mobile
                               {:style {:overflow "visible"}}
                               [:p.fa
                                (cond-> {:class icon}
                                  href (update :class
                                               #(str "w3-hover-opacity " %)))]
                               [:div.w3-text.w3-tag
                                {:style {:bottom "4em",
                                         :left "-1em",
                                         :position "absolute"}} label]]])))))
      vec))

(defn bullet
  "Simple bullet list

  * `data` should be a list of pair `name`, `href` and `desc`."
  [data]
  (-> (concat [:ul.w3-ul]
              (->> data
                   (map (fn [{:keys [name href desc]}]
                          ^{:key name}
                          [:li [:i.fa.fa-circle.w3-margin-right]
                           [:b
                            [:a.w3-margin-right
                             (when href {:href href, :target "blank"}) name
                             ":"]] desc]))))
      vec))
