(ns tic-tac-clojure.ai
  (:gen-class)
  (:require [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.game-logic :refer :all]))

(declare choose-best-space)
            
(defn get-opp-marker
  [marker]
  (if (= "X" marker) "O" "X"))

(defn evaluate-result
  [board ai-marker]
  (let [winner (winner? board)]
    (cond
      (= winner ai-marker) 100 
      (nil? winner) 0
      :else -100)))
      
(defn score-move 
  [board marker score]
  (if (game-over? board)
      (evaluate-result board marker)
      (let [opp-marker (get-opp-marker marker)
            sim-board (mark-board board (choose-best-space board opp-marker) opp-marker)]
        (recur sim-board 
               opp-marker 
               (* -100 score)))))
            
(defn create-idx-scores-map 
  [board empty-indices marker]
  (zipmap empty-indices 
          (map #(score-move (mark-board board % marker) 
                            marker 
                            100)
                empty-indices)))

(defn pick-max-score-idx
  [idx-scores-map]
  (key (first (sort-by val > idx-scores-map))))

(defn choose-best-space 
  [board marker]
  (let [avail-indices (empty-space-indices board)
        idx-scores-map (create-idx-scores-map board avail-indices marker)]
    (pick-max-score-idx idx-scores-map)))