(ns tic-tac-clojure.message-render
  (:gen-class))

(def invalid-move-message
  (str "That move isn't valid. Please select another move: "))

(def selection-prompt
  (str "Please choose an index to mark your move: "))

(def game-over-message
  (str "Game over!"))

(defn generate-winner-message
  [winner]
  (str winner " wins!"))