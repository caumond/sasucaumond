(ns kotws.components.selector
  "A stateful selector displaying numbered elements, wrapped in previous and next buttons."
  (:require [re-frame.core :as rf]))

(defn- clamp
  [v min max]
  (cond (< v min) min
        (> v max) max
        :else v))

(rf/reg-sub ::selected-idx (fn [db _] (:selected-idx db)))

(rf/reg-event-db ::change-selected-idx
                 (fn [db [_ sel-kw change-mode val n]]
                   (case change-mode
                     :abs (assoc-in db [:selected-idx sel-kw] (clamp val 0 n))
                     :rel (update-in db
                                     [:selected-idx sel-kw]
                                     (fn [v]
                                       (-> v
                                           (+ val)
                                           (clamp 0 n)))))))

(defn selected
  "Returns the selected element for selector called `sel-kw`"
  [sel-kw]
  (get @(rf/subscribe [::selected-idx]) sel-kw 0))

(defn v-selector
  [n selected go-to go-rel]
  (-> (concat [:div [:i.w3-button.fa.fa-angle-left {:on-click (go-rel -1)}]]
              (->> (take n (iterate inc 1))
                   (mapv (fn [i]
                           ^{:key i}
                           [:span.w3-button.w3-small
                            {:class (when (= (dec i) selected) "w3-disabled"),
                             :on-click (go-to (dec i))} i])))
              [[:i.w3-button.fa.fa-angle-right {:on-click (go-rel 1)}]])
      vec))


(defn selector
  [sel-kw n]
  (let [selected (selected sel-kw)]
    (v-selector
      n
      selected
      (fn [select]
        #(rf/dispatch [::change-selected-idx sel-kw :abs select (dec n)]))
      (fn [select]
        #(rf/dispatch [::change-selected-idx sel-kw :rel select (dec n)])))))
