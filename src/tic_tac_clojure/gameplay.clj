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

(defn valid-move? 
  [board idx]
  (and (number? idx)
        (< idx 8)
        (>= idx 0)
        (empty-space? board idx)))

(defn switch-player
  [current-player]
  (if (= current-player "X")
    "O"
    "X"))

; (defn make-move
;   [board idx mark]
;   (if (empty-space? board idx)
;     (do 
;       (render-board (mark-board board idx mark)))
;     (print invalid-move-message)  
;   ))

; (defn play-round
;   [board]
;   (if (game-over? board)
;       (print game-over-message))
;       (do ()
;           ()))

; (defn start-game
;   ([] (start-game (generate-empty-board)))
;   ([board] (if (game-over? board)
;               (str game-over-message)
;               (str "Game isn't over!"))))