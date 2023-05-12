(ns pangram
  (:require [clojure.string :as str]))

(def english-letters (map char (range 97 123)))

(defn normalize-sentence [sentence]
  (str/lower-case (str/replace sentence #"\W" "")))

(defn pangram? [sentence]
  (every? (partial contains? (frequencies (normalize-sentence sentence))) english-letters))