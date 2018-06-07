(ns tic-tac-clojure.round
  (:gen-class)
  (:require [tic-tac-clojure.ai :refer :all]
            [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.board-render :refer :all]
            [tic-tac-clojure.cli :refer :all]
            [tic-tac-clojure.game-logic :refer :all]
            [tic-tac-clojure.message-render :refer :all]
            [tic-tac-clojure.player :refer :all]))

(defn valid-selection?
  [board str]
  (and (is-number? str) 
      (valid-move? board
                   (convert-to-num str))))
        
(defn handle-game-over
  [board previous-player]
  (if (tie? board)
    (print-to-cli tied-game-message)
    (print-to-cli (generate-winner-message 
                  (get-player-mark previous-player)))))
  
(defn switch-player
  [current-player]
  (if (= "X" current-player)
      "O"
      "X"))

(defn allow-human-move
  [board player]
  (print-to-cli (generate-move-selection-prompt (get-player-mark player)))
  (let [selection (read-line)]
    (if (valid-selection? board selection)
        (mark-board board 
                    (convert-to-num selection) 
                    (get-player-mark player))
        (do (print-to-cli invalid-move-message)
            (recur board player)))))

(defn allow-ai-move
  [board player]
  (let [rand-idx (choose-random-empty-space board)]
    (print-to-cli (print-to-cli (generate-ai-choice-message rand-idx)))
    (mark-board board 
                rand-idx
                (get-player-mark player))))

(defn take-turn 
  [board current-player]
  (if (is-human? current-player)
      (allow-human-move board current-player)
      (allow-ai-move board current-player)))
    
(defn play-round
  [board curr-player opp-player]
  (render-board board)
  (if (game-over? board)
      (handle-game-over board opp-player)    
      (recur (take-turn board curr-player)
              opp-player
              curr-player)))