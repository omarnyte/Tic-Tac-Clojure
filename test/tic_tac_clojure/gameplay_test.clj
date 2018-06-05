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

(deftest valid-move-test
  (is (= true (valid-move? empty-board 0)))
  (is (= false (valid-move? one-mark-board 0)))
  (is (= false (valid-move? one-mark-board 9))))

(deftest valid-selection-test
  (is (= true (valid-selection? empty-board "0")))
  (is (= false (valid-selection? one-mark-board "0")))
  (is (= false (valid-selection? one-mark-board "9")))
  (is (= false (valid-selection? one-mark-board "a"))))

(deftest switch-player-test
  (is (= "X" (switch-player "O")))
  (is (= "O" (switch-player "X"))))

(deftest winner-message-test
  (is (= "O wins!" (generate-winner-message "X")))
  (is (= "X wins!" (generate-winner-message "O"))))

(deftest generate-game-over-message-test
  (is (= "X wins!" (generate-game-over-message x-victory-board "O")))
  (is (= "It's a tied game!" (generate-game-over-message tied-board "X"))))
  
; (deftest play-round-test
;   (is (= "X wins!\n" (with-out-str (play-round x-victory-board "O"))))
;   (is (= "O wins!\n" (with-out-str (play-round o-victory-board "X"))))
;   (is (= "It's a tied game!\n" (with-out-str (play-round tied-board "X")))))
