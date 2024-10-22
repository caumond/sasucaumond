(ns kotws.config "Returns debug status.")

(def debug? ^boolean goog.DEBUG)

(def language (let [l js/lang] (if l (keyword l) :en)))
