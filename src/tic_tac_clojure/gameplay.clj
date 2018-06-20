(ns tic-tac-clojure.gameplay
  (:gen-class)
  (:require [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.cli :refer :all]
            [tic-tac-clojure.message-render :refer :all]
            [tic-tac-clojure.player :refer :all]
            [tic-tac-clojure.round :refer :all]))

(def standard-board-length 9)

(def players { 1 [{:marker "X" :type "human"} {:marker "O" :type "human"}]
               2 [{:marker "X" :type "human"} {:marker "O" :type "ai"}] 
               3 [{:marker "X" :type "ai"} {:marker "O" :type "ai"}] })
            
(defn- begin-selected-game
  [num]
  (let [player-1 (first (get players num))
        player-2 (last (get players num))]
  (print-to-cli (play-round (generate-empty-board standard-board-length) 
                (create-proto-player (:marker player-1) (:type player-1))
                (create-proto-player (:marker player-2) (:type player-2))))))

(declare start-tic-tac-toe)
            
(defn- handle-end-of-game
  []
  (print-to-cli play-again-prompt)
  (let [num-for-no 0 num-for-yes 1]
  (case (get-valid-num-input num-for-no num-for-yes)
    0 (print-to-cli thank-you-message)
    1 (start-tic-tac-toe))))
            
(defn start-tic-tac-toe
  []
  (print-to-cli game-selection-prompt)
  (let [min (apply min (keys players))
        max (apply max (keys players))]
    (begin-selected-game (get-valid-num-input min max))
    (handle-end-of-game)))
