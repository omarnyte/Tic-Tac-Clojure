(ns tic-tac-clojure.board
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math]))
  
(defn generate-empty-board
  [board-length]
  (vec (repeat board-length nil)))

(defn board-length
  [board]
  (count board))

(defn board-size
  [board]
  (math/sqrt (count board)))

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
  
(defn get-rows
  [board]
  (partition (math/sqrt (board-length board)) 
             board))

(defn get-cols
  [board]
  (apply map vector (get-rows board)))

(defn- get-TL-to-BR-diag
  [board]
  (let [starting-idx 0
        ending-idx (board-length board)
        step (+ (board-size board) 1)]
    (get-spaces board
                (range starting-idx ending-idx step))))

(defn- get-TR-to-BL-diag
  [board]
  (let [starting-idx (- (board-size board) 1)
        ending-idx (- (board-length board) 1)
        step starting-idx]
  (get-spaces board
              (range starting-idx ending-idx step))))

(defn get-diags 
  [board]
  (vector (get-TL-to-BR-diag board)
          (get-TR-to-BL-diag board)))