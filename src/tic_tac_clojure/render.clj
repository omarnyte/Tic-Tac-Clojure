(ns tic-tac-clojure.render
  (:gen-class)
  (:require [clojure.string :as string]))

(def horizontal-divider
  "----------\n")

(defn convert-nils-to-spaces
  [row-subvec]
  (into [] (map (fn [mark] (if (nil? mark)
                              "  "
                              mark))
                row-subvec)))
  
(defn fill-row
  [row-subvec]
  (str " " (string/join " | " row-subvec) " \n"))

(defn render-board
  [board]
  (str 
    (fill-row (subvec board 0 3)) 
    horizontal-divider
    (fill-row (subvec board 3 6))
    horizontal-divider
    (fill-row (subvec board 6 9))))