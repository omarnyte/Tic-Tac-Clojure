(ns tic-tac-clojure.board
  (:gen-class))

(defn generate-empty-board
  []
  (vec (repeat 9 nil)))

(defn get-space
  [board pos]
  (nth board pos))

(defn empty-space?
  [board pos]
  (= nil (get-space board pos)))

(defn mark-board
  [board pos mark]
  (assoc board pos mark))

(defn tie?
  [board]
  (not-any? (fn [x] (nil? x)) 
            board))
