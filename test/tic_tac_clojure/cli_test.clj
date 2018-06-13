(ns tic-tac-clojure.cli-test
  (:require [clojure.test :refer :all]
            [tic-tac-clojure.cli :refer :all]
            [tic-tac-clojure.message-render :refer :all]))

(deftest print-to-cli-test
  (is (= "Hello, world!\n" (with-out-str (print-to-cli "Hello, world!")))))

(deftest extract-numeric-input-test
  (is (= 0 (with-in-str "0" (extract-numeric-input)))))