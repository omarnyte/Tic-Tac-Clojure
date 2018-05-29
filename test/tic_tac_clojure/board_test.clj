(ns tic-tac-clojure.board-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.board :refer :all]))

; sample boards 
(def empty-board
  [ {:pos 0 :mark nil}
    {:pos 1 :mark nil}
    {:pos 2 :mark nil}
    {:pos 3 :mark nil}
    {:pos 4 :mark nil}
    {:pos 5 :mark nil}
    {:pos 6 :mark nil}
    {:pos 7 :mark nil}
    {:pos 8 :mark nil} ])

(def one-mark-board
  [ {:pos 0 :mark "X"}
    {:pos 1 :mark nil}
    {:pos 2 :mark nil}
    {:pos 3 :mark nil}
    {:pos 4 :mark nil}
    {:pos 5 :mark nil}
    {:pos 6 :mark nil}
    {:pos 7 :mark nil}
    {:pos 8 :mark nil} ])

(def tied-board
  [ {:pos 0 :mark "X"}
    {:pos 1 :mark "X"}
    {:pos 2 :mark "O"}
    {:pos 3 :mark "O"}
    {:pos 4 :mark "O"}
    {:pos 5 :mark "X"}
    {:pos 6 :mark "X"}
    {:pos 7 :mark "O"}
    {:pos 8 :mark "X"} ])

(def x-victory-board
  [ {:pos 0 :mark "X"}
    {:pos 1 :mark "O"}
    {:pos 2 :mark "O"}
    {:pos 3 :mark nil}
    {:pos 4 :mark "X"}
    {:pos 5 :mark nil}
    {:pos 6 :mark nil}
    {:pos 7 :mark nil}
    {:pos 8 :mark "X"} ])

(def o-victory-board
  [ {:pos 0 :mark "O"}
    {:pos 1 :mark "O"}
    {:pos 2 :mark "O"}
    {:pos 3 :mark nil}
    {:pos 4 :mark "X"}
    {:pos 5 :mark nil}
    {:pos 6 :mark "X"}
    {:pos 7 :mark nil}
    {:pos 8 :mark "X"} ])

    
; tests 
(deftest create-empty-board-test
  (is (= empty-board (create-empty-board))))

(deftest get-space-test
  (is (= {:pos 0 :mark nil} (get-space empty-board 0))))

(deftest empty-test
  (is (= true (empty? empty-board 0)))
  (is (= false (empty? one-mark-board 0))))
            
(deftest mark-board-test
  (is (= one-mark-board (mark-board empty-board 0 "X"))))

(deftest tie-test
  (is (= true (tie? tied-board)))
  (is (= false (tie? empty-board)))
  (is (= false (tie? x-victory-board)))
  (is (= false (tie? o-victory-board))))

; (deftest winner-test
;   (is (= "X" (winner? x-victory-board)))
;   (is (= "O" (winner? x-victory-board))))

