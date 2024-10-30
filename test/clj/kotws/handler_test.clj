(ns kotws.handler-test
  (:require [kotws.handler :as sut]
            [clojure.test :refer [deftest is]]))

(deftest extract-query-test
  (is (= [{:weight 100, :base-lang "en", :subtag "US"}
          {:weight 0.9, :base-lang "en", :subtag nil}
          {:weight 0.8, :base-lang "zh", :subtag "CN"}
          {:weight 0.7, :base-lang "zh", :subtag nil}]
         (sut/extract-query "en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7"))))

(deftest select-lang-test
  (is (= "en"
         (sut/select-lang [{:weight 100, :base-lang "en", :subtag "US"}
                           {:weight 0.9, :base-lang "en", :subtag nil}]
                          #{"en" "fr"}))
      "When first language is possible")
  (is (= "fr"
         (sut/select-lang [{:weight 100, :base-lang "en", :subtag "US"}
                           {:weight 0.9, :base-lang "fr", :subtag nil}]
                          #{"fr"}))
      "When second language is possible")
  (is (nil? (sut/select-lang [{:weight 100, :base-lang "en", :subtag "US"}
                              {:weight 0.9, :base-lang "fr", :subtag nil}]
                             #{}))
      "When no language is possible"))
