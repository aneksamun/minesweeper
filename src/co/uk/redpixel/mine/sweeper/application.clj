(ns co.uk.redpixel.mine.sweeper.application
  (:require [co.uk.redpixel.mine.sweeper.core :refer [draw]])
  (:gen-class))

(defn -main
  [& args]
  (if-let [board (first args)]
    (draw board)
    (println "usage: minesweeper [board]")))
