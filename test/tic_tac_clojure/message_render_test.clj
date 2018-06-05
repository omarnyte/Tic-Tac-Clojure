(ns tic-tac-clojure.gameplay-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.message-render :refer :all]))

(deftest winner-message-test
  (is (= "X wins!" (generate-winner-message "X")))
  (is (= "O wins!" (generate-winner-message "O"))))