(ns tic-tac-clojure.gameplay
  (:gen-class)
  (:require [tic-tac-clojure.ai :refer :all]
            [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.board-render :refer :all]
            [tic-tac-clojure.game-logic :refer :all]
            [tic-tac-clojure.message-render :refer :all]
            [tic-tac-clojure.player :refer :all]))

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
    (print-to-cli (generate-winner-message 
                  (get-player-mark previous-player)))))
  
(defn switch-player
  [current-player]
  (if (= "X" current-player)
      "O"
      "X"))

(defn take-turn 
  [board current-player]
  (if (is-human? current-player)
      (let [selection (read-line)]
        (if (valid-selection? board selection)
            (mark-board board 
                        (convert-to-num selection) 
                        (get-player-mark current-player))
            (do (print-to-cli invalid-move-message)
                (recur board current-player))))
      (mark-board board 
                  (choose-random-empty-space board)
                  (get-player-mark current-player))))
    
(defn play-round
  [board curr-player opp-player]
  (render-board board)
  (if (game-over? board)
      (handle-game-over board opp-player)
      (do (print-to-cli (generate-move-selection-prompt (get-player-mark curr-player)))
          (recur (take-turn board curr-player)
                  opp-player
                  curr-player))))

(defn valid-game-selection?
  [str]
  (and (is-number? str) 
        (in-range? 1 2 (convert-to-num str))))
                 
(defn start-game
  []
  (print-to-cli game-selection-prompt)
  (let [selection (read-line)]
    (if (is-number? selection)
      (let [num (convert-to-num selection)]
        (case num 
              1 (play-round (generate-empty-board) 
                            (create-player "X" true)
                            (create-player "O" true))
              2 (play-round (generate-empty-board)
                            (create-player "X" true)
                            (create-player "O" false)))))))
        

; (defn take-turn 
;   [board current-player]
;   (if (is-human? current-player)
;       (let [selection (read-line)]
;         (if (valid-selection? board selection)
;             (mark-board board 
;                         (convert-to-num selection) 
;                         (get-player-mark current-player)
;             (do (print-to-cli invalid-move-message)
;                 (take-turn board current-player)))))
;       (mark-board board 
;                   (choose-random-empty-space board)
;                   (get-player-mark current-player))))