(ns tic-tac-clojure.cli-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.cli :refer :all]))

(deftest convert-to-num-test
  (is (= 0 (convert-to-num "0"))))

(deftest is-number-test
  (is (= true (is-number? "0")))
  (is (= false (is-number? "a"))))