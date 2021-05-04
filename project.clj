(defproject kotws "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.773"
                  :exclusions [com.google.javascript/closure-compiler-unshaded
                               org.clojure/google-closure-library
                               org.clojure/google-closure-library-third-party]]
                 [thheller/shadow-cljs "2.10.13"]
                 [reagent "0.10.0"]
                 [selmer "1.12.34"]
                 [re-frame "0.12.0"]
                 [re-com "2.8.0"]
                 [clj-commons/secretary "1.2.4"]
                 [compojure "1.6.1"]
                 [tongue "0.2.9"]
                 [com.taoensso/tempura "1.2.1"]
                 [yogthos/config "1.1.7"]
                 [ring "1.8.1"]
                 [re-pressed "0.3.1"]
                 [day8.re-frame/tracing "0.6.0"]
                 [breaking-point "0.1.2"]
                 ]

  :plugins [[lein-shadow "0.2.0"]
            [lein-less "1.7.5"]
            [lein-shell "0.5.0"]]

  :min-lein-version "2.9.0"

  :jvm-opts ["-Xmx1G"]

  :source-paths ["src/clj"
                 "src/cljs"]

  :test-paths   ["test/cljs"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"
                                    "test/js"]

  :less {:source-paths ["src/less"]
         :target-path  "resources/public/css"}

  :shell {:commands {"open" {:windows ["cmd" "/c" "start"]
                             :macosx  "open"
                             :linux   "xdg-open"}}}

  :shadow-cljs {:nrepl {:port 8777}

                :builds {:app {:target     :browser
                               :output-dir "resources/public/js/compiled"
                               :asset-path "/js/compiled"
                               :modules    {:app {:init-fn  kotws.core/init
                                                  :preloads [devtools.preload
                                                             day8.re-frame-10x.preload
                                                             ]}}
                               :dev        {:compiler-options {:closure-defines {re-frame.trace.trace-enabled?        true
                                                                                 day8.re-frame.tracing.trace-enabled? true}}}
                               :release {:build-options {:ns-aliases
                                            {day8.re-frame.tracing
                                            day8.re-frame.tracing-stubs}}}
                               :devtools   {:http-root    "resources/public"
                                            :http-port    8280
                                            :http-handler kotws.handler/dev-handler
                                            }}
                         :browser-test
                         {:target    :browser-test
                          :ns-regexp "-test$"
                          :runner-ns shadow.test.browser
                          :test-dir  "target/browser-test"
                          :devtools  {:http-root "target/browser-test"
                                      :http-port 8290}}

                         :karma-test
                         {:target    :karma
                          :ns-regexp "-test$"
                          :output-to "target/karma-test.js"}}}

  :aliases {"dev"          ["with-profile" "dev" "do"
                            ["shadow" "watch" "app"]]
            "prod"         ["with-profile" "prod" "do"
                            ["shadow" "release" "app"]]
            "build-report" ["with-profile" "prod" "do"
                            ["shadow" "run" "shadow.cljs.build-report" "app" "target/build-report.html"]
                            ["shell" "open" "target/build-report.html"]]
            "karma"        ["with-profile" "prod" "do"
                            ["shadow" "compile" "karma-test"]
                            ["shell" "karma" "start" "--single-run" "--reporters" "junit,dots"]]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "1.0.2"]
                   [day8.re-frame/re-frame-10x "0.7.0"]
                   ]
    :source-paths ["dev"]
    :jvm-opts     ["-Dclojure.spec.check-asserts=true"]}

   :prod {:closure-defines {:goog.DEBUG false}}

   :uberjar {:source-paths ["env/prod/clj"]
             :omit-source  true
             :main         kotws.server
             :aot          [kotws.server]
             :uberjar-name "kotws.jar"
             :prep-tasks   ["compile" ["prod"]]}}

  :prep-tasks [
               ["less" "once"]]
  )
