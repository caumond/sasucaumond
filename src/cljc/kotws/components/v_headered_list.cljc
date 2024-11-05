(ns kotws.components.v-headered-list
  "A long lasting list of elements, each separated with a hr, has its icon, short and long text."
  (:require [kotws.components.v-labelled-image :as kvlabelled-image]
            [kotws.lang :as klang]
            [kotws.components.items :as kcitems]
            [kotws.components.v-space :as kv-space]
            [kotws.components.sizes :as ksizes]
            [kotws.links :as klinks]
            [clojure.string :as str]))

(defn defaulting
  "Default items with `img-url`, `href`, `label` `desc`, `long-desc`"
  [items tr image-dic href-dic]
  (-> items
      kcitems/default-name
      (kcitems/default-with-kws [[:img-url :name ""] [:href :name ""]
                                 [:label :name ""] :desc :long-desc])
      (kcitems/apply-dic [:img-url] image-dic)
      (kcitems/apply-dic [:href] href-dic)
      (kcitems/translate [:label :desc :long-desc] klang/possible-langs tr)))

(def defaulting* (memoize defaulting))

(defn header
  "Show the header of the items.

  Is a collection maps, each has `name` and `img-url` keywords."
  [items]
  [:div.w3-row.w3-center
   (reduce (fn [hiccup {:keys [name img-url href]}]
             (conj hiccup
                   [:div.w3-container.w3-cell.w3-mobile
                    [kvlabelled-image/labelled-image img-url href name :tiny]]))
     [:span]
     (vals items))])

(defn detailed-list
  "List elements of `items`

  * Start with the image of `img-url` (on top on small screen, on left on medium and wide screens)
  * `href`
  * The `label` as a title
  * Then a small `desc` highlighted
  * And a `long-desc`

  All that box is linked into `href` link."
  [items image-width-kw]
  (let [actual-size (ksizes/predefined-size image-width-kw)]
    [:table.w3-table.detailed-list
     (->>
       items
       (reduce (fn [hiccup-item [_ {:keys [img-url href label desc long-desc]}]]
                 (conj hiccup-item
                       [:tr
                        [:td.w3-centered.w3-hide-small.w3-hide-medium
                         {:style {:max-width actual-size, :width actual-size}}
                         (when img-url
                           [kvlabelled-image/labelled-image img-url href ""
                            image-width-kw])] [:td]
                        [:td (klinks/a href [:h1.text label])
                         [:div.w3-centered.w3-hide-large
                          {:style {:max-width actual-size, :width actual-size}}
                          (when img-url
                            [kvlabelled-image/labelled-image img-url href ""
                             image-width-kw])]
                         (when-not (str/blank? desc)
                           [:div.w3-row-padding
                            [:div.w3-panel.w3-leftbar.text.light-bg.adaptative
                             desc]])
                         (when-not (str/blank? long-desc) [:div.text long-desc])
                         [kv-space/vertical-spacing]]]))
         [:tbody]))]))
