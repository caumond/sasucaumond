(ns kotws.pages.home.panel
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]
            [kotws.multi-language :as ml]
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
  [re-com/title
   :label (ml/get-msg :home-title)
   :level :level1])

(defn home-panel []
  [re-com/v-box
   :gap "1em"
   :children [[home-title]
              [display-re-pressed-example]
              ]])


