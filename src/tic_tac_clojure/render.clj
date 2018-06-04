(ns tic-tac-clojure.render
  (:gen-class)
  (:require [clojure.string :as string]))

(def horizontal-divider
  "----------\n")

(defn convert-nils-to-spaces
  [row-subvec]
  (into [] 
        (map (fn [mark] (if (nil? mark)
                                  " "
                                  mark))
            row-subvec)))
  
(defn fill-row
  [row-subvec]
  (str " " (string/join " | " row-subvec) " \n"))

(defn render-row
  [row]
  (str (fill-row (convert-nils-to-spaces row))))

(defn render-board
  [board]
  (println
    (fill-row (convert-nils-to-spaces (subvec board 0 3))) 
    horizontal-divider
    (fill-row (convert-nils-to-spaces (subvec board 3 6)))
    horizontal-divider
    (fill-row (convert-nils-to-spaces (subvec board 6 9)))))

(defn divide-board-into-rows
  [board] 
  (partition 3 board))
    
; is there a way to avoid passing board into the recursive call (since it isn't used after the initial call)?
(defn render-board-recur
  ([board] 
    (render-board-recur board (divide-board-into-rows board)))
  ([board rows]
    (if (> 1 (count rows))
      (do (print (render-row (first rows)))
          (print horizontal-divider)
          (recur board (rest rows)))
      (print render-row (first rows)))))


