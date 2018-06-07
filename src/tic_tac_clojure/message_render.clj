(ns tic-tac-clojure.message-render
  (:gen-class))

(def game-selection-prompt
  (str "Please type one of the options below to get started.
       1 - Play against another human player
       2 - Play against the computer"))

(def selection-prompt
  (str "Please choose an index to mark your move: "))

(def invalid-move-message
  (str "That move isn't valid. Please select another move: "))

(def tied-game-message
  (str "It's a tie!"))
  
(defn generate-winner-message
  [winner]
  (str winner " wins!"))

(defn print-to-cli
  [message]
  (println (str message)))

(defn generate-move-selection-prompt
  [current-player]
  (str "It's your turn, " current-player ".\n" selection-prompt))

    