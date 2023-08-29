(ns clojure-challenges.medium.redudant-test
  (:require [clojure.test :refer [deftest testing is run-tests]])
  (:require [clojure-challenges.medium.redudant :refer [redudant]]))

(deftest redudant-test-string-argument
  (testing "should return a function that returns the same string passed in as an argument"
    (let [string-arg "Clojure is Awesome!!!"
          f (redudant string-arg)
          result (f)]
      (is (= string-arg (result))))))

(deftest redudant-test-non-string-argument
  (testing "should return failure with non-string argument"
    (let [non-string-arg 1
          f (redudant non-string-arg)]
      (is (thrown? Exception (f))))))

(deftest redudant-test-non-string-argument-error-message
  (testing "should return an error message for non-string argument"
    (let [non-string-arg 1
          f (redudant non-string-arg)]
      (is (thrown? Exception
                   (try
                     (f)
                     (catch Exception e
                       (is (= (.getMessage e) "Argument must be a string.")))))))))

(run-tests)
