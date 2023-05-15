(ns bob
  (:require [clojure.string :as str]))

(defn is-yelling [s]
  (and
   (not (str/blank? s))
   (some #(Character/isLetter %) s)
   (every? #(Character/isUpperCase %) (filter #(Character/isLetter %) s))))

(defn is-question [s] (str/ends-with? s "?"))

(defn response-for [s] ;; <- arglist goes here
  (let [trimmed-s (str/trim s)]
    (cond
      (and (is-question trimmed-s) (not (is-yelling trimmed-s))) "Sure."
      (and (not (is-question trimmed-s)) (is-yelling trimmed-s)) "Whoa, chill out!"
      (and (is-question trimmed-s) (is-yelling trimmed-s)) "Calm down, I know what I'm doing!"
      (str/blank? trimmed-s) "Fine. Be that way!"
      :else "Whatever.")))
