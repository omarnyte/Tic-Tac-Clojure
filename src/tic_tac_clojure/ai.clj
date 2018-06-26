(ns tic-tac-clojure.ai
  (:gen-class)
  (:require [tic-tac-clojure.board :as board]
            [tic-tac-clojure.game-logic :as game-logic]))

(def loss -1)
(def tie 0)
(def win 1)
                        
(defn- get-opp-marker
  [marker]
  (if (= "X" marker) "O" "X"))

(defn- evaluate-result
  [board marker score]
  (let [winner (game-logic/winner? board)]
    (cond
      (= winner marker) score
      (nil? winner) tie
      :else (* loss score))))
      
(declare choose-best-space)
      
(defn- simulate-next-move
  [board marker score]
  (let [opp-marker (get-opp-marker marker)]
    (board/mark-board board 
                (choose-best-space board opp-marker) 
                opp-marker)))
      
(defn- score-move 
  [board marker score]
  (if (game-logic/game-over? board)
      (evaluate-result board marker score)
      (recur (simulate-next-move board marker score)
             (get-opp-marker marker)
             (* loss score))))

(def score-move (memoize score-move))

(defn- score-moves
  [board empty-indices marker]
  (map #(score-move (board/mark-board board % marker) 
                    marker 
                    win)
       empty-indices))
            
(defn- create-idx-scores-map 
  [board empty-indices marker]
  (zipmap empty-indices 
          (score-moves board empty-indices marker)))

(defn- pick-max-score-idx
  [idx-scores-map]
  (key (first (sort-by val > idx-scores-map))))
    
(defn choose-best-space 
  [board marker]
  (pick-max-score-idx (create-idx-scores-map board 
                                             (board/empty-space-indices board)
                                             marker)))
