(ns tic-tac-clojure.render-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]
            [tic-tac-clojure.render :refer :all]))

(deftest convert-nils-to-spaces-test
  (is (= [" " " " " "] (convert-nils-to-spaces [nil nil nil])))
  (is (= ["X" " " "X"] (convert-nils-to-spaces ["X" nil "X"])))) 
 
(deftest fill-row-test
  (is (= "   |   |   " (fill-row [" " " " " "])))
  (is (= " X | X | O " (fill-row ["X" "X" "O"])))
  (is (= " X |   | O " (fill-row ["X" " " "O"])))) 

(deftest render-row-test
  (is (= "   |   |   " (render-row [nil nil nil])))
  (is (= " X |   | O " (render-row ["X" nil "O"]))))

(deftest print-to-cli-test
  (is (= "Hello, world!\n" (with-out-str (print-to-cli "Hello, world!")))))
  
(deftest divide-board-into-rows-test
  (is (= divided-empty-board (divide-board-into-rows empty-board)))
  (is (= divided-one-mark-board (divide-board-into-rows one-mark-board)))
  (is (= divided-tied-board (divide-board-into-rows tied-board))))

(deftest render-board-test 
  (is (= rendered-empty-board (with-out-str (render-board empty-board))))
  (is (= rendered-x-victory-board (with-out-str (render-board x-victory-board))))
  (is (= rendered-o-victory-board (with-out-str (render-board o-victory-board))))
  (is (= rendered-tied-board (with-out-str (render-board tied-board)))))