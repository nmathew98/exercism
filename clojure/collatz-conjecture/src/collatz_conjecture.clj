(ns collatz-conjecture)

(defn half [num]
  (/ num 2))

(defn triple-add-one [num]
  (inc (* 3 num)))

(defn count-steps [num steps]
  (cond
    (= 1 num) steps
    (even? num) (recur (half num) (inc steps))
    (odd? num) (recur (triple-add-one num) (inc steps))))

(defn collatz [num]
  {:pre [(pos? num)]}
  (count-steps num 0)
)
