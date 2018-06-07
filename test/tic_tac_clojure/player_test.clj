(ns tic-tac-clojure.player-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.player :refer :all]))
(def human-player
  {:mark "X" 
   :human? true})

(def ai-player
  {:mark "O" 
   :human? false})

(deftest create-player-test
  (is (= human-player (create-player "X" true)))
  (is (= ai-player (create-player "O" false))))

(deftest get-player-mark-test
  (is (= "X" (get-player-mark human-player)))
  (is (= "O" (get-player-mark ai-player))))

(deftest is-human-test
  (is (= true (is-human? human-player)))
  (is (= false (is-human? ai-player))))

(deftest switch-players-test
  (is (= [ai-player human-player] (switch-players human-player ai-player))))