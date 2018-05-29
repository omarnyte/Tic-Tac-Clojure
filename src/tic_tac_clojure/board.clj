(ns tic-tac-clojure.board
  (:gen-class))
  
(defn create-empty-board
  []
  [
    {:pos 0 :mark nil}
    {:pos 1 :mark nil}
    {:pos 2 :mark nil}
    {:pos 3 :mark nil}
    {:pos 4 :mark nil}
    {:pos 5 :mark nil}
    {:pos 6 :mark nil}
    {:pos 7 :mark nil}
    {:pos 8 :mark nil}
  ])

(defn get-space
  [board pos]
  (into {} 
        (filter 
          (fn [item] (= pos (get item :pos))) 
          board)))

(defn empty?
  [board pos]
  (= nil (get (get-space board pos)
              :mark)))

(defn mark-board
  [board pos mark]
        (map 
          (fn [space] (if (= pos (get space :pos))
                        (assoc space :mark mark)))
          board))

(defn tie?
  [board]
  (not-any? (fn [x] (nil? x)) 
            (map (fn [space] (get space :mark))
                  board)))