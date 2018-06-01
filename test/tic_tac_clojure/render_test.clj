(ns tic-tac-clojure.render-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]
            [tic-tac-clojure.render :refer :all]))

(deftest convert-nils-to-spaces-test
  (is (= [" " " " " "] (convert-nils-to-spaces [nil nil nil])))
  (is (= ["X" " " "X"] (convert-nils-to-spaces ["X" nil "X"])))) 
 
(deftest fill-row-test
  (is (= "   |   |   \n" (fill-row [" " " " " "])))
  (is (= " X | X | O \n" (fill-row ["X" "X" "O"])))
  (is (= " X |   | O \n" (fill-row ["X" " " "O"])))) 

; (deftest render-board-test 
;   (is (= rendered-empty-board (with-out-str (render-board empty-board))))
;   (is (= rendered-x-victory-board (with-out-str (render-board x-victory-board))))
;   (is (= rendered-o-victory-board (with-out-str (render-board o-victory-board))))
;   (is (= rendered-tied-board (with-out-str (render-board tied-board)))))


  