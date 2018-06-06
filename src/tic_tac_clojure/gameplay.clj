(ns tic-tac-clojure.gameplay
  (:gen-class)
  (:require [tic-tac-clojure.board :refer :all])
  (:require [tic-tac-clojure.board-render :refer :all])
  (:require [tic-tac-clojure.game-logic :refer :all])
  (:require [tic-tac-clojure.message-render :refer :all])
  (:require [tic-tac-clojure.player :refer :all]))

(defn convert-to-num
  [str]
  (Integer/parseInt str))
    
(defn is-number?
  [str]
  (do
    (try (convert-to-num str) 
         true
         (catch Exception e false))))

(defn valid-selection?
  [board str]
  (and (is-number? str) 
       (valid-move? board
                    (convert-to-num str))))
        
(defn handle-game-over
  [board previous-player]
  (if (tie? board)
    (print-to-cli tied-game-message)
    (print-to-cli (generate-winner-message previous-player))))
  
(defn switch-player
  [current-player]
  (if (= "X" current-player)
      "O"
      "X"))

(defn take-turn 
  [board current-player]
  (let [selection (read-line)]
    (if (valid-selection? board selection)
        (mark-board board 
                    (convert-to-num selection) 
                    current-player)
        (do (print-to-cli invalid-move-message)
            (recur board current-player)))))
    
(defn play-round
  [board curr-player opp-player]
  (render-board board)
  (if (game-over? board)
      (print-to-cli "Game is over!")
      ; (handle-game-over board (switch-players curr-player))
      (do (print-to-cli (generate-move-selection-prompt (get-player-mark curr-player)))
          (recur (take-turn board (get-player-mark curr-player))
                  opp-player
                  curr-player))))

(defn valid-game-selection?
  [str]
  (and (is-number? str) 
        (in-range? 1 2 (convert-to-num str))))

; (defn start-selected-game
;   [num]
;   (case num
;     1 (play-round (generate-empty-board) "X")
;     2 (play-against)))
                 
(defn start-game
  []
  (print-to-cli game-selection-prompt)
  (let [selection (read-line)]
    (if (is-number? selection)
      (let [num (convert-to-num selection)]
        (case num 
              1 (play-round (generate-empty-board) 
                            (create-player "X")
                            (create-player "O"))
              2 (print-to-cli "Let's play against AI!"))
              (print-to-cli "That's not a number!")))))
        
