(ns testapp.core
  (:require
    [testapp.components.core :as components]
    [com.stuartsierra.component :as component])
  (:gen-class))

(defn handle-shutdown
  [handler]
  (.addShutdownHook (Runtime/getRuntime)
                    (new Thread handler)))

(defn daemonize
  []
  (.join (Thread/currentThread)))

(defn -main
  [& args]
  (let [system (components/initialize)]
    (component/start system)
    (handle-shutdown #(component/stop system))
    (daemonize)))
