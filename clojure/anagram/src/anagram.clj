(ns anagram
  (:require [clojure.string :as str]))

(defn anagram? [word prospect]
  (and 
   (not= (str/lower-case word) (str/lower-case prospect))
   (= (frequencies (str/lower-case prospect)) (frequencies (str/lower-case word)))))

(defn anagrams-for [word prospect-list] ;; <- arglist goes here
  (filter (partial anagram? word) prospect-list))
