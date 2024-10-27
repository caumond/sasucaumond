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
                    (mapv (fn [{:keys [name img-url href tag]}]
                            [:div.w3-container.w3-cell
                             [kvlabelled-image/labelled-image tag img-url name
                              :tiny nil href]]))))
       vec)])

(defn detailed-list
  "Show all elements of items.

  Is a collection of maps, each has `name` `img-url` `desc` `long-desc` `href`"
  [items]
  (let [image-width-kw :medium
        actual-size (ksizes/predefined-size image-width-kw)]
    [:table.w3-table.w3-striped
     (->>
       items
       (reduce (fn [hiccup-item {:keys [tag name img-url desc long-desc href]}]
                 (conj hiccup-item
                       [:tr
                        [:td.w3-centered
                         {:style {:max-width actual-size, :width actual-size}}
                         [:a {:href href}
                          (when img-url
                            [kvlabelled-image/labelled-image tag img-url name
                             image-width-kw nil nil])]] [:td]
                        [:td [:a {:href href} [:h1.text name]]
                         [:p.w3-panel.w3-light-grey.w3-leftbar.text desc]
                         (when long-desc [:p.text long-desc])]]))
         [:tbody]))]))
