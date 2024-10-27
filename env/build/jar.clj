(ns jar
  "Creates an uberjar"
  (:require [clojure.tools.build.api :as b]
            [clojure.edn :as edn]))

(def lib-name "sasu-caumond")
(def root-dir "target")
(def production-dir "target/production")
(def class-dir "target/classes")
(def major-version "1.0")
(def deps-file "deps.edn")

(defn basis "Create" [] (b/create-basis {:project deps-file}))

(defn clean [d] (b/delete {:path d}))

(defn edn-content
  [filename]
  (-> filename
      slurp
      edn/read-string))

(defn uber
  [_]
  (let [uber-file (format "%s/%s-%s.jar" production-dir lib-name major-version)
        basis (basis)]
    (clean root-dir)
    (b/copy-dir {:src-dirs (-> deps-file
                               edn-content
                               :paths),
                 :target-dir class-dir})
    (b/compile-clj
      {:basis basis, :ns-compile '[kotws.server], :class-dir class-dir})
    (b/uber {:class-dir class-dir,
             :uber-file uber-file,
             :basis basis,
             :main 'kotws.server})))
