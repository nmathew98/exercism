(ns all-your-base)

(defn pow [base exp]
  (long (Math/pow base exp)))

(defn to-decimal [initial-base digits]
  (apply + (map-indexed #(* %2 (pow initial-base %1)) (reverse digits))))

(defn from-decimal [final-base decimal]
  (loop [remainder decimal
         converted '()]
    (cond
      (< remainder final-base) (conj converted remainder)
      :else (recur (quot remainder final-base) (conj converted (rem remainder final-base))))))

(defn convert [initial-base digits final-base]
  (when (and (> initial-base 1)
             (> final-base 1)
             (seq digits)
             (not (some #(or (< % 0) (>= % initial-base)) digits)))
    (from-decimal final-base (to-decimal initial-base digits))))
