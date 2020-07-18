(ns kotws.pages.blog-cc-clojure-panel
  (:require [re-com.core :as re-com]))

;; blog-1
(defn blog-cc-clojure-panel []
  [re-com/v-box
   :gap "1em"
   :children [[re-com/title
               :label "Build and deploy clojure apps on clever cloud"
               :level :level1]
              [re-com/p "lein new re-frame kotws --force +10x +cider +handler +re-com +re-pressed +routes +test"]
              [re-com/p "lein new re-frame kotws --force +10x +cider +handler +re-com +re-pressed +routes +test"]
              [re-com/p "lein new re-frame kotws --force +10x +cider +handler +re-com +re-pressed +routes +test"]
              [re-com/p "lein new re-frame kotws --force +10x +cider +handler +re-com +re-pressed +routes +test"]
              [re-com/p "lein new re-frame kotws --force +10x +cider +handler +re-com +re-pressed +routes +test"]
              [re-com/p "lein new re-frame kotws --force +10x +cider +handler +re-com +re-pressed +routes +test"]
              [re-com/p "lein new re-frame kotws --force +10x +cider +handler +re-com +re-pressed +routes +test"]
              [re-com/p "lein new re-frame kotws --force +10x +cider +handler +re-com +re-pressed +routes +test"]
              [re-com/p "lein new re-frame kotws --force +10x +cider +handler +re-com +re-pressed +routes +test"]
              [re-com/p "lein new re-frame kotws --force +10x +cider +handler +re-com +re-pressed +routes +test"]
              [re-com/p "lein new re-frame kotws --force +10x +cider +handler +re-com +re-pressed +routes +test"]
              [re-com/p "lein new re-frame kotws --force +10x +cider +handler +re-com +re-pressed +routes +test"]
              ]])

