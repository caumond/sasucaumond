(ns kotws.components.c-selector
  "A stateful selector displaying numbered elements, wrapped in previous and next buttons."
  (:require [re-frame.core :as rf]
            [kotws.components.v-selector :as kvselector]))

(rf/reg-sub ::selected-idx (fn [db _] (:selected-idx db)))

(rf/reg-event-db
  ::change-selected-idx
  (fn [db [_ sel-kw change-mode val n]]
    (case change-mode
      :abs (assoc-in db [:selected-idx sel-kw] (kvselector/clamp val 0 n))
      :rel (update-in db
                      [:selected-idx sel-kw]
                      (partial kvselector/relative-jump n val)))))

(defn selected
  "Returns the selected element for selector called `sel-kw`"
  [sel-kw]
  (get @(rf/subscribe [::selected-idx]) sel-kw 0))

(defn opts-go-to
  [sel-kw n page]
  {:on-click #(rf/dispatch [::change-selected-idx sel-kw :abs page (dec n)])})

(defn opts-go-rel
  [sel-kw n page]
  {:on-click #(rf/dispatch [::change-selected-idx sel-kw :rel page (dec n)])})

(defn selector
  [sel-kw n]
  (let [selected (selected sel-kw)]
    (kvselector/v-selector n
                           selected
                           (partial opts-go-to sel-kw n)
                           (partial opts-go-rel sel-kw n))))
