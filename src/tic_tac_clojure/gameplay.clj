(ns tic-tac-clojure.gameplay
    (:gen-class)
    (:require [tic-tac-clojure.board :refer :all])
    (:require [tic-tac-clojure.game-logic :refer :all])
    (:require [tic-tac-clojure.render :refer :all]))
  
(def invalid-move-message
  (str "That move isn't valid. Please select another move: "))

(def selection-prompt
  (str "Please choose an index to mark your move: "))

(def game-over-message
  (str "Game over!"))

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
        
(defn take-turn 
  [board current-player]
  (let [selection (read-line)]
    (if (valid-selection? board selection)
        (mark-board board 
                    (convert-to-num selection) 
                    current-player)
        (do (print-to-cli invalid-move-message)
            (recur board current-player)))))

(defn switch-player
  [current-player]
  (if (= "X" current-player)
      "O"
      "X"))
      
(defn generate-winner-message
  [winner]
  (str (switch-player winner) " wins!"))
      
(defn generate-game-over-message
  [board current-player]
  (if (tie? board)
      (str "It's a tied game!")
      (generate-winner-message current-player)))

(defn generate-move-selection-prompt
  [current-player]
  (do (print-to-cli (str "It's your turn," current-player "."))
      (print-to-cli selection-prompt)))
    
(defn play-round
  [board current-player]
  (render-board board)
  (if (game-over? board)
      (print-to-cli (generate-game-over-message board current-player))
      (do (print-to-cli (generate-move-selection-prompt current-player))
          (recur (take-turn board current-player)
                 (switch-player current-player)))))

(defn start-game
  []
  (play-round (generate-empty-board) "X"))
