(ns tic-tac-clojure.board-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]
            [tic-tac-clojure.board :refer :all]))

(deftest generate-empty-board-test
  (is (= empty-board (generate-empty-board 9))))

(deftest board-length-test 
  (is (= 9 (board-length empty-board))))

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
            
(deftest empty-space-indices-test
  (is (= [0 1 2 3 4 5 6 7 8] (empty-space-indices empty-board)))
  (is (= [1 2 3 4 5 6 7 8] (empty-space-indices one-mark-board)))
  (is (= [0 3 6 7] (empty-space-indices near-x-victory-board))))
  
(deftest mark-board-test
  (is (= one-mark-board (mark-board empty-board 0 "X"))))

(deftest get-rows-test
  (is (= [["X" "X" "O"]
          ["O" "O" "X"] 
          ["X" "O" "X"]] (get-rows tied-board))))

(deftest get-rows-test
  (is (= [["X" "O" "X"]
          ["X" "O" "O"] 
          ["O" "X" "X"]] (get-cols tied-board))))

(deftest get-diags-test 
  (is (= [["X" "O" "X"] 
          ["O" "O" "X"]] (get-diags tied-board))))
