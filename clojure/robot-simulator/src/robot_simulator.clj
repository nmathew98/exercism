(ns robot-simulator)

(defn robot [coordinates direction]
  {:bearing direction :coordinates coordinates})

(defn turn-right [direction]
  (case direction
        :north :east
        :south :west
        :east :south
        :west :north))

(defn turn-left [direction]
  (case direction
        :north :west
        :south :east
        :east :north
        :west :south))

(defn advance [{ coordinates :coordinates bearing :bearing }]
  (case bearing
    :north (assoc coordinates :y (inc (:y coordinates)))
    :west (assoc coordinates :x (dec (:x coordinates)))
    :south (assoc coordinates :y (dec (:y coordinates)))
    :east (assoc coordinates :x (inc (:x coordinates)))))

(defn simulate-single-letter [r letter]
  (case letter
    \R (robot (:coordinates r) (turn-right (:bearing r)))
    \L (robot (:coordinates r) (turn-left (:bearing r)))
    \A (robot (advance r) (:bearing r))))

(defn simulate [letter-string r]
  (reduce simulate-single-letter r letter-string))
