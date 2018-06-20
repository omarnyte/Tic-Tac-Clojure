(ns tic-tac-clojure.gameplay-test
  (:require [clojure.string :as string]
            [clojure.test :refer :all]
            [tic-tac-clojure.gameplay :refer :all]
            [tic-tac-clojure.sample-boards :refer :all]))

(def human-v-human-str "1\n")
(def x-win-str "0\n1\n4\n2\n8\n")
(def o-win-str "4\n0\n6\n1\n8\n2\n")
(def exit-str "0\n")
(def restart-str "1\n")
           
(deftest start-tic-tac-toe-test 
  (testing "Game exits with 'Thank you for playing!' if the user chooses to exit"
    (is (string/includes? (with-out-str (with-in-str (str human-v-human-str 
                                                          x-win-str
                                                          exit-str) 
                                                     (start-tic-tac-toe)))
                          "Thank you for playing!")))
    (is (string/includes? (with-out-str (with-in-str (str human-v-human-str 
                                                          x-win-str
                                                          restart-str
                                                          human-v-human-str
                                                          o-win-str
                                                          exit-str) 
                                                     (start-tic-tac-toe)))
                          "O wins!")))
