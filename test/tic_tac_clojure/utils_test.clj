(ns tic-tac-clojure.utils-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.utils :refer :all]))

(deftest convert-to-num-test
  (is (= 0 (convert-to-num "0")))
  (is (= 10 (convert-to-num "10"))))
            