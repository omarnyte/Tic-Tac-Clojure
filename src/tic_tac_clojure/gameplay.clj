(ns tic-tac-clojure.gameplay
  (:gen-class)
  (:require [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.cli :refer :all]
            [tic-tac-clojure.message-render :refer :all]
            [tic-tac-clojure.player :refer :all]
            [tic-tac-clojure.round :refer :all]))

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
  (begin-selected-game (get-valid-num-input 1 2))
  (print-to-cli play-again-prompt)
  (case (get-valid-num-input 0 1)
    0 (print-to-cli thank-you-message)
    1 (recur)))
