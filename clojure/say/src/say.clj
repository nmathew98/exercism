(ns say
  (:require [clojure.pprint :as pprint])
  (:require [clojure.string :as str]))

(defn number [num] ;; <- arglist goes here
  (if (<= 0 num 999999999999)
    (str/replace (pprint/cl-format false "~R" num) "," "")
    (throw (IllegalArgumentException/new "Out of bounds"))))
