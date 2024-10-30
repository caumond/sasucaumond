(ns kotws.components.v-lang
  "Language based components"
  (:require [kotws.components.v-labelled-image :as vclabelled-image]))

(defn vclabelled-image
  "Show an image based on a language.

  * `l` is the language to display
  * ` doc-links` contains two keys
     * `img-links` what is shown
     * `href-links` destination link when actioned"
  ([l doc-links] (vclabelled-image l doc-links nil))
  ([l doc-links label]
   (let [{:keys [img-links href-links]} doc-links]
     [vclabelled-image/labelled-image (get img-links l) (get href-links l) label
      :medium])))

(defn lang-bar
  "Displays all lang in `langs`, and highlight the `current-lang`. When a lang is actioned it is calling `(switch-lang :pl)` to switch to polish language."
  [langs current-lang switch-lang]
  (-> [:div.w3-bar]
      (concat (->> langs
                   (mapv
                     (fn [l] [:a.w3-right
                              (cond-> {}
                                (= current-lang l)
                                  (assoc :class "secondary-bg secondary-text")
                                switch-lang (assoc :on-click #(switch-lang l)))
                              [:button.w3-button l]]))))
      vec))
