(ns tic-tac-clojure.core
  (:gen-class)
  (:require [tic-tac-clojure.board :as board]))

(defn -main
  []
  (board/create-empty-board))