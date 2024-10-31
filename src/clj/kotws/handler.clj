(ns kotws.handler
  "Backend handler to serve html file or resources."
  (:require [reitit.ring :as rring]
            [clojure.string :as str]
            [clojure.java.io :as io]
            [ring.util.response :as rr]))

(def index
  {"en" (slurp (io/resource "public/index_en.html")),
   "fr" (slurp (io/resource "public/index_fr.html"))})

(defn extract-query
  [query-string]
  (when (string? query-string)
    (->> (str/split query-string #",")
         (map (fn [x]
                (let [[lang params] (str/split x #";")
                      [q v] (when-not (str/blank? params)
                              (str/split params #"="))
                      [base-lang subtag] (when-not (str/blank? lang)
                                           (str/split lang #"-"))
                      weight (if (str/blank? v) 100 (Double/parseDouble v))]
                  {:weight weight, :base-lang base-lang, :subtag subtag}))))))

(defn select-lang
  [query-langs possible-langs]
  (->> query-langs
       (filter (fn [{:keys [base-lang]}] (contains? possible-langs base-lang)))
       first
       :base-lang))

(defn page-request
  [request]
  (let [accept-language (get-in request [:headers "accept-language"])
        query-languages (extract-query accept-language)
        selected-lang (select-lang query-languages #{"en" "fr"})]
    (-> (or selected-lang "fr")
        index
        rr/response
        (rr/update-header "cache-control"
                          (fn [_] "max-age=0, private, must-revalidate"))
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
