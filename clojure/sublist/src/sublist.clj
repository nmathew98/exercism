(ns sublist)

(defn classify [list1 list2]
      (cond
        (= list1 list2) :equal
        ; if list1 is a sublist of list2, then every element in list1
        ; exists in list2 but some elements in list2 do not exist in list1
        ; so we check for the existence of the set of values in list1
        ; by partitions of size (count list1) in list2
        (some #{list1} (partition (count list1) 1 list2)) :sublist
        (some #{list2} (partition (count list2) 1 list1)) :superlist
        :else :unequal)
)
