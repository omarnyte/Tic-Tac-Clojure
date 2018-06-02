(ns tic-tac-clojure.game-logic-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]
            [tic-tac-clojure.game-logic :refer :all]))

(deftest identical-marks-test
  (is (= true (identical-marks? ["X" "X" "X"])))
  (is (= true (identical-marks? ["O" "O" "O"])))
  (is (= false (identical-marks? ["X" "X" "O"])))
  (is (= true (identical-marks? [nil nil nil]))))

(deftest no-nil-marks-test
  (is (= true (no-nil-marks? ["X" "O" "X"])))
  (is (= false (no-nil-marks? [nil "O" "O"])))
  (is (= false (no-nil-marks? ["X" "X" nil])))
  (is (= false (no-nil-marks? [nil nil nil]))))

; (deftest winner-from-indices-test
;   (is (= "X" (winner-from-indices x-victory-board [0 4 8])))
;   (is (= "O" (winner-from-indices o-victory-board [0 1 2])))
;   (is (= nil (winner-from-indices tied-board [0 1 2])))
;   (is (= nil (winner-from-indices empty-board [0 1 2]))))
            
(deftest check-three-test
  (is (= "X" (check-three x-victory-board [0 4 8])))
  (is (= "O" (check-three o-victory-board [0 1 2])))
  (is (= nil (check-three tied-board [0 1 2]))))

(deftest winner-test
  (is (= "X" (winner? x-victory-board)))
  (is (= "O" (winner? o-victory-board)))
  (is (= nil (winner? tied-board))))

(deftest tie-test
  (is (= true (tie? tied-board)))
  (is (= false (tie? empty-board)))
  (is (= false (tie? x-victory-board)))
  (is (= false (tie? o-victory-board))))

(deftest game-over-test
  (is (= true (game-over? tied-board)))
  (is (= true (game-over? x-victory-board)))
  (is (= true (game-over? o-victory-board)))
  (is (= false (game-over? empty-board))))
    