(ns tic-tac-clojure.ai-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.ai :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]))
            
(def sample-scores-map
  {2 0
   3 -1 
   4 -1
   7 1})

(deftest get-opp-marker-test
  (is (= "O" (get-opp-marker "X")))
  (is (= "X" (get-opp-marker "O"))))
   
(deftest evaluate-result-test
  (is (= -100 (evaluate-result x-victory-board "O")))
  (is (= 0 (evaluate-result tied-board "O")))
  (is (= 100 (evaluate-result o-victory-board "O"))))
            
; (deftest pick-max-score-index-test
;   (is (= 3 (pick-max-score-index sample-scores-map))))
            
; (deftest choose-best-space-test
;   (is (= 7 (choose-best-space minimax-board-2)))
;   (is (= 6 (choose-best-space minimax-board-3))))