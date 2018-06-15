(ns tic-tac-clojure.game-logic
  (:gen-class)
  (:require [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.validators :refer :all]))

(defn valid-move?
  [board num]
  (let [last-idx (- (board-length board) 1)]
  (and  (in-range? 0 last-idx num)
        (empty-space? board num))))

(defn- no-nil-marks?
  [marks]
  (not-any? #(nil? %) marks))

(defn- identical-marks?
  [marks]
  (let [first-mark (first marks)]
    (every? #(= first-mark %) marks)))

(defn- get-winning-combos
  [board]
  (concat (get-rows board)
          (get-cols board)
          (get-diags board)))
        
(defn winner? 
  ([board] 
    (winner? board (get-winning-combos board)))
  ([board winning-combos]
    (if (empty? winning-combos)
      nil 
      (if (identical-marks? (first winning-combos))
          (first (first winning-combos))    
          (recur board (rest winning-combos))))))

(defn tie?
  [board]
  (not-any? (fn [x] (nil? x)) 
            board))

(defn game-over?
  [board]
  (if (or (winner? board) (tie? board))
    true 
    false))