(ns tic-tac-clojure.render-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]
            [tic-tac-clojure.render :refer :all]))

(def rendered-empty-board
  "   |   |   \n----------\n   |   |   \n----------\n   |   |   \n")
  
(def rendered-tied-board
  " X | X | O \n----------\n O | O | X \n----------\n X | O | X \n")

(def rendered-x-victory-board
  " X | O | O \n----------\n   | X | O \n----------\n   |   | X \n")

(def rendered-o-victory-board
  " O | O | O \n----------\n   | X | O \n----------\n X |   | X \n")

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