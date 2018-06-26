(ns tic-tac-clojure.cli
  (:gen-class)
  (:require [tic-tac-clojure.message-render :refer :all]
            [tic-tac-clojure.utils :refer :all]
            [tic-tac-clojure.validators :refer :all]))

(defn print-to-cli
  [message]
  (println (str message)))
            
(defn extract-numeric-input
  []
  (let [input (read-line)]
  (if (is-number? input)
      (convert-to-num input)
      (do (print-to-cli not-a-number-message)
          (recur)))))    
            
(defn get-valid-num-input 
  [min max]
  (let [num (extract-numeric-input)]
    (if (in-range? min max num) 
        num 
        (do (print-to-cli (generate-invalid-range-message min max))
            (recur min max)))))