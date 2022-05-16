(ns jtk-dvlp.transit
  (:require
   [cognitect.transit :as transit]
   [cljs-time.coerce :as time-coerce]))


(deftype CljTimeHandler []
  Object
  (tag [_ v] "clj-time")
  (rep [_ v] (time-coerce/to-date v))
  (stringRep [_ v] nil))

(def ^:private writer
  (transit/writer
   :json
   {:handlers
    {goog.date.UtcDateTime (CljTimeHandler.)}}))

(defn clj->transit
  [clj]
  (transit/write writer clj))

(def ^:private reader
  (transit/reader
   :json
   {:handlers
    {"clj-time" time-coerce/from-date}}))

(defn transit->clj
  [transit]
  (transit/read reader transit))
