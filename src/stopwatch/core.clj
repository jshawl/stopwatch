(ns stopwatch.core
  (:require [clojure.string :refer [trim]])
  (:gen-class))

(defn set-interval [callback ms] 
  (future (while true (do (Thread/sleep ms) (flush) (callback)))))

(defn now []
  (quot (System/currentTimeMillis) 1000))

(defn duration [s]
  (let [hours (int (Math/floor (/ s 3600))) l (- s (* hours 3600))]
    (let [minutes (int (Math/floor (/ (- s (* hours 3600)) 60)))]
      (let [seconds (- s (+ (* minutes 60) (* hours 3600)))]
        {:hour hours :minute minutes :second seconds}))))

(defn fmt [k v]
  (if (zero? v) "" (str v " " (name k) (if (> v 1) "s" ""))))

(defn duration-fmt [s]
  (reduce-kv 
    (fn [m k v]
      (trim (str m " " (fmt k v)))) "" (duration s)))

(defn job [start] (set-interval #(print 
  (str "\r" (duration-fmt (- (now) start)))) 1000))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
    (job (now)))
