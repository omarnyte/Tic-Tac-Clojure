(ns tic-tac-clojure.validators
  (:gen-class))

(defn in-range?
  [start end val]
  (and (>= val start) (<= val end)))

(defn valid-numeric-selection? 
  [min max num]
  (in-range? min max num))