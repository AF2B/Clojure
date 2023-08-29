;; 1. defn: define a function
;; 2. def: define a variable
;; 3. defmacro: define a macro
;; 4. deftype: define a new type
;; 5. defrecord: define a new type
;; 6. defprotocol: define a new protocol
;; 7. definterface: define a new interface
;; 8. defmulti: define a new multimethod
;; 9. defmethod: define a new method
;; 10. defonce: define a global var once

;; In Clojure, functions are defined using the defn keyword.
;; structure: (defn <function-name> [<arg1> <arg2> ...] <function-body>)

(defn add [a, b]
  (+ a b))

(defn greet [name]
  (str "Hello " name "!"))

(defn is-even? [number]
  (if (even? number)
    true
    false))

(defn is-odd? [number]
  (if (odd? number)
    true
    false))

(def result (add 1 2))
(def greeting (greet "John"))
(def is-even (is-even? 2))
(def is-odd (is-odd? 3))

(println result)
(println greeting)
(println is-even)
(println is-odd)

;;Data-Types
(def number 26)
(def text "Hello, Clojure!")
(def my-array [1 2 3 4 5])
(def my-map {:name "John" :age 26})

(println number)
(println text)
(println my-array)
(println my-map)

;;Operators
(def sum (+ 2 3))
(def product (* 2 3))
(def difference (- 10 7))
(def quotient (/ 10 2))

;;Conditionals
(defn positive-or-negative [number]
  (if (> number 0)
    "Positive"
    "Negative"))
(println (positive-or-negative 10))

(defn is-adult? [age]
  (if (>= age 18)
    true
    false))
(println (is-adult? 26))

(defn rate [score]
  (when (>= score 100)
    (println "Team is doing great!")
    (when (>= score 80)
      (println "Team is doing good!")
      (when (>= score 60)
        (println "Team is doing okay!")
        (when (>= score 30)
          (println "Team is doing bad!")
          (println "Team is doing terrible!"))))))

(defn average [score]
  (cond
    (< score 30) "Terrible"
    (< score 60) "Bad"
    (< score 80) "Okay"
    (< score 100) "Good"
    :else "Cannot be determined"))

;;Loops
(defn print-numbers [n]
  (loop [i 0]
    (when (< i n)
      (println i)
      (recur (inc i)))))

(defn dotimes-numbers [n]
  (dotimes [i n]
    (println i)))

(defn countdown [n]
  (loop [i n]
    (if (<= i 0)
      "Blastoff!"
      (recur (- i 1)))))

;;Atom
(def counter (atom 0))
(defn increment-counter []
  (swap! counter inc))
;;swap!
;;function takes an atom and a function as arguments and applies the function to the current value of the atom

(defn decrement-counter []
  (swap! counter dec))

(defn reset-counter []
  (reset! counter 0))
;;reset!
;;function takes an atom and a value as arguments and sets the value of the atom to the given value

;;Sequences
(def my-list (list 1 2 3 4 5))
(def my-vector [1 2 3 4 5])

(def first-element (first my-list))
(println first-element)

(def last-element-vector (last my-vector))
(println last-element-vector)

;;Structmap
(def person {:name "John" :age 26 :country "BR"})
(:name person)
(:age person)
(:country person)

;;Destructuring
(let [{name :name age :age country :country} person]
  str "Name: " name ", Age: " age ", Country: " country)

;;Exception Handling
(defn safe-divide [a b]
  (try
    (/ a b
       (catch Exception
              (println "Error: " (.getMessage)
                       (finally
                         (println "Division finished!")))))))

;;Macros
(defmacro unless
  ([pred expr]
   `(if (not ~pred
             ~expr))))

;;Watches
(def huge-number (atom 6000))

(add-watch huge-number
           :huge-number-watcher
           (fn [key atom old-state new-state] ; if you don't need any of the arguments, you can put _
             (println "Huge number has changed!" ", Old state: " old-state ", New state: " new-state)))

(swap! huge-number inc)

;;Agents
(def less-number (agent 0))
(send less-number inc)
(await less-number)
;; Agents are asynchronous, so we need to use await to wait for the agent to finish its
;; execution before we can use its value.

;;Reference Values
(def account (ref 100))

(dosync
 (alter account - 50))
(println "New balance: " @account)
