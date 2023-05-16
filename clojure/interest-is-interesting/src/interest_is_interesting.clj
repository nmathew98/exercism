(ns interest-is-interesting)

(defn interest-rate
  "TODO: add docstring"
  [balance]
  (cond
    (< balance 0) -3.213
    (and (<= 0 balance) (< balance 1000)) 0.5
    (and (>= balance 1000) (< balance 5000)) 1.621
    :else 2.475))

(defn annual-balance-update
  "TODO: add docstring"
  [balance]
  (let [interest (* (bigdec (/ (interest-rate balance) 100)))]
    (if (pos? interest)
      (bigdec (+ (bigdec balance) (* (bigdec (/ (interest-rate balance) 100)) (bigdec balance))))
      (bigdec (- (bigdec balance) (* (bigdec (/ (interest-rate balance) 100)) (bigdec balance)))))))

(defn amount-to-donate
  "TODO: add docstring"
  [balance tax-free-percentage]
  (if (pos? balance)
    (int (* 2 (* (/ tax-free-percentage 100) balance)))
    0))