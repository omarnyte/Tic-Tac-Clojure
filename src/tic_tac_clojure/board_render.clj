(ns tic-tac-clojure.board-render
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math]
            [clojure.string :as string]
            [tic-tac-clojure.cli :refer :all]
            [tic-tac-clojure.message-render :refer :all]))

(def horizontal-divider
  "----------")

(defn- convert-nils-to-spaces
  [row-subvec]
  (into [] 
        (map (fn [mark] (if (nil? mark)
                                  " "
                                  mark))
            row-subvec)))
  
(defn- fill-row
  [row-subvec]
  (str " " (string/join " | " row-subvec) " "))

(defn- render-row
  [row]
  (fill-row (convert-nils-to-spaces row)))

(defn- divide-board-into-rows
  [board] 
  (partition (math/sqrt (count board)) 
             board))
    
(defn render-board
  ([board] 
    (render-board board (divide-board-into-rows board)))
  ([board rows]
    (if (> (count rows) 1)
      (do (print-to-cli (render-row (first rows)))
          (print-to-cli horizontal-divider)
          (recur board (rest rows)))
      (print-to-cli (render-row (first rows))))))