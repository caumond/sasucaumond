(ns kotws.components.single-test
  (:require [kotws.components.single :as sut]
            #?(:clj [clojure.test :refer [deftest is]]
               :cljs [cljs.test :refer [deftest is] :include-macros true])))

(deftest translate-test
  (is (= {:fr "arg-fr", :en "arg-en"}
         (sut/translate :arg
                        #{:fr :en}
                        (fn [l x]
                          (get-in {:fr {:arg "arg-fr"}, :en {:arg "arg-en"}}
                                  [l x]))))))
