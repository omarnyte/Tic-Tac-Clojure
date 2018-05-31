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

(defn check-three
  [board indices]
  (if (every?
        (fn [mark] (= "X" mark))
        (mapv 
          (fn [idx] (nth board idx))
          indices))
    "X"
    (if (every?
          (fn [mark] (= "O" mark))
          (mapv 
            (fn [idx] (nth board idx))
            indices))
      "O")))

(defn winner? 
  ([board] 
    (winner? board winning-indices))
  ([board remaining-indices]
    (if (empty? remaining-indices)
      nil 
      (if (check-three board (first remaining-indices))
        (check-three board (first remaining-indices))    
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