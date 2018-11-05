(defn get-banner
  []
  (try
    (str
      (slurp "resources/text/banner.txt")
      ;(slurp "resources/text/loading.txt")
      )
    ;; If another project can't find the banner, just skip it;
    ;; this function is really only meant to be used by Dragon itself.
    (catch Exception _ "")))

(defn get-prompt
  [ns]
  (str "\u001B[35m[\u001B[34m"
       ns
       "\u001B[35m]\u001B[33m λ\u001B[m=> "))

(defproject externa "0.1.0-SNAPSHOT"
  :description "An extension of the Clojure Component library for system parts outside of the JVM"
  :url "https://github.com/clojusc/externa"
  :license {
    :name "Apache License, Version 2.0"
    :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [
    [com.stuartsierra/component "0.3.2"]
    [com.taoensso/nippy "2.14.0"]
    [org.clojure/clojure "1.9.0"]]
  :profiles {
    :dev {
      :dependencies [
        [org.clojure/tools.namespace "0.2.11"]]
      :source-paths [
        "dev-resources/src"]
      :repl-options {
        :init-ns externa.repl
        :prompt ~get-prompt
        :init ~(println (get-banner))}}})
