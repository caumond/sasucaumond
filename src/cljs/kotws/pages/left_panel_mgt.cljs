(ns kotws.pages.left-panel-mgt)

(defn open-left-panel []
  (set!
   (-> js/document
       (.getElementById "left-panel")
       (.-style)
       (.-display))
   "block")
  (set!
   (-> js/document
       (.getElementById "overlay")
       (.-style)
       (.-display))
   "block")
  )

(defn close-left-panel []
  (set!
    (-> js/document
        (.getElementById "left-panel")
        (.-style)
        (.-display))
    "none")
  (set!
    (-> js/document
        (.getElementById "overlay")
        (.-style)
        (.-display))
    "none")
  )

;; Public
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def closeable-link {:on-click close-left-panel})
