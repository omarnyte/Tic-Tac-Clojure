(ns tic-tac-clojure.message-render
  (:gen-class))

(def game-selection-prompt
  (str "Please type one of the options below to get started.
       1 - Play against another human player
       2 - Play against the computer"))

(def board-idx-selection-prompt
  (str "Please choose an index to mark your move: "))

(def invalid-game-type-message
  (str "That selection isn't valid. Please select another game type: "))
  
(def not-a-number-message
  (str "That is not a number. Please type a number: "))
  
(def tied-game-message
  (str "It's a tie!"))
  
(defn generate-winner-message
  [winner]
  (str winner " wins!"))
  
(defn generate-move-selection-prompt
  [current-player]
  (str "It's your turn, " current-player ".\n" board-idx-selection-prompt))

(defn generate-invalid-move-message
  [num]
  (str num " isn't a valid move. Please select another move: "))

(defn generate-ai-choice-message
  [idx]
  (str "The computer chose space #" idx ".\n"))