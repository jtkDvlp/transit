(ns jtk-dvlp.transit
  (:require
   [cognitect.transit :as transit]
   [cljs-time.coerce :as time-coerce]))


(deftype CljTimeHandler []
  Object
  (tag [_ v] "clj-time")
  (rep [_ v] (time-coerce/to-date v))
  (stringRep [_ v] nil))

(def write-handlers
  {goog.date.UtcDateTime (CljTimeHandler.)})

(defn clj->transit
  ([clj]
   (clj->transit clj :json nil))

  ([clj type opts]
   (let [opts (merge {:handlers write-handlers} opts)]
     (-> (transit/writer type opts)
         (transit/write clj)))))

(def read-handlers
  {"clj-time" time-coerce/from-date})

(defn transit->clj
  ([transit]
   (transit->clj transit :json nil))

  ([transit type opts]
   (let [opts (merge {:handlers read-handlers} opts)]
     (-> (transit/reader type opts)
         (transit/read transit)))))
