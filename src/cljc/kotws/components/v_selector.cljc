(ns kotws.components.v-selector)

(defn- clamp
  [v min max]
  (cond (< v min) min
        (> v max) max
        :else v))

(defn relative-jump
  "Current element `v` is move to `val` page forward (if positive, backward if negative).

  The resulting value is clamped between `0` and `n`"
  [n val v]
  (-> v
      (+ val)
      (clamp 0 n)))

(defn v-selector
  "Selector to get one of the `n` element in the list.

  * The `selected` one is given. in `go-to` and `go-rel`.
  * The `(go-to x)` is added to the button options to leap to page `x`
  * The `(go-rel x)` is added to the button options to move relatively `x` page from the current one."
  [n selected go-to go-rel]
  (conj (->> (take n (iterate inc 1))
             (reduce (fn [hiccup-item page]
                       (conj hiccup-item
                             ^{:key page}
                             [:span.w3-button.w3-small
                              (cond-> (when (= (dec page) selected)
                                        {:class "w3-disabled",
                                         :style {:cursor :default}})
                                (fn? go-to) (merge (go-to (dec page)))) page]))
               [:div
                [:i.w3-button.fa.fa-angle-left
                 (cond-> {}
                   (fn? go-rel) (merge (go-rel -1))
                   (zero? selected) (assoc :class "w3-disabled"))]]))
        [:i.w3-button.fa.fa-angle-right
         (cond-> {}
           (fn? go-rel) (merge (go-rel 1))
           (= (dec n) selected) (assoc :class "w3-disabled"))]))
