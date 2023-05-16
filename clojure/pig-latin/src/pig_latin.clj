(ns pig-latin
  (:require [clojure.string :as str]))

(defn rule-1? [word]
  (or (str/starts-with? word "a")
      (str/starts-with? word "e")
      (str/starts-with? word "i")
      (str/starts-with? word "o")
      (str/starts-with? word "u")
      (str/starts-with? word "xr")
      (str/starts-with? word "yt")))

(defn rule-2? [word] (not (rule-1? word)))

(defn rule-3? [word] (and (rule-2? word) (re-find #"\w*qu" word)))

(defn rule-4? [word]
  (if (= (count word) 2)
    (= (nth word 1) \y)
    (re-find #"[^aeiou]\w*y\w+" word)))

(defn phrase? [phrase]
  (str/includes? (str/trim phrase) " "))

(defn translate [word]
  (cond
    (phrase? word) (apply str (interpose " " (map translate (str/split (str/trim word) #" "))))
    (rule-4? word) (let [cluster (re-find #"[^aeiou]\w*y" word)]
                     (str "y" 
                          (str/replace word (re-pattern cluster) "")
                          (str/replace cluster #"y" "")
                          "ay"))
    (rule-3? word) (let [cluster (re-find #"\w*qu" word)]
                     (str (str/replace word (re-pattern cluster) "")
                          cluster
                          "ay"))
    (rule-2? word) (let [consonant-cluster (apply str (take-while #(rule-2? %) word))]
                     (str (str/replace word (re-pattern consonant-cluster) "")
                          consonant-cluster
                          "ay"))
    (rule-1? word) (str word "ay")))
