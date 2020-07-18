(ns kotws.pages.header
  (:require [re-com.core :as re-com]))

(defn header[]
  [re-com/h-box :gap "3em"
   :children [[re-com/box :size "auto" :child [re-com/hyperlink-href :label "Kot website" :href "#/"]]
              [re-com/hyperlink-href :label "Home" :href "#/"]
              [re-com/hyperlink-href :label "Blog" :href "#/blog-cc-clojure-panel"]
              [re-com/hyperlink-href :label "About" :href "#/about"]]])
