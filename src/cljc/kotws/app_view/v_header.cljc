(ns kotws.app-view.v-header
  (:require [kotws.language :as klang]))

(defn v-header
  "Display the header reused for all pages."
  [current-language switch-lang]
  [:<>
   (-> [:div.w3-bar]
       (concat (->> klang/possible-langs
                    (mapv
                      (fn [l] [:a.w3-right
                               (cond-> {}
                                 (= current-language l)
                                   (assoc :class "secondary-bg secondary-text")
                                 switch-lang (assoc :on-click #(switch-lang l)))
                               [:button.w3-button l]]))))
       vec)])
