(ns tic-tac-clojure.game-logic
  (:gen-class)
  (:require [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.validators :refer :all]))

(def winning-indices
  [[0 1 2]
  [3 4 5]
  [6 7 8]
  [0 3 6]
  [1 4 7]
  [2 5 8]
  [0 4 8]
  [2 4 6]])

(defn valid-move?
  [board num]
  (and  (in-range? 0 8 num)
        (empty-space? board num)))

(defn- no-nil-marks?
  [marks]
  (not-any? #(nil? %) marks))

(defn- identical-marks?
  [marks]
  (let [first-mark (first marks)]
    (every? #(= first-mark %) marks)))

(defn- winner-from-indices
  [board indices]
  (let [marks (get-spaces board indices)]
    (if (and (no-nil-marks? marks)
             (identical-marks? marks))
        (first marks)
        nil)))

(defn- winner? 
  ([board] 
    (winner? board winning-indices))
  ([board remaining-indices]
    (if (empty? remaining-indices)
      nil 
      (if (winner-from-indices board (first remaining-indices))
        (winner-from-indices board (first remaining-indices))    
        (recur board (rest remaining-indices))))))

(defn tie?
  [board]
  (not-any? (fn [x] (nil? x)) 
            board))

(defn game-over?
  [board]
  (if (or (winner? board) (tie? board))
    true 
    false))