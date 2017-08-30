(ns stopwatch.core-test
  (:require [clojure.test :refer :all]
            [stopwatch.core :refer :all]))

(deftest duration-test
  (testing "duration"
    (is (= (duration 1) {:hour 0 :minute 0 :second 1}))
    (is (= (duration 2) {:hour 0 :minute 0 :second 2}))
    (is (= (duration 60) {:hour 0 :minute 1 :second 0}))
    (is (= (duration 61) {:hour 0 :minute 1 :second 1}))
    (is (= (duration 3666) {:hour 1 :minute 1 :second 6}))
    ))

(deftest duration-fmt-test
(testing "duration formatted"
  (is (= (duration-fmt 1) "1 second"))
  (is (= (duration-fmt 2) "2 seconds"))
  (is (= (duration-fmt 60) "1 minute"))
  (is (= (duration-fmt 62) "1 minute 2 seconds"))
  ))
