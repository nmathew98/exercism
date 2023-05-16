(ns wordy
  (:require [clojure.string :as str]))

(defn plus [a b] (+ a b))

(defn minus [a b] (- a b))

(defn multiplied [a b] (* a b))

(defn divided [a b] (/ a b))

(def ops {"plus" plus "minus" minus "multiplied" multiplied "divided" divided})

(defn infix
  ([a op b] ((get ops op) (Integer/parseInt a) (Integer/parseInt b)))
  ([a op b & rest] (let [first-part-evaluated (infix a op b)]
                     (if (>= (count rest) 2)
                       (recur (str first-part-evaluated) (first rest) (second rest) (drop 2 rest))
                       first-part-evaluated))))

(defn parse-instructions [s]
  (str/split (str/trim (str/replace s #"What is |by |\?" "")) #" "))

(defn evaluate [s]
  (try
    (apply infix (apply list (parse-instructions s)))
    (catch Exception ex
      (throw (IllegalArgumentException. "Illegal arguments")))))