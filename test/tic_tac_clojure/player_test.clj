(ns tic-tac-clojure.console-io-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.player :refer :all]))
(def player
  {:mark "O"})

(deftest create-player-test
  (is = player (create-player "O")))