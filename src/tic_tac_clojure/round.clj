(ns tic-tac-clojure.round
  (:gen-class)
  (:require [tic-tac-clojure.ai :refer :all]
            [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.board-render :refer :all]
            [tic-tac-clojure.cli :refer :all]
            [tic-tac-clojure.game-logic :refer :all]
            [tic-tac-clojure.message-render :refer :all]
            [tic-tac-clojure.player :refer :all]))
        
(defn handle-game-over
  [board previous-player]
  (if (tie? board)
    (print-to-cli tied-game-message)
    (print-to-cli (generate-winner-message (get-player-mark previous-player)))))

(defn valid-board-idx-selection?
  [board num]
  (valid-move? board num))

(defn receive-board-idx-input 
  [board]
  (let [selection (extract-numeric-input)]
    (if (valid-board-idx-selection? board selection)
        selection
        (do (print-to-cli (generate-invalid-move-message selection))
            (recur board)))))

(defn allow-human-move
  [board player]
  (print-to-cli (generate-move-selection-prompt (get-player-mark player)))
  (let [idx (receive-board-idx-input board)]
    (mark-board board
                idx
                (get-player-mark player))))

(defn allow-ai-move
  [board player]
  (let [rand-idx (choose-random-empty-space board)]
    (print-to-cli (print-to-cli (generate-ai-choice-message rand-idx)))
    (mark-board board 
                rand-idx
                (get-player-mark player))))

(defn take-turn 
  [board player]
  (if (is-human? player)
      (allow-human-move board player)
      (allow-ai-move board player)))
    
(defn play-round
  [board curr-player opp-player]
  (render-board board)
  (if (game-over? board)
      (handle-game-over board opp-player)    
      (recur (take-turn board curr-player)
              opp-player
              curr-player)))