(ns tic-tac-clojure.round-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.player :refer :all]
            [tic-tac-clojure.round :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]))
            
(def human-x-player
  (->Human "X"))

(def human-o-player
  (->Human "O"))
            
; (deftest play-round-test
;   (is (= (str rendered-x-victory-board "X wins!\n") 
;               (with-out-str (play-round x-victory-board human-o-player human-x-player))))
;   (is (= (str rendered-o-victory-board "O wins!\n") 
;               (with-out-str (play-round o-victory-board human-x-player human-o-player))))
;   (is (= (str rendered-tied-board "It's a tie!\n") 
;               (with-out-str (play-round tied-board human-x-player human-o-player))))
;   (is (= (str rendered-near-x-victory-board 
;               "It's your turn, X.\nPlease choose an index to mark your move: \n"
;               rendered-x-victory-board 
;               "X wins!\n")
;          (with-in-str "0" (with-out-str (play-round near-x-victory-board 
;                                                     human-x-player 
;                                                     human-o-player))))))
