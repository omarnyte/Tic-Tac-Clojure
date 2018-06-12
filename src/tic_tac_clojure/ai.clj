(ns tic-tac-clojure.ai
  (:gen-class)
  (:require [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.game-logic :refer :all]))

(declare choose-best-space)
            
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
      
(defn score-move 
  [board marker score]
  (if (game-over? board)
      (evaluate-result board marker score)
      (let [opp-marker (get-opp-marker marker)]
        (recur (mark-board board 
                           (choose-best-space board opp-marker) opp-marker)
               opp-marker 
               (* -1 score)))))

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



; (defn best-move [board player]
; (let [moves (empty-spaces board)
;       scores (zipmap moves (map #(score-move (fill-space board % player) player win) moves))
;       best-score (reduce max (vals scores))
;       best-moves (filter #(= (scores %) best-score) moves)]
;   (first best-moves)))