(ns kotws.components.v-langs)

(defn lang-bar
  "Displays all lang in `langs`, and highlight the `current-lang`. When a lang is actioned it is calling `(switch-lang :pl)` to switch to polish language."
  [langs current-lang switch-lang]
  (reduce (fn [hiccup lang]
            (conj hiccup
                  [:button.w3-button.w3-right
                   (cond-> {}
                     (= current-lang lang) (assoc :class
                                             "secondary-bg secondary-text")
                     switch-lang (assoc :on-click #(switch-lang lang))) lang]))
    [:<>]
    langs))
