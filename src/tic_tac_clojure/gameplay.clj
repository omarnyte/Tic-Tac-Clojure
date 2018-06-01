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

(defn is-number?
  [str]
  (do
    (try (Integer/parseInt str) 
         true
         (catch Exception e false))))

(defn convert-to-num
  [str]
  (Integer/parseInt str)) 

(defn valid-move? 
  [board selection]
    (and (is-number? selection)
          (let [idx (convert-to-num selection)]
            (and 
              (< idx 8)
              (>= idx 0)
              (empty-space? board idx)))))

(defn switch-player
  [current-player]
  (if (= current-player "X")
    "O"
    "X"))

(defn make-move
  [board idx mark]
  (let [marked-board board]
    (render-board (mark-board board idx mark))
    marked-board))

(defn take-turn
  [board current-player]
  (let [selected-idx (clojure.string/trim-newline (read-line))]
    (if (valid-move? board selected-idx)
      (make-move board (convert-to-num selected-idx) current-player)
      (print invalid-move-message))))

(defn play-round
  [board current-player]
  (if (game-over? board)
      (print game-over-message)
      (do 
        (render-board board)
        (println "It's your turn, " current-player)
        (let [updated-board (take-turn board current-player)]
          (recur updated-board  
                 (switch-player current-player))))))

(defn start-game
  []
  (play-round (generate-empty-board) "X"))


  