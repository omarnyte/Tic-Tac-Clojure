(ns tic-tac-clojure.sample-boards
  (:gen-class))

(def empty-board
  [nil nil nil 
  nil nil nil 
  nil nil nil])

(def one-mark-board
  ["X" nil nil 
  nil nil nil 
  nil nil nil])

(def tied-board
  ["X" "X" "O" 
    "O" "O" "X" 
    "X" "O" "X"])

(def x-victory-board
  ["X" "O" "O" 
    nil "X" "O" 
    nil nil "X"])

(def o-victory-board
  ["O" "O" "O" 
    nil "X" "O" 
    "X" nil "X"])