(ns kotws.components.v-slider
  "A slider shows a list of items, with a navigator to crawl them."
  (:require [kotws.components.items :as kcitems]
            [kotws.components.v-selector :as kvselector]
            [kotws.components.v-labelled-image :as kvlabelled-image]
            [kotws.components.v-space :as kvspace]))

(defn defaulting
  "The slider shows a list of items.

  Each item is described with a `title` and `sub-title`, then the image `img-link` is shown below.
  `desc` and `details` are two categories shown below, where `desc should be 3/4 lines and `details` is as long as necessary"
  [items tr image-dic href-dic langs]
  (-> items
      kcitems/default-name
      (kcitems/default-with-kws [:title :sub-title [:img-link :name ""] :desc
                                 :details [:href :name ""]])
      (kcitems/apply-dic [:img-link] image-dic)
      (kcitems/apply-dic [:href] href-dic)
      (kcitems/translate [:title :sub-title :desc :details :href] langs tr)))

(def defaulting* (memoize defaulting))

(defn subtitle-img-long-desc
  [tr books selected opts-go-to opts-go-rel]
  (let [nbooks (count books)
        {:keys [title sub-title img-link desc details href]}
          (nth (vals books) (if (number? selected) selected 0))]
    [:div
     [:div.w3-center
      [kvselector/v-selector nbooks selected (partial opts-go-to nbooks)
       (partial opts-go-rel nbooks)]] (when (some? title) [:h2.text title])
     (when (some? sub-title) [:h3.text sub-title])
     [:div.w3-row [:p.w3-third]
      [kvlabelled-image/raw-image img-link href nil :medium]]
     [kvspace/vertical-spacing]
     [:div.w3-container.w3-card-4 [:h3 (tr :desc-title) ": "]
      [:p.text (tr desc)]] [kvspace/vertical-spacing]
     (when-not (keyword? details) [:p (tr :desc-detailed-title) ": "])
     (when-not (keyword? details) [:p.text details]) [kvspace/vertical-spacing]
     [:div.w3-center
      [kvselector/v-selector nbooks selected (partial opts-go-to nbooks)
       (partial opts-go-rel nbooks)]]]))
