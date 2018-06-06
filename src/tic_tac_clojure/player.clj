(ns tic-tac-clojure.player
  (:gen-class))

(defn create-player
  [mark]
  {:mark mark})

(defn get-player-mark
  [player]
  (:mark player))