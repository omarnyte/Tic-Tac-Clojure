(ns tic-tac-clojure.gameplay
  (:gen-class)
  (:require [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.cli :refer :all]
            [tic-tac-clojure.message-render :refer :all]
            [tic-tac-clojure.player :refer :all]
            [tic-tac-clojure.round :refer :all]))

(def standard-board-length 9)

(def players { 1 [{:marker "X" :type "human"} {:marker "O" :type "human"}]
               2 [{:marker "X" :type "human"} {:marker "O" :type "ai"}] })
            
(defn- begin-selected-game
  [num]
  (let [player-1 (first (get players num))
        player-2 (last (get players num))]
  (play-round (generate-empty-board standard-board-length) 
              (create-proto-player (:marker player-1) (:type player-1))
              (create-proto-player (:marker player-2) (:type player-2)))))

(defn start-tic-tac-toe
  []
  (print-to-cli game-selection-prompt)
  (let [min (apply min (keys players))
        max (apply max (keys players))]
    (begin-selected-game (get-valid-num-input min max))
    (print-to-cli play-again-prompt)
    (case (get-valid-num-input 0 1)
      0 (print-to-cli thank-you-message)
      1 (recur))))
