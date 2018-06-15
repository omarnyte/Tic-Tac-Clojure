(ns tic-tac-clojure.validators
  (:gen-class)
  (:require [tic-tac-clojure.utils :refer :all]))

(defn is-number?
  [str]
  (do
    (try (convert-to-num str) 
          true
          (catch Exception e false))))
  
(defn in-range?
  [start end val]
  (and (>= val start) (<= val end)))
