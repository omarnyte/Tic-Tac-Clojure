(ns tic-tac-clojure.ai
  (:gen-class)
  (:require [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.game-logic :refer :all]))

(defn get-opp-marker
  [marker]
  (if (= "X" marker)
      "O"
      "X"))

(defn evaluate-result
  [board ai-marker]
  (let [winner (winner? board)]
    (cond
      (= winner ai-marker) 100 
      (nil? winner) 0
      :else -100)))
    
(defn pick-max-score-idx
  [scores-map]
  (key (first (sort-by val > scores-map))))
      
;