(ns externa.jar
  ""
  (:require
   [clojure.java.shell :as shell]
   [com.stuartsierra.component :as component]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Lifecycle Implementation   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defrecord JarFileBasedComponent
  [component-id
   path])

(defn start
  [this]
  (println "Starting JAR file based component ...")
  (shell/sh ["java" "-jar" (:path this)])
  (println "Started JAR file based component.")
  (assoc this (:component-id this) )

(defn stop
  [this]
  (println "Stopping JAR file based component ...")
  (println "Stopped JAR file based component.")
  this)

(def lifecycle-behaviour
  {:start start
   :stop stop})

(extend JarFileBasedComponent
  component/Lifecycle
  lifecycle-behaviour)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Constructor   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn create
  ""
  [opts]
  (map->JarFileBasedComponent opts))
