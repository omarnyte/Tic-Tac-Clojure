(ns tic-tac-clojure.gameplay-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.gameplay :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]))

(def human-x-player
  {:mark "X" 
    :human? true})

(def human-o-player
  {:mark "O" 
    :human? true})

(def ai-o-player
  {:mark "O" 
    :human? false})

(deftest valid-game-selection-test
  (is (= true (valid-game-selection? 1)))
  (is (= true (valid-game-selection? 2)))
  (is (= false (valid-game-selection? 3))))