(ns kotws.components.v-headered-list
  "A long lasting list of elements, each separated with a hr, has its icon, short and long text."
  (:require [kotws.components.v-labelled-image :as kvlabelled-image]))

(defn header
  "Show the header of the items.

  Is a collection maps, each has `name` and `img-url` keywords."
  [items]
  [:div.w3-row.w3-center
   (-> [:span]
       (concat (->> items
                    (mapv (fn [{:keys [name img-url]}]
                            [:div.w3-container.w3-cell
                             [kvlabelled-image/labelled-image img-url name :tiny
                              nil nil]]))))
       vec)])

(defn detailed-list
  "Show all elements of items.

  Is a collection of maps, each has `name` `img-url` `description` `long-desc` `href`"
  [items]
  [:table.w3-table.w3-striped.w3-bordered
   (->> items
        (reduce (fn [hiccup-item
                     {:keys [name img-url description long-desc href]}]
                  (conj hiccup-item
                        [:tr
                         (when img-url
                           [:td.w3-centered
                            [kvlabelled-image/labelled-image img-url name
                             :middle nil nil]])
                         [:td [:a {:href href} [:h1.text name]]
                          [:p.text description]
                          (when long-desc [:p.text long-desc])]]))
          [:tbody]))])
