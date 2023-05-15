(ns raindrops)

(defn pling [n s]
  (if (zero? (rem n 3))
    (str s "Pling")
    s))

(defn plang [n s]
  (if (zero? (rem n 5))
    (str s "Plang")
    s))

(defn plong [n s]
  (if (zero? (rem n 7))
    (str s "Plong")
    s))

(defn default [n s]
  (if (not (or 
            (zero? (rem n 3)) 
            (zero? (rem n 5)) 
            (zero? (rem n 7))))
    (str n)
    s))

(defn convert [n]
  (default n (plong n (plang n (pling n "")))))
