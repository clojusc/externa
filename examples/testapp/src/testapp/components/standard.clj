(ns testapp.components.standard
  "This is a standard, if somewhat sparse and no-op-ish, Component."
  (:require
   [com.stuartsierra.component :as component]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Lifecycle Implementation   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defrecord StandardJVMComponent [])

(defn start
  [this]
  (println "Starting standard JVM component ...")
  (println "Started standard JVM component.")
  this)

(defn stop
  [this]
  (println "Stopping standard JVM component ...")
  (println "Stopped standard JVM component.")
  this)

(def lifecycle-behaviour
  {:start start
   :stop stop})

(extend StandardJVMComponent
  component/Lifecycle
  lifecycle-behaviour)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Constructor   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn create
  ""
  []
  (map->StandardJVMComponent {}))
