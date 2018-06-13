(ns tic-tac-clojure.validators-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.validators :refer :all]))

(deftest is-number-test
  (is (= true (is-number? "0")))
  (is (= false (is-number? "a"))))
            
(deftest in-range-test
  (is (= true (in-range? 0 8 0)))
  (is (= true (in-range? 0 8 4)))
  (is (= true (in-range? 0 8 8)))
  (is (= false (in-range? 0 8 9))))
