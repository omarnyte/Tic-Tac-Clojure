(ns tic-tac-clojure.game-logic
  (:gen-class))

(def winning-indices
  [[0 1 2]
  [3 4 5]
  [6 7 8]
  [0 3 6]
  [1 4 7]
  [2 5 8]
  [0 4 8]
  [2 4 6]])

(defn tie?
  [board]
  (not-any? (fn [x] (nil? x)) 
            board))

(defn game-over?
  [board]
  (or (tie? board)))