(ns kotws.pages.home-panel
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]
            [kotws.subs :as subs]))

;; home
(defn display-re-pressed-example []
  (let [re-pressed-example (re-frame/subscribe [::subs/re-pressed-example])]
    [:div

     [:p
      [:span "Re-pressed is listening for keydown events. A message will be displayed when you type "]
      [:strong [:code "hello"]]
      [:span ". So go ahead, try it out! and have fun"]]

     (when-let [rpe @re-pressed-example]
       [re-com/alert-box
        :alert-type :info
        :body rpe])]))

(defn home-title []
  (let [name (re-frame/subscribe [::subs/name])]
    [re-com/title
     :label (str "Hello from " @name ". This is the Home Page!!")
     :level :level1]))

(defn link-to-about-page []
  [re-com/v-box
   :gap "1em"
   :children [
              [re-com/hyperlink-href
               :label "go to About Page"
               :href "#/about"]
              [re-com/hyperlink-href
               :label "go to blog"
               :href "#/blog-cc-clojure-panel"]]
   ])

(defn home-panel []
  [re-com/v-box
   :gap "1em"
   :children [[home-title]
              [link-to-about-page]
              [display-re-pressed-example]
              ]])


