(ns clojure-challenges.core
  (:require [clojure-challenges.medium.redudant :refer [redudant]])
  (:gen-class))

#_{:clj-kondo/ignore [:unused-binding]}
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  #_{:clj-kondo/ignore [:inline-def]}
  (def hello-world (redudant "Hello World!"))
  (println (hello-world)))
