(ns triangle)

(defn is-valid? [a b c]
  (and (> a 0) (> b 0) (> c 0) (>= (+ a b) c) (>= (+ a c) b) (>= (+ c b) a)))

(defn equilateral? [a b c]
  (and (is-valid? a b c) (= a b c)))

(defn isosceles? [a b c]
  (and (is-valid? a b c) (or (= a b) (= a c) (= b c))))

(defn scalene? [a b c]
  (and (is-valid? a b c) (not= a b) (not= a c) (not= b c)))
