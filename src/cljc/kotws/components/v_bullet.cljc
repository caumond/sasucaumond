(ns kotws.components.v-bullet
  "Shows a bullet list."
  (:require [kotws.components.items :as kcitems]
            [kotws.links :as klinks]))

(defn defaulting
  [items tr href-dic langs]
  (-> items
      kcitems/default-name
      (kcitems/default-with-kws [[:href :name ""] [:label :name ""] :desc])
      (kcitems/apply-dic [:href] href-dic)
      (kcitems/translate [:desc :label] langs tr)))

(def defaulting* (memoize defaulting))

(defn bullet
  "Simple bullet list

  * `items` is a map which values are:
      * `fa-icon` is a font awesome icon
      * `name` is used to add a react key
      * `href` address to point (applied to the rouding box)
      * `label` the name to add on the right of the icon
      * `desc` the description to continue the label explanation"
  [items]
  (reduce (fn [hiccup
               {:keys [fa-icon name href label desc],
                :or {fa-icon "fa-circle"}}]
            (conj hiccup
                  ^{:key name}
                  [:li.text [:i.fa.w3-margin-right {:class fa-icon}]
                   [:b.text.w3-margin-right (klinks/a href (str label ":"))]
                   desc]))
    [:ul.w3-ul]
    (vals items)))
