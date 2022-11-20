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

(def write-handlers
  {org.joda.time.DateTime CljTimeWriteHandler})

(defn clj->transit
  ([clj]
   (clj->transit clj :json nil))

  ([clj type opts]
   (let [opts (merge {:handlers write-handlers} opts)]
     (with-open [out (ByteArrayOutputStream. 4096)]
       (-> out
           (transit/writer type opts)
           (transit/write clj))
       (.toString out)))))

(def ^:private CljTimeReadHandler
  (transit/read-handler
   (fn [v] (time-coerce/from-date v))))

(def read-handlers
  {"clj-time" CljTimeReadHandler})

(defn transit->clj
  ([transit]
   (transit->clj transit :json nil))

  ([transit type opts]
   (let [opts (merge {:handlers read-handlers} opts)]
     (with-open [in (ByteArrayInputStream. (.getBytes transit))]
       (-> in
           (transit/reader type opts)
           (transit/read))))))
