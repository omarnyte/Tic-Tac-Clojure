(ns tic-tac-clojure.ai-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.ai :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]))
            
(deftest choose-best-space-test
  (testing "it chooses the winning move if possible"
    (is (= 4 (choose-best-space minimax-board-1 "O"))))
  (testing "it blocks the opponent from winning if possible"
    (is (= 6 (choose-best-space minimax-board-2 "O")))))