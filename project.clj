(defproject net.clojars.jtkdvlp/transit "0.0.0-SNAPSHOT"
  :description
  "Mini clj and cljs lib for common transit usage."

  :url
  "https://github.com/jtkDvlp/transit.git"

  :license
  {:name
   "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
   :url
   "https://www.eclipse.org/legal/epl-2.0/"}

  :source-paths
  ["src"]

  :target-path
  "target"

  :clean-targets
  ^{:protect false}
  [:target-path]

  :profiles
  {:provided
   {:dependencies
    [[org.clojure/clojure "1.10.0"]
     [org.clojure/clojurescript "1.10.773"]

     [re-frame "1.1.2"]

     [com.cognitect/transit-clj "1.0.329"]
     [clj-time "0.15.2"]

     [com.cognitect/transit-cljs "0.8.269"]
     [com.andrewmcveigh/cljs-time "0.5.2"]
     ,,,]}

   :dev
   {:dependencies
    [[com.bhauman/figwheel-main "0.2.13"]]

    :source-paths
    ["dev"]}

   :repl
   {:dependencies
    [[cider/piggieback "0.5.2"]]

    :repl-options
    {:nrepl-middleware
     [cider.piggieback/wrap-cljs-repl]

     :init-ns
     user

     }}}

  ,,,)
