(ns tic-tac-clojure.ai
  (:gen-class)
  (:require [tic-tac-clojure.board :refer :all]))

(defn choose-random-empty-space
  [board]
  (let [idx (rand-int 9)]
  (if (empty-space? board idx)
      idx
      (recur board))))

(defn choose-best-space
  [board]
  (choose-random-empty-space board))