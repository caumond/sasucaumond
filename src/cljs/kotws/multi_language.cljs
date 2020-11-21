(ns kotws.multi-language
  (:require [tongue.core :as tongue]))

;; TODO study the opportunity to exectute a macro to bind the language, its listening to sbus/language, and parametered dictionnary, return a 
(defn build-translate [dictionnary]
  (tongue/build-translate dictionnary))

