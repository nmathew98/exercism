(ns nth-prime)

(defn prime? [n] 
  (cond
    (even? n) (= n 2)
    (odd? n) (= n 3)
    :else (not (some #(zero? (rem n %)) (range 4 (inc (Math/sqrt n)))))))

(defn nth-prime 
  "Returns the prime number in the nth position."
  [n]
  (cond
    (> n 0) (nth (filter prime? (range)) n)
    :else (throw (IllegalArgumentException/new "There is no zeroth prime"))))
