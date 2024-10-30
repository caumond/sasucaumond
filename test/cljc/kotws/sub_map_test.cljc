(ns kotws.sub-map-test
  (:require [kotws.sub-map :as sut]
            #?(:clj [clojure.test :refer [deftest is]]
               :cljs [cljs.test :refer [deftest is] :include-macros true])))

(deftest add-key-test
  (is (= {:foo {:ff :foo}, :bar {:ff "aa"}}
         (sut/add-key {:foo {}, :bar {:ff "aa"}} :ff))
      "Key is added for all maps which don't have it already"))

(deftest add-key-suffix-test
  (is
    (= {:foo {:name :foo, :baz "foo-desc"},
        :bar {:name :bar, :baz "untouched value"}}
       (sut/update-submaps {:foo {:name :foo},
                            :bar {:name :bar, :baz "untouched value"}}
                           :baz
                           (fn [submap] (str (name (:name submap)) "-desc"))))
    "The function is applied to all submaps which does not already have a value"))

(deftest reference-kw-suffix-test
  (is (= {:foo {:name :foo, :baz :foo-suffix},
          :bar {:name :bar, :baz "untouched value"}}
         (sut/reference-kw-suffix {:foo {:name :foo},
                                   :bar {:name :bar, :baz "untouched value"}}
                                  :baz
                                  :name
                                  "-suffix"))
      "The suffix is added to all submaps which does not already have a value")
  (is (= {:foo {:name :foo, :baz :foo-baz},
          :bar {:name :bar, :baz "untouched value"}}
         (sut/reference-kw-suffix {:foo {:name :foo},
                                   :bar {:name :bar, :baz "untouched value"}}
                                  :baz
                                  :name))
      "The suffix is defaulted to `-baz` from the name of the key to insert")
  (is (= {:foo {:name :foo, :baz :foo-baz},
          :bar {:name :bar, :baz "untouched value"}}
         (sut/reference-kw-suffix {:foo {:name :foo},
                                   :bar {:name :bar, :baz "untouched value"}}
                                  :baz
                                  :name))
      "The suffix is defaulted to `-baz` from the name of the key to insert"))
(is (= {:foo {:name :foo, :baz :foo-baz},
        :bar {:name :bar, :baz "untouched value"}}
       (sut/reference-kw-suffix {:foo {:name :foo},
                                 :bar {:name :bar, :baz "untouched value"}}
                                :baz
                                :name))
    "vectors are understood as get-in")
