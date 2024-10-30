(ns kotws.lang-test
  (:require [kotws.lang :as sut]
            #?(:clj [clojure.test :refer [deftest is]]
               :cljs [cljs.test :refer [deftest is] :include-macros true])))

(deftest translate-langs-test
  (is (= {:en {:foo {:href "zaz"}}, :fr {:foo {:href "zaz"}}}
         (sut/translate-langs {:foo {:href "zaz"}}
                              [:href]
                              [:en :fr]
                              (constantly nil)))
      "string are not modified")
  (is (= {:en {:foo {:href "translated-lang-en"}},
          :fr {:foo {:href "translated-lang-fr"}}}
         (sut/translate-langs {:foo {:href :xx}}
                              [:href]
                              [:en :fr]
                              (fn [l k]
                                (-> {:xx "translated-lang"}
                                    (get k)
                                    (str (str "-" (name l)))))))
      "keyword are transformed into url")
  (is (= {:en {:foo {:label "translated-lang", :name :foo}}}
         (sut/translate-langs {:foo {:name :foo}}
                              [:label]
                              [:en]
                              (fn [l k]
                                (get {:foo-label "translated-lang"} k))))
      "With no `href` set, named is used to set the translated-lang"))

(deftest urls-test
  (is (= {:foo {:href "zaz"}}
         (sut/urls {:foo {:href "zaz"}} [:href] (constantly nil)))
      "string are not modified")
  (is (= {:foo {:href "translated text"}}
         (sut/urls {:foo {:href :xx}}
                   [:href]
                   (fn [x] (get {:xx "translated text"} x))))
      "keyword are transformed into url")
  (is (= {:foo {:href "translated text", :name :foo}}
         (sut/urls {:foo {:name :foo}}
                   [:href]
                   (fn [x] (get {:foo "translated text"} x))))
      "With no `href` set, named is used to set the translated text"))
