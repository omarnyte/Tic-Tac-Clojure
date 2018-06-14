(ns tic-tac-clojure.message-render-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.message-render :refer :all]))

(deftest generate-winner-message-test
  (is (= "X wins!" (generate-winner-message "X")))
  (is (= "O wins!" (generate-winner-message "O"))))

(deftest generate-move-selection-prompt-test
  (is (= "It's your turn, X.\nPlease choose an index to mark your move: " (generate-move-selection-prompt "X")))
  (is (= "It's your turn, O.\nPlease choose an index to mark your move: " (generate-move-selection-prompt "O"))))