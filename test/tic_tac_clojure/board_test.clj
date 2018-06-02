(ns tic-tac-clojure.board-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]
            [tic-tac-clojure.board :refer :all]))

(deftest generate-empty-board-test
  (is (= empty-board (generate-empty-board))))

(deftest get-space-test
  (is (= "X" (get-space one-mark-board 0)))
  (is (= nil (get-space one-mark-board 1))))

(deftest get-spaces-test
  (is (= ["X" "X" "X"] (get-spaces x-victory-board [0 4 8])))
  (is (= ["O" "O" "O"] (get-spaces o-victory-board [0 1 2])))
  (is (= ["X" "X" "O"] (get-spaces tied-board [0 1 2])))
  (is (= [nil nil nil] (get-spaces empty-board [0 1 2]))))

(deftest empty-space-test
  (is (= true (empty-space? empty-board 0)))
  (is (= false (empty-space? one-mark-board 0))))
            
(deftest mark-board-test
  (is (= one-mark-board (mark-board empty-board 0 "X"))))

