(defproject brunchlotto "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [netpyoung/fb-sdk-cljs "0.1.1"]
                 [hiccup "1.0.5"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-environ "1.0.1"]]
  :ring {:handler brunchlotto.core/app}
  :min-lein-version "2.0.0"
  :uberjar-name "brunchlotto.jar"
  :jvm-opts ["-server"]
  :resource-paths ["resources"]

  :main brunchlotto.core
  :profiles
  {:uberjar {:omit-source true
             :env {:production true}
             :aot :all
             :source-paths ["env/prod/clj"]
             :resource-paths ["env/prod/resources"]}
   :dev           [:project/dev :profiles/dev]
   :test          [:project/test :profiles/test]
   :project/dev  {:dependencies [[prone "1.0.1"]
                                 [ring/ring-mock "0.3.0"]
                                 [ring/ring-devel "1.4.0"]
                                 [pjstadig/humane-test-output "0.7.1"]]

                  :source-paths ["env/dev/clj"]
                  :resource-paths ["env/dev/resources"]
                  :repl-options {:init-ns brunchlotto.core}
                  :injections [(require 'pjstadig.humane-test-output)
                               (pjstadig.humane-test-output/activate!)]

                  :env {:dev        true
                        :port       3000
                        :nrepl-port 7000}}
   :project/test {:env {:test       true
                        :port       3001
                        :nrepl-port 7001}}
   :profiles/dev {}
   :profiles/test {}})
