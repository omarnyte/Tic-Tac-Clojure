(ns tic-tac-clojure.game-logic-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.game-logic :refer :all]))

; sample boards
(def empty-board
  [nil nil nil 
  nil nil nil 
  nil nil nil])

(def tied-board
  ["X" "X" "O" 
    "O" "O" "X" 
    "X" "O" "X"])

(def x-victory-board
  ["X" "O" "O" 
    nil "X" "O" 
    nil nil "X"])

(def o-victory-board
  ["O" "O" "O" 
    nil "X" "O" 
    "X" nil "X"])

; tests
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

; (deftest get-winner-test
;   (is (= "X" (get-winner x-victory-board)))
;   (is (= "O" (get-winner o-victory-board))))

; (deftest game-over-test
;   (is (= true (game-over? tied-board)))
;   (is (= true (game-over? x-victory-board)))
;   (is (= true (game-over? o-victory-board))))
    