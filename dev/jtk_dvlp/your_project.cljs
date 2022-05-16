(ns ^:figwheel-hooks jtk-dvlp.your-project
  (:require
   [cljs.pprint]
   [goog.dom :as gdom]
   [reagent.dom :as rdom]
   [re-frame.core :refer [reg-event-fx reg-event-db dispatch reg-sub subscribe reg-cofx inject-cofx] :as rf]))


(defn app-view
  []
  [:<>
   "it`s working"])


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; re-frame setup

(defn- mount-app
  []
  (rdom/render
    [app-view]
    (gdom/getElement "app")))

(defn ^:after-load on-reload
  []
  (rf/clear-subscription-cache!)
  (mount-app))

(defonce on-init
  (mount-app))
