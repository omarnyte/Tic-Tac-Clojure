(ns tic-tac-clojure.gameplay
  (:gen-class)
  (:require [tic-tac-clojure.board :refer :all])
  (:require [tic-tac-clojure.board-render :refer :all])
  (:require [tic-tac-clojure.game-logic :refer :all])
  (:require [tic-tac-clojure.message-render :refer :all]))

(defn convert-to-num
  [str]
  (Integer/parseInt str))
    
(defn is-number?
  [str]
  (do
    (try (Integer/parseInt str) 
         true
         (catch Exception e false))))
    
(defn in-range?
  [start end val]
  (and (>= val start) (<= val end)))

(defn valid-move?
  [board num]
  (and  (in-range? 0 8 num)
        (empty-space? board num)))

(defn valid-selection?
  [board str]
  (and (is-number? str) 
       (valid-move? board
                    (convert-to-num str))))
        
(defn handle-game-over
  [board previous-player]
  (if (tie? board)
    (print-to-cli tied-game-message))
    (print-to-cli (generate-winner-message previous-player)))
  
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
  [board current-player]
  (render-board board)
  (if (game-over? board)
      (handle-game-over board (switch-player current-player))
      (do (print-to-cli (generate-move-selection-prompt current-player))
          (recur (take-turn board current-player)
                 (switch-player current-player)))))

(defn start-game
  []
  (play-round (generate-empty-board) "X"))
