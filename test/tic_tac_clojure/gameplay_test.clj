(ns tic-tac-clojure.gameplay-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.gameplay :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]))

(deftest convert-to-num-test
  (is (= 0 (convert-to-num "0"))))

(deftest is-number-test
  (is (= true (is-number? "0")))
  (is (= false (is-number? "a"))))
            
(deftest valid-selection-test
  (is (= true (valid-selection? empty-board "0")))
  (is (= false (valid-selection? one-mark-board "0")))
  (is (= false (valid-selection? one-mark-board "9")))
  (is (= false (valid-selection? one-mark-board "a"))))

(deftest switch-player-test
  (is (= "X" (switch-player "O")))
  (is (= "O" (switch-player "X"))))
  
(deftest play-round-test
  (is (= "X wins!\n" (with-out-str (play-round x-victory-board "O"))))
  (is (= "O wins!\n" (with-out-str (play-round o-victory-board "X"))))
  (is (= "It's a tied game!\n" (with-out-str (play-round tied-board "X")))))
