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
  (is (= (str rendered-x-victory-board "X wins!\n") 
              (with-out-str (play-round x-victory-board "O"))))
  (is (= (str rendered-o-victory-board "O wins!\n") 
              (with-out-str (play-round o-victory-board "X"))))
  (is (= (str rendered-tied-board "It's a tie!\n") 
              (with-out-str (play-round tied-board "X"))))
  (is (= (str rendered-near-x-victory-board 
              "It's your turn, X.\nPlease choose an index to mark your move: \n"
              rendered-x-victory-board 
              "X wins!\n")
         (with-in-str "0" (with-out-str (play-round near-x-victory-board "X"))))))

(deftest valid-game-selection-test
  (is (= true (valid-game-selection? "1")))
  (is (= true (valid-game-selection? "2")))
  (is (= false (valid-game-selection? "5"))))