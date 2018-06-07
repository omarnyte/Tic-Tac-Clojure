(ns tic-tac-clojure.gameplay
  (:gen-class)
  (:require [tic-tac-clojure.ai :refer :all]
            [tic-tac-clojure.board :refer :all]
            [tic-tac-clojure.board-render :refer :all]
            [tic-tac-clojure.game-logic :refer :all]
            [tic-tac-clojure.message-render :refer :all]
            [tic-tac-clojure.player :refer :all]
            [tic-tac-clojure.round :refer :all]))

; (defn convert-to-num
;   [str]
;   (Integer/parseInt str))
    
; (defn is-number?
;   [str]
;   (do
;     (try (convert-to-num str) 
;          true
;          (catch Exception e false))))

(defn valid-game-selection?
  [str]
  (and (is-number? str) 
       (in-range? 1 2 (convert-to-num str))))
                 
(defn begin-selected-game
  [num]
  (case num 
    1 (play-round (generate-empty-board) 
                  (create-player "X" true)
                  (create-player "O" true))
    2 (play-round (generate-empty-board)
                  (create-player "X" true)
                  (create-player "O" false))))
        
(defn start-tic-tac-toe
  []
  (print-to-cli game-selection-prompt)
  (let [selection (read-line)]
    (if (is-number? selection)
      (let [num (convert-to-num selection)]
        (begin-selected-game num)))))