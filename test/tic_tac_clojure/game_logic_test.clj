(ns tic-tac-clojure.game-logic-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]
            [tic-tac-clojure.game-logic :refer :all]))

(deftest in-range-test
  (is (= true (in-range? 0 8 0)))
  (is (= true (in-range? 0 8 4)))
  (is (= true (in-range? 0 8 8)))
  (is (= false (in-range? 0 8 9))))

(deftest valid-move-test
  (is (= true (valid-move? empty-board 0)))
  (is (= false (valid-move? one-mark-board 0)))
  (is (= false (valid-move? one-mark-board 9))))
            
(deftest tie-test
  (is (= true (tie? tied-board)))
  (is (= false (tie? empty-board)))
  (is (= false (tie? x-victory-board)))
  (is (= false (tie? o-victory-board))))

(deftest game-over-test
  (is (= true (game-over? tied-board)))
  (is (= true (game-over? x-victory-board)))
  (is (= true (game-over? o-victory-board)))
  (is (= false (game-over? empty-board))))
    