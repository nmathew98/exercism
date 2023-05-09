(ns octal)

;; if x < 10, then there is just one digit
;; if x >= 10, then conjoin the remainder of x / 10 recursively
;; to do tail call recursion always requires us to pass the accumulator as an argument
(defn digits [x digits]
  (cond
    (>= x 10) (recur (quot x 10) (cons (long (rem x 10)) digits))
    :else (cons x digits)))

(defn pow [base exp]
  (long (Math/pow base exp)))

(defn digits-are-less-than-eight? [octal] 
  (every? #(< (int (Character/digit %1 10)) 8) (seq octal)))

(defn to-decimal
  [octal]
  (cond 
    (and (number? (read-string octal)) (digits-are-less-than-eight? octal)) 
      (apply + (map-indexed #(* %2 (pow 8 %1)) (reverse (digits (read-string octal) '()))))
    :else 0))
