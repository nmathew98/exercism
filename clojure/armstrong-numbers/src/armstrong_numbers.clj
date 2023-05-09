(ns armstrong-numbers)

;; if x < 10, then there is just one digit
;; if x >= 10, then conjoin the remainder of x / 10 recursively
;; to do tail call recursion always requires us to pass the accumulator as an argument
(defn digits [x digits]
  (cond
    (>= x 10) (recur (quot x 10) (cons (long (rem x 10)) digits))
    :else (cons x digits)))

(defn pow [exp]
  #(reduce * (repeat exp %1)))

(defn armsum [digits]
  (reduce + (map (pow (count digits)) digits)))

(defn armstrong? [num]
  (= (long num) (armsum (digits num '()))))