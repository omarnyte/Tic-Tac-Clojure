(ns tic-tac-clojure.board-render-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.board-render :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]))

(deftest render-board-test 
  (is (= rendered-empty-board (with-out-str (render-board empty-board))))
  (is (= rendered-x-victory-board (with-out-str (render-board x-victory-board))))
  (is (= rendered-o-victory-board (with-out-str (render-board o-victory-board))))
  (is (= rendered-tied-board (with-out-str (render-board tied-board)))))