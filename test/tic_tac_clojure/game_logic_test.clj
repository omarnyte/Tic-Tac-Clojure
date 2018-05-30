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
(deftest tie-test
  (is (= true (tie? tied-board)))
  (is (= false (tie? empty-board)))
  (is (= false (tie? x-victory-board)))
  (is (= false (tie? o-victory-board))))

; (deftest get-winner-test
;   (is (= "X" (get-winner x-victory-board)))
;   (is (= "O" (get-winner o-victory-board))))

(deftest game-over-test
  (is (= true (game-over? tied-board)))
  (is (= true (game-over? x-victory-board)))
  (is (= true (game-over? o-victory-board))))
    