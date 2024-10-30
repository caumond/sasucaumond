(ns kotws.components.v-headered-list
  "A long lasting list of elements, each separated with a hr, has its icon, short and long text."
  (:require [kotws.components.v-labelled-image :as kvlabelled-image]
            [kotws.components.sizes :as ksizes]))

(defn header
  "Show the header of the items.

  Is a collection maps, each has `name` and `img-url` keywords."
  [items]
  [:div.w3-row.w3-center
   (-> [:span]
       (concat (->> items
                    (mapv (fn [[_ {:keys [name img-url href]}]]
                            [:div.w3-container.w3-cell.w3-mobile
                             [kvlabelled-image/labelled-image img-url href name
                              :tiny]]))))
       vec)])

(defn detailed-list
  "List elements of `items`

  * Start with the image of `img-url` (on top on small screen, on left on medium and wide screens)
  * The `label` as a title
  * Then a small `desc` highlighted
  * And a `long-desc`

  All that box is linked into `href` link."
  [items]
  (let [image-width-kw :medium
        actual-size (ksizes/predefined-size image-width-kw)]
    [:table.w3-table
     (->>
       items
       (reduce (fn [hiccup-item [_ {:keys [label img-url desc long-desc href]}]]
                 (conj hiccup-item
                       [:tr
                        [:td.w3-centered.w3-hide-small.w3-hide-medium
                         {:style {:max-width actual-size, :width actual-size}}
                         (when img-url
                           [kvlabelled-image/labelled-image img-url href ""
                            image-width-kw])] [:td]
                        [:td [:a {:href (:url href)} [:h1.text label]]
                         [:div.w3-centered.w3-hide-large
                          {:style {:max-width actual-size, :width actual-size}}
                          (when img-url
                            [kvlabelled-image/labelled-image img-url href ""
                             image-width-kw])]
                         [:p.w3-panel.w3-leftbar.text.light-bg desc]
                         (when long-desc [:p.text long-desc])]]))
         [:tbody]))]))
