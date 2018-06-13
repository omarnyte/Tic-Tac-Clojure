(ns tic-tac-clojure.ai-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.ai :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]))
            
(def sample-scores-map-1
  {2 1
   3 -1 
   4 -1
   7 1
   8 -5})

(def sample-scores-map-2
  {0 -1
   3 1 
   4 5
   7 1
   8 -5})

(deftest get-opp-marker-test
  (is (= "O" (get-opp-marker "X")))
  (is (= "X" (get-opp-marker "O"))))
   
(deftest evaluate-result-test
  (is (= -1 (evaluate-result x-victory-board "O" 1)))
  (is (= 0 (evaluate-result tied-board "O" 1)))
  (is (= 1 (evaluate-result o-victory-board "O" 1))))
            
(deftest pick-max-score-idx-test
  (is (= (or 2 7) (pick-max-score-idx sample-scores-map-1)))
  (is (= 4 (pick-max-score-idx sample-scores-map-2))))
            
(deftest choose-best-space-test
  (is (= 4 (choose-best-space minimax-board-1 "O")))
  (is (= 6 (choose-best-space minimax-board-2 "O"))))