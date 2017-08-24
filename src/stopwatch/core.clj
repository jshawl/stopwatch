(ns stopwatch.core
  (:gen-class))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (doseq [i (range 10000000)]
    (print (str "\r" i))))
