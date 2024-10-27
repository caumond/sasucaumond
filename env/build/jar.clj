(ns jar
  (:require [clojure.tools.build.api :as b]))

(def lib-name "sasu-caumond")
(def root-dir "target")
(def production-dir "target/production")
(def class-dir "target/classes")
(def major-version "1.0")

(def uber-file (format "%s/%s-standalone.jar" production-dir lib-name))

;; delay to defer side effects (artifact downloads)
(def basis (delay (b/create-basis {:project "deps.edn"})))

(defn clean [d] (b/delete {:path d}))

(defn uber
  [_]
  (clean root-dir)
  (b/copy-dir {:src-dirs ["src/cljc" "src/clj" "resources"],
               :target-dir class-dir})
  (b/compile-clj
    {:basis @basis, :ns-compile '[kotws.server], :class-dir class-dir})
  (b/uber {:class-dir class-dir,
           :uber-file uber-file,
           :basis @basis,
           :main 'kotws.server.main})
  (b/copy-file {:src "env/build/jar.json",
                :target (format "%s/clever/jar.json" production-dir)}))
