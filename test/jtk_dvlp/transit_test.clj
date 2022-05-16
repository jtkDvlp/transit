(ns jtk-dvlp.transit-test
  (:require
   [clojure.test :as t]
   [clj-time.core :as time]
   [jtk-dvlp.transit :as sut]))


(t/deftest test-clj-time
  (t/is
    (let [clj-time (time/now)]
      (= clj-time (sut/transit->clj (sut/clj->transit clj-time))))))
