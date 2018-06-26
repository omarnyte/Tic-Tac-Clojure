(ns tic-tac-clojure.player
  (:gen-class)
  (:require [tic-tac-clojure.ai :refer :all]
            [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.cli :refer :all]
            [tic-tac-clojure.game-logic :refer :all]
            [tic-tac-clojure.message-render :refer :all]))

(defn get-player-mark
  [player]
  (:mark player))

(defn- receive-board-idx-input 
  [board]
  (let [starting-idx 0 
        ending-idx (- (count board) 1)
        selection (get-valid-num-input starting-idx ending-idx)]
    (if (valid-move? board selection)
        selection
        (do (print-to-cli (generate-invalid-move-message selection))
            (recur board)))))
  
(defn- allow-human-move
  [board mark]
    (print-to-cli (generate-move-selection-prompt mark))
    (let [idx (receive-board-idx-input board)]
      (mark-board board idx mark)))
  
(defprotocol Player
  (take-turn [this board]))

(defrecord Human [mark]
  Player
  (take-turn [this board] (allow-human-move board (:mark this))))

(defrecord AI [mark]
  Player
  (take-turn [this board] 
    (let [idx (choose-best-space board (:mark this))]
      (print-to-cli (generate-ai-choice-message idx))
      (mark-board board 
                  idx
                  (:mark this)))))

(defn create-proto-player
  [mark player-type]
  (case player-type 
    "human" (Human. mark)
    "ai" (AI. mark)))