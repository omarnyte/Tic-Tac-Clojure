(ns tic-tac-clojure.player
  (:gen-class))

(defn create-player
  [mark human?]
  {:mark mark 
   :human? human?})

(defn get-player-mark
  [player]
  (:mark player))

(defn is-human?
  [player]
  (:human? player))

(defn switch-players
  [player-1 player-2]
  [player-2 player-1])