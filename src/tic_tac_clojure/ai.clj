(ns tic-tac-clojure.ai
  (:gen-class)
  (:require [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.game-logic :refer :all]))

(declare choose-best-space)
(declare score-move)
            
(defn get-opp-marker
  [marker]
  (if (= "X" marker) "O" "X"))

(defn evaluate-result
  [board marker score]
  (let [winner (winner? board)]
    (cond
      (= winner marker) 1 
      (nil? winner) 0
      :else (* -1 score))))
      
(defn simulate-move
  [board marker score]
  (let [opp-marker (get-opp-marker marker)]
    (score-move (mark-board board 
                            (choose-best-space board opp-marker) 
                            opp-marker)
                opp-marker 
                (* -1 score))))
      
(defn score-move 
  [board marker score]
  (if (game-over? board)
      (evaluate-result board marker score)
      (simulate-move board marker score)))

(def score-move (memoize score-move))
            
(defn create-idx-scores-map 
  [board empty-indices marker]
  (zipmap empty-indices 
          (map #(score-move (mark-board board % marker) 
                            marker 
                            1)
                empty-indices)))

(defn pick-max-score-idx
  [idx-scores-map]
  (key (first (sort-by val > idx-scores-map))))
    
(defn choose-best-space 
  [board marker]
  (pick-max-score-idx (create-idx-scores-map board 
                                             (empty-space-indices board)marker)))
