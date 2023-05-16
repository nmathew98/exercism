(ns isogram
  (:require [clojure.string :as str]))

(defn isogram? [word]
  (every? #(= % 1) (map val (frequencies (filter #(Character/isLetter %) (str/lower-case word))))))
