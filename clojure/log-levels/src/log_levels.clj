(ns log-levels
  (:require [clojure.string :as str]))

(defn parse [s]
  (let [split (str/split s #": ")]
    {:level (str/lower-case (str/replace (first split) #"\[|\]" ""))
     :message (str/trim (nth split 1))}))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (:message (parse s)))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (:level (parse s)))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (let [parsed (parse s)]
    (format "%s (%s)" (:message parsed) (:level parsed))))
