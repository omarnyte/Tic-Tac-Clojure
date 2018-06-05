(ns tic-tac-clojure.message-render
  (:gen-class))
  
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
  (do (print-to-cli (str "It's your turn," current-player "."))
      (print-to-cli selection-prompt)))

    