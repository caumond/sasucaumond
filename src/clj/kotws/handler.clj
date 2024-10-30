(ns kotws.handler
  "Backend handler to serve images"
  (:require [reitit.ring :as rring]
            [kotws.lang :as klang]
            [clojure.string :as str]
            [clojure.java.io :as io]
            [ring.util.response :as rr]))

(def index
  {:en (slurp (io/resource "public/index_en.html")),
   :fr (slurp (io/resource "public/index_fr.html"))})

(defn extract-query
  [query-string]
  (when (string? query-string)
    (->> (str/split query-string #",")
         (mapv (fn [x]
                 (let [[q v] (str/split x #"=")]
                   (when-not (str/blank? q) [(keyword q) v]))))
         (filter some?)
         (into {}))))

(defn page-request
  [request]
  (let [{:keys [headers query-string]} request
        {:keys [accept-language]} headers
        query-language (extract-query query-string)
        language (some-> query-language
                         (get :l)
                         keyword)]
    (-> (cond (contains? klang/possible-langs language) language
              (and (some? accept-language)
                   (str/starts-with? accept-language "en"))
                :en
              :else :fr)
        index
        rr/response
        (rr/content-type "text/html"))))

(def handler
  (rring/ring-handler
    (rring/router [["/ping"
                    (constantly (-> "pong"
                                    rr/response
                                    (rr/content-type "text/plain")))]
                   ["/index.html" page-request]])
    (rring/routes (rring/create-resource-handler {:path "/"})
                  (rring/create-default-handler {:not-found page-request}))))
