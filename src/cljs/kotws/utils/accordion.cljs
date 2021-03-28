(ns kotws.utils.accordion
  (:require [clojure.string :as str]))

;; Private
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn click-accordion [item-to-expand]
  (let
      [ class-name (-> js/document
                       (.getElementById item-to-expand)
                       (.-className)
                       )]
    (set!
      (-> js/document
          (.getElementById item-to-expand)
          (.-className))
      (if (str/includes? class-name "w3-show")
        (str/replace class-name #" w3-show" "")
        (str class-name " w3-show")
        )
      )
    ))

;; Public
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn accordionize[item-to-expand]
  {:on-click (partial click-accordion item-to-expand)})
