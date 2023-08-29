(ns clojure-challenges.medium.redudant)

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn redudant [str]
  (if (string? str)
    (fn [] str)
    (throw (Exception. "Argument must be a string."))))
