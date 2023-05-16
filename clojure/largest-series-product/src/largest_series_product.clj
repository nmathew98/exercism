(ns largest-series-product)

(defn product [nums]
  (apply * (map #(Character/digit % 10) nums)))

(defn nums? [nums] (not (re-find #"\D" nums)))

(defn largest-product [n nums]
  {:pre [(number? n) (nums? nums) (<= 0 n (count nums))]}
  (loop [successive (take n nums) 
         successive-product (product successive)
         next (apply str (drop 1 nums))
         largest Integer/MIN_VALUE]
    (if (>= (count next) n)
      (if (zero? n)
        1
        (recur (take n next) (product (take n next)) (apply str (drop 1 next)) (max successive-product largest)))
      (max successive-product largest))))
