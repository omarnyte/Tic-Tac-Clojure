(ns tic-tac-clojure.cli
  (:gen-class)
  (:require [tic-tac-clojure.message-render :refer :all]))

(defn convert-to-num
  [str]
  (Integer/parseInt str))
    
(defn is-number?
  [str]
  (do
    (try (convert-to-num str) 
          true
          (catch Exception e false))))

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