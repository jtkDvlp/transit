(ns jtk-dvlp.transit
  (:require
   [cognitect.transit :as transit]
   [clj-time.coerce :as time-coerce])

  (:import
   [java.io
    ByteArrayInputStream ByteArrayOutputStream]))


(def ^:private CljTimeWriteHandler
  (transit/write-handler
   (fn [v] "clj-time")
   (fn [v] (time-coerce/to-date v))))

(def ^:private write-handlers
  {org.joda.time.DateTime CljTimeWriteHandler})

(defn clj->transit
  [clj]
  (with-open [out (ByteArrayOutputStream. 4096)]
    (-> out
        (transit/writer :json {:handlers write-handlers})
        (transit/write clj))
    (.toString out)))

(def ^:private CljTimeReadHandler
  (transit/read-handler
   (fn [v] (time-coerce/from-date v))))

(def ^:private read-handlers
  {"clj-time" CljTimeReadHandler})

(defn transit->clj
  [transit]
  (with-open [in (ByteArrayInputStream. (.getBytes transit))]
    (-> in
        (transit/reader :json {:handlers read-handlers})
        (transit/read))))
