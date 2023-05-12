(ns acronym
  (:require [clojure.string :as str]))

(defn normalize-phrase [phrase]
  (str/replace phrase #":.*" ""))

(defn capitalize-first-letter [words]
  (map #(format "%s%s" (str/upper-case (first %)) (apply str (rest %))) words))

(defn take-capital-letters [words]
  (mapcat (partial filter #(Character/isUpperCase %)) words))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (cond
    (seq phrase) (apply str (take-capital-letters (capitalize-first-letter (str/split (normalize-phrase phrase) #"[\s-]"))))
    :else ""))
