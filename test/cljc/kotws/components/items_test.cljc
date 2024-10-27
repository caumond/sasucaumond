(ns kotws.components.items-test
  (:require [kotws.components.items :as sut]
            #?(:clj [clojure.test :refer [deftest is]]
               :cljs [cljs.test :refer [deftest is] :include-macros true])))

(deftest str-to-kw-test
  (is (= :foo (sut/str-to-kw :foo)) "noop on valid keyword")
  (is (= :foo-aze (sut/str-to-kw "foo aze")) "noop on keyword")
  (is (= :foo-aze-suff (sut/str-to-kw "foo aze" "suff")) "suffix is added"))

(deftest default-name-test
  (is
    (= {:foo {:name :foo}, :bar {:name :specific-name}}
       (sut/default-name {:foo {}, :bar {:name :specific-name}}))
    "Add `name` keyword to all entries except the ones that have already been set"))

(deftest default-with-kw-test
  (is (= {:foo {:name :sfoo, :added-kw :sfoo-added-kw},
          :bar {:name :bar, :added-kw :bar-added-kw}}
         (sut/default-with-kw {:foo {:name :sfoo}, :bar {:name :bar}}
                              :added-kw
                              :name))
      "Added-kw is added eerywhere and source from `:name`"))

(deftest default-with-kws-test
  (is (= {:foo {:name :sfoo,
                :added-kw :sfoo-added-kw,
                :copied-from-added-kw :sfoo-added-kw-suffix},
          :bar {:name :bar,
                :added-kw :bar-added-kw,
                :copied-from-added-kw :bar-added-kw-suffix}}
         (sut/default-with-kws {:foo {:name :sfoo}, :bar {:name :bar}}
                               [:added-kw
                                [:copied-from-added-kw :added-kw "-suffix"]]))))
