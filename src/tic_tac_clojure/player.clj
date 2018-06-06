(ns tic-tac-clojure.gameplay
  (:gen-class))

(defn create-player
  [mark]
  {:mark mark})