(ns jtk-dvlp.runner
  (:require
   [figwheel.main.testing :refer-macros [run-tests]]
   [jtk-dvlp.transit-test]))


(defn -main [& args]
  (run-tests))
