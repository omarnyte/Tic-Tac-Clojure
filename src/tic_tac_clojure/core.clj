(ns tic-tac-clojure.core
  (:gen-class)
  (:require [tic-tac-clojure.gameplay :as gameplay]))

(defn -main
  []
  (gameplay/start-tic-tac-toe))