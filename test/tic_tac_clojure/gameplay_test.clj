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

; (deftest convert-to-num-test
;   (is (= 0 (convert-to-num "0"))))

; (deftest is-number-test
;   (is (= true (is-number? "0")))
;   (is (= false (is-number? "a"))))
            
(deftest valid-game-selection-test
  (is (= true (valid-game-selection? "1")))
  (is (= true (valid-game-selection? "2")))
  (is (= false (valid-game-selection? "5"))))