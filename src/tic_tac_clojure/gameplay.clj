(ns tic-tac-clojure.gameplay
  (:gen-class)
  (:require [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.cli :refer :all]
            [tic-tac-clojure.game-logic :refer :all]
            [tic-tac-clojure.message-render :refer :all]
            [tic-tac-clojure.player :refer :all]
            [tic-tac-clojure.round :refer :all]))

(defn valid-game-selection?
  [num]
  (in-range? 1 2 num))
  
(defn receive-game-type-input
  []
  (let [selection (extract-numeric-input)]
  (if (valid-game-selection? selection)
      selection
      (do (print-to-cli invalid-game-type-message)
          (recur)))))     
                 
(defn begin-selected-game
  [num]
  (case num 
        1 (play-round (generate-empty-board) 
                      (create-proto-player "X" true)
                      (create-proto-player "O" true))
        2 (play-round (generate-empty-board)
                      (create-proto-player "X" true)
                      (create-proto-player "O" false))))
        
(defn start-tic-tac-toe
  []
  (print-to-cli game-selection-prompt)
  (begin-selected-game (receive-game-type-input)))