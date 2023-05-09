(ns difference-of-squares)

(defn difference [num]
  (apply * (list (/ num 12) (- (* num num) 1) (+ (* 3 num) 2))))

(defn range-end-inclusive [num]
  (range 1 (inc num)))

(defn sum [range]
  (apply + range))

(defn pow [exp]
  #(int (Math/pow %1 exp)))

(defn sum-of-squares [num]
  (sum (map (pow 2) (range-end-inclusive num)))
)

(defn square-of-sum [num]
  ((pow 2)(sum (range-end-inclusive num)))
)
