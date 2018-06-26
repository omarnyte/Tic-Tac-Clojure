(ns tic-tac-clojure.cli-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.cli :refer :all]
            [tic-tac-clojure.message-render :refer :all]))
          
(deftest print-to-cli-test
  (is (= "Hello, world!\n" (with-out-str (print-to-cli "Hello, world!")))))

(deftest get-valid-num-input-test
  (testing "it returns a number when a user enters a number that is within range"
    (is (= 0 (with-in-str "0" (get-valid-num-input 0 1)))))
  (testing "it ask for a number between min and max when a user enters a number outside the range"
    (is (= 1 (with-in-str "10\n1\n" (get-valid-num-input 1 9))))
    (is (= 1 (with-in-str "0\n1\n" (get-valid-num-input 1 9)))))) 