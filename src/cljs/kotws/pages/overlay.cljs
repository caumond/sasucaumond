(ns kotws.pages.overlay
  (:require [re-frame.core :as rf]
            [kotws.events :as events]
            (kotws.subs :as subs)))

(defn panel []
  (let [show-left-panel? (rf/subscribe [::subs/show-left-panel])
        display-menu? (if @show-left-panel?
                          "block"
                          "none")]
    [:div#overlay {:on-click #(rf/dispatch [::events/close-left-panel])
                   :style {:display display-menu?}
                   :title "close side menu"} ]))
