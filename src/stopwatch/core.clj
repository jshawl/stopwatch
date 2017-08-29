(ns stopwatch.core
  (:gen-class))

(defn set-interval [callback ms] 
  (future (while true (do (Thread/sleep ms) (flush) (callback)))))

(defn now []
  (quot (System/currentTimeMillis) 1000))

(defn job [start] (set-interval #(print 
  (str "\r" (- (now) start) ))1000))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
    (job (now)))
