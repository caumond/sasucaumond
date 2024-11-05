(ns kotws.pages.v-sc-test
  (:require [kotws.pages.v-sc :as sut]
            [kotws.lang :as klang]
            #?(:clj [clojure.test :refer [deftest is]]
               :cljs [cljs.test :refer [deftest is] :include-macros true])))

(deftest dic-test
  (is (empty? (klang/is-complete? sut/dic #{:fr :en})) "Is dictionary ok?"))
