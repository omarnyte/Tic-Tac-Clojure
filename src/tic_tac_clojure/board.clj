(ns tic-tac-clojure.board
  (:gen-class))
  
(defn create-empty-board
  []
  ({
    0 nil 1 nil 2 nil
    3 nil 4 nil 5 nil 
    6 nil 7 nil 8 nil 
  }))

