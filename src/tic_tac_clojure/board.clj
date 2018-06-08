(ns tic-tac-clojure.board
  (:gen-class))

(defn generate-empty-board
  []
  (vec (repeat 9 nil)))

(defn get-space
  [board pos]
  (nth board pos))

(defn get-spaces
  [board positions]
  (mapv (fn [idx] (get-space board idx))
        positions))

(defn empty-space?
  [board pos]
  (= nil (get-space board pos)))

(defn empty-space-indices
  [board]
  (keep-indexed #(if (nil? %2) %1) board))
  
(defn mark-board
  [board pos mark]
  (assoc board pos mark))
  