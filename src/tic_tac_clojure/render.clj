(ns tic-tac-clojure.render
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math]
            [clojure.string :as string]))

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
  (fill-row (convert-nils-to-spaces row)))

(defn divide-board-into-rows
  [board] 
  (partition (math/sqrt (count board)) 
             board))
    
(defn render-board
  ([board] 
    (render-board board (divide-board-into-rows board)))
  ([board rows]
    (if (> (count rows) 1)
      (do (print (render-row (first rows)))
          (print horizontal-divider)
          (recur board (rest rows)))
      (print (render-row (first rows))))))


