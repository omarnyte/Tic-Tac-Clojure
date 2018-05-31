(ns tic-tac-clojure.gameplay-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.gameplay :refer :all]
            [tic-tac-clojure.render :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]))

(deftest valid-move-test
  (is (= true (valid-move? empty-board 0)))
  (is (= false (valid-move? one-mark-board 0)))
  (is (= false (valid-move? one-mark-board 9)))
  (is (= false (valid-move? one-mark-board "not a number"))))

(deftest switch-player-test
  (is (= "O" (switch-player "X"))))
  (is (= "X" (switch-player "O")))
            
; (deftest make-move-test
;   (is (= invalid-move-message (with-out-str (make-move one-mark-board 0 "X")))))            
            
; (deftest start-game-test
;   ; (is (= "Game isn't over!" (start-game empty-board)))
;   (is (= game-over-message (start-game tied-board)))
;   (is (= game-over-message (start-game x-victory-board)))
