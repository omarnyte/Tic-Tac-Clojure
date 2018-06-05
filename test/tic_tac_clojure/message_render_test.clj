(ns tic-tac-clojure.gameplay-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.message-render :refer :all]))

(deftest print-to-cli-test
  (is (= "Hello, world!\n" (with-out-str (print-to-cli "Hello, world!")))))

(deftest generate-winner-message-test
  (is (= "X wins!" (generate-winner-message "X")))
  (is (= "O wins!" (generate-winner-message "O"))))

(deftest generate-move-selection-prompt-test
  (is (= "It's your turn, X." (generate-move-selection-prompt "X")))
  (is (= "It's your turn, O." (generate-move-selection-prompt "O"))))