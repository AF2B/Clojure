;;map
(def numbers [1 2 3 4])
(defn square [number-list]
  (* number-list number-list))

(def squared-numbers (map square numbers))
(squared-numbers)

(def words ["World" "Box" "Robot"])

(defn length-of-word [word]
  (count word))

(def word-lengths (map length-of-word words))
(println word-lengths)

;;reduce
(def odd-numbers-vec [1 3 5 7 9])

(defn add [x y]
  (+ x y))

(def sum (reduce add odd-numbers-vec))
(println sum)

(def my-name ["André" "Borba"])

(def setence (reduce concat my-name))
(println setence)

;;filter
(def one-to-ten (range 1 11))

(def even-numbers (filter even? one-to-ten))
(println even-numbers)

(def odd-numbers (filter odd? one-to-ten))
(println odd-numbers)

(defn starts-with-a? [word]
  (= (first word) \A))
(def fruits ["Pineapple" "Cherry" "Apple" "Banana" "Avocado"])
(def fruits-with-a (filter starts-with-a? fruits))
(println fruits-with-a)
