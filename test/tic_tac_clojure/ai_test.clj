(ns tic-tac-clojure.ai-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.ai :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]))
            
(deftest choose-best-space-test
  (is (= 4 (choose-best-space minimax-board-1 "O")))
  (is (= 6 (choose-best-space minimax-board-2 "O"))))