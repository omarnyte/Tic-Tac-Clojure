(ns tic-tac-clojure.render-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]
            [tic-tac-clojure.render :refer :all]))

(deftest convert-nils-to-spaces-test
  (is (= [" " " " " "] (convert-nils-to-spaces [nil nil nil])))) 
 
(deftest fill-row-test
  (is (= "   |   |   \n" (fill-row [nil nil nil])))
  (is (= " X | X | O \n" (fill-row ["X" "X" "O"])))
  (is (= " X |   | O \n" (fill-row ["X" nil "O"])))) 

(deftest render-board-test 
  (is (= rendered-empty-board (render-board empty-board)))
  (is (= rendered-x-victory-board (render-board x-victory-board)))
  (is (= rendered-o-victory-board (render-board o-victory-board)))
  (is (= rendered-tied-board (render-board tied-board))))