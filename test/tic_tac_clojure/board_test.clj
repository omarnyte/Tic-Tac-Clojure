(ns tic-tac-clojure.board-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.board :refer :all]))

; sample boards 
(def empty-board
  [nil nil nil 
  nil nil nil 
  nil nil nil])

(def one-mark-board
  ["X" nil nil 
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
(deftest generate-empty-board-test
  (is (= empty-board (generate-empty-board))))

(deftest get-space-test
  (is (= "X" (get-space one-mark-board 0)))
  (is (= nil (get-space one-mark-board 1))))

(deftest empty-space-test
  (is (= true (empty-space? empty-board 0)))
  (is (= false (empty-space? one-mark-board 0))))
            
(deftest mark-board-test
  (is (= one-mark-board (mark-board empty-board 0 "X"))))

(deftest tie-test
  (is (= true (tie? tied-board)))
  (is (= false (tie? empty-board)))
  (is (= false (tie? x-victory-board)))
  (is (= false (tie? o-victory-board))))

; (deftest get-winner-test
;   (is (= "X" (get-winner x-victory-board)))
;   (is (= "O" (get-winner x-victory-board))))



