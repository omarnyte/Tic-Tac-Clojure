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

(defn valid-selection?
  [board num]
  (and  (in-range? 0 8 num)
        (empty-space? board num)))
        
(defn take-turn 
  [board current-player]
  (let [selection (read-line)]
    (if (and (is-number? selection)
             (valid-selection? board (convert-to-num selection)))
      (mark-board board (convert-to-num selection) current-player)
      (do (println invalid-move-message)
          (recur board current-player)))))

(defn switch-player
  [current-player]
  (if (= "X" current-player)
      "O"
      "X"))
        
(defn play-round
  [board current-player]
  (if (game-over? board)
    (println game-over-message)
    (do 
      (render-board board)
      (println "It's your turn," current-player)
      (println selection-prompt)))
      (recur (take-turn board current-player)
             (switch-player current-player)))

(defn start-game
  []
  (play-round (generate-empty-board) "X"))
