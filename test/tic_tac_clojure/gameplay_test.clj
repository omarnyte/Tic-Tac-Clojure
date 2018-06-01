(ns tic-tac-clojure.gameplay-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.gameplay :refer :all]
            [tic-tac-clojure.render :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]))

(deftest convert-to-num-test
  (is (= 0 (convert-to-num "0"))))

(deftest is-number-test
  (is (= true (is-number? "0")))
  (is (= false (is-number? "a"))))
            
(deftest in-range-test
  (is (= true (in-range? 0 8 0)))
  (is (= true (in-range? 0 8 4)))
  (is (= true (in-range? 0 8 8)))
  (is (= false (in-range? 0 8 9))))

(deftest valid-selection-test
  (is (= true (valid-selection? empty-board 0)))
  (is (= false (valid-selection? one-mark-board 0)))
  (is (= false (valid-selection? one-mark-board 9))))

(deftest play-round-test
  (is (= "Game over!\n" (with-out-str (play-round x-victory-board "O"))))
  (is (= "Game over!\n" (with-out-str (play-round tied-board "X")))))

(deftest switch-player-test
  (is (= "X" (switch-player "O")))
  (is (= "O" (switch-player "X"))))