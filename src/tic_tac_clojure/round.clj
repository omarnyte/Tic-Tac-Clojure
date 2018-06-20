(ns tic-tac-clojure.round
  (:gen-class)
  (:require [tic-tac-clojure.board-render :refer :all]
            [tic-tac-clojure.cli :refer :all]
            [tic-tac-clojure.game-logic :refer :all]
            [tic-tac-clojure.message-render :refer :all]
            [tic-tac-clojure.player :refer :all]))
        
(defn- handle-game-over
  [board previous-player]
  (if (tie? board)
    tied-game-message
    (generate-winner-message (get-player-mark previous-player))))
    
(defn play-round
  [board curr-player opp-player]
  (render-board board)
  (if (game-over? board)
      (handle-game-over board opp-player)    
      (recur (take-turn curr-player board)
              opp-player
              curr-player)))