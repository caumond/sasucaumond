(ns kotws.components.v-lists
  "Component to list values."
  (:require [kotws.components.items :as kcitems]))

(defn defaulting
  "Add default values for `href` and the `label`"
  [items tr href-dic langs]
  (-> items
      kcitems/default-name
      (kcitems/default-with-kws [[:href :name ""] [:label :name "-label"]])
      (kcitems/apply-dic [:href] href-dic)
      (kcitems/translate [:label] langs tr)))

(defn one-per-row
  "List of elements to display, one per row.

  * `title` (optional) is displayed as the title of the list.
  * `items` is a map which values are:
      * `fa-icon` is a font awesome icon
      * `label` the name to add on the right of the icon
      * `href` address to point (applied to the rounding box)"
  ([items] (one-per-row nil items))
  ([title items]
   (reduce (fn [hiccup {:keys [fa-icon label href], :as item}]
             (conj hiccup
                   (when (seq item)
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
                        {:class (if fa-icon fa-icon "fa-circle")}] label]])))
     [:div.w3-container (when (string? title) [:h4 [:b title]])]
     (vals items))))

(defn small-buttons
  "list items to display as small buttons all on the same row.

  * `title` (optional) is displayed as the title of the list.
  * `items` ordered list of maps (fa-icon label and href)."
  [title items]
  (reduce (fn [hiccup {:keys [fa-icon href label], :as item}]
            (conj hiccup
                  (when (seq item)
                    [:a
                     (cond-> {}
                       href (assoc :href
                              (:url href) :class
                              "w3-hover-opacity"))
                     [:div.w3-tooltip.w3-button {:style {:overflow "visible"}}
                      [:p.fa
                       (cond-> {:class fa-icon}
                         href (update :class #(str "w3-hover-opacity " %)))]
                      [:div.w3-text.w3-tag
                       {:style
                          {:bottom "4em", :left "-1em", :position "absolute"}}
                       label]]])))
    [:div.w3-container (when (string? title) [:h4 [:b title]])]
    (vals items)))

