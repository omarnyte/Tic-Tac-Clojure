(ns tic-tac-clojure.player
  (:gen-class)
  (:require [tic-tac-clojure.ai :refer :all]
            [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.cli :refer :all]
            [tic-tac-clojure.game-logic :refer :all]
            [tic-tac-clojure.message-render :refer :all]
            [tic-tac-clojure.cli :refer :all]))

(defn get-player-mark
  [player]
  (:mark player))

(defn is-human?
  [player]
  (:human? player))

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
  [board mark]
    (print-to-cli (generate-move-selection-prompt mark))
    (let [idx (receive-board-idx-input board)]
      (mark-board board idx mark)))

(defn allow-ai-move
  [board player]
  (let [idx (choose-best-space board)]
    (print-to-cli (generate-ai-choice-message idx))
    (mark-board board 
                idx
                (get-player-mark player))))
  
(defprotocol Player
  (get-player-mark [this])
  (take-turn [this board]))

(defrecord Human [mark human?]
  Player
  (get-player-mark [this] (:mark this))
  (take-turn [this board] (allow-human-move board (:mark this))))

(defrecord AI [mark human?]
  Player
  (get-player-mark [this] (:mark this))
  (take-turn [this board] (allow-ai-move board this)))

(defn create-proto-player
  [mark human?]
  (case human? 
    true (Human. mark true)
    false (AI. mark false)))