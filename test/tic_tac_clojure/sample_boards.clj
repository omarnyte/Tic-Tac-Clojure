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

(def near-x-victory-board
  [nil "O" "O" 
   nil "X" "O" 
   nil nil "X"])

(def minimax-board-1
  ["X" nil "X"
   nil nil "O"
   "O" nil "X"])
    
(def minimax-board-2
  ["X" "X" nil
   nil nil "X"
   "O" nil "O"])

(def minimax-board-3
  ["X" nil nil
   nil "O" nil
   nil nil "X"])
    
(def divided-empty-board
  [[nil nil nil] 
   [nil nil nil] 
   [nil nil nil]])

(def divided-one-mark-board
  [["X" nil nil] 
   [nil nil nil] 
   [nil nil nil]])

(def divided-tied-board
  [["X" "X" "O"] 
   ["O" "O" "X"] 
   ["X" "O" "X"]])

(def rendered-empty-board
  "   |   |   \n----------\n   |   |   \n----------\n   |   |   \n")
  
(def rendered-tied-board
  " X | X | O \n----------\n O | O | X \n----------\n X | O | X \n")

(def rendered-x-victory-board
  " X | O | O \n----------\n   | X | O \n----------\n   |   | X \n")

(def rendered-o-victory-board
  " O | O | O \n----------\n   | X | O \n----------\n X |   | X \n")

(def rendered-near-x-victory-board
  "   | O | O \n----------\n   | X | O \n----------\n   |   | X \n")