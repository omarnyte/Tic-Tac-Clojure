(ns tic-tac-clojure.player-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.player :refer :all]))
(def player-1
  {:mark "X"})

(def player-2
  {:mark "O"})

(deftest create-player-test
  (is (= player-1 (create-player "X")))
  (is (= player-2 (create-player "O"))))

(deftest get-player-mark-test
  (is (= "X" (get-player-mark player-1)))
  (is (= "O" (get-player-mark player-2))))
