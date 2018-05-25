(ns tic-tac-clojure.board-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.board :refer :all]))

(def empty-board
  [
    {:pos 0 :mark nil}
    {:pos 1 :mark nil}
    {:pos 2 :mark nil}
    {:pos 3 :mark nil}
    {:pos 4 :mark nil}
    {:pos 5 :mark nil}
    {:pos 6 :mark nil}
    {:pos 7 :mark nil}
    {:pos 8 :mark nil}
  ])

(def one-mark-board
  [
    {:pos 0 :mark "X"}
    {:pos 1 :mark nil}
    {:pos 2 :mark nil}
    {:pos 3 :mark nil}
    {:pos 4 :mark nil}
    {:pos 5 :mark nil}
    {:pos 6 :mark nil}
    {:pos 7 :mark nil}
    {:pos 8 :mark nil}
  ])

            
(deftest create-empty-board-test
  (is (= empty-board (create-empty-board))))

(deftest get-space-test
  (is (= {:pos 0 :mark nil} (get-space empty-board 0)))
  )

(deftest empty-test
  (is (= true (empty? empty-board 0)))
  (is (= false (empty? one-mark-board 0))))
            