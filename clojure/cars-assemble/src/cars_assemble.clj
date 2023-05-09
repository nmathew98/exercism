(ns cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [calculate-cars-produced 
       (fn [speed] (* speed 221.0))
       calculate-success-rate
       (fn [speed]
       (cond
       (= speed 0.0) 0.0
       (<= 1.0 speed 4.0) 1.0
       (<= 5.0 speed 8.0) 0.9
       (<= speed 9.0) 0.8
       :else 0.77))
       cars-produced (calculate-cars-produced speed)
       success-rate (calculate-success-rate speed)]
  (* success-rate cars-produced)))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (quot (production-rate speed) 60)))
