(ns tic-tac-clojure.round-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.player :refer :all]
            [tic-tac-clojure.round :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]))
            
(def human-x-player
  (->Human "X"))

(def human-o-player
  (->Human "O"))
            
(deftest play-round-test 
  (testing "it declares the correct winner if there is one"
    (is (= "X wins!" 
            (with-in-str "0\n1\n4\n2\n8\n" 
                        (play-round empty-board human-x-player human-o-player))))
    (is (= "O wins!" 
            (with-in-str "4\n0\n6\n1\n8\n2\n" 
                        (play-round empty-board human-x-player human-o-player)))))
  (testing "it announces a tie if there is one"
    (is (= "It's a tie!" 
            (with-in-str "0\n2\n1\n3\n5\n4\n6\n7\n8\n"
                        (play-round empty-board human-x-player human-o-player))))))