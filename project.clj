(defproject stopwatch "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot stopwatch.core
  :target-path "target/%s"
  :bin {:name "stopwatch" :bin-path "~/dotfiles/bin/"}
  :profiles {:uberjar {:aot :all} :dev {:plugins [[lein-binplus "0.6.2"]]} })
