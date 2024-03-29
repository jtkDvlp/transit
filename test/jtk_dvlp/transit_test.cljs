(ns jtk-dvlp.transit-test
  (:require
   [clojure.test :as t]
   [cljs-time.core :as time]
   [jtk-dvlp.transit :as sut]))


(t/deftest test-clj-time
  (t/is
    (let [clj-time (time/now)]
      (= (str clj-time) (str (sut/transit->clj (sut/clj->transit clj-time)))))))
