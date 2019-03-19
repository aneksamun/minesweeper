(ns co.uk.redpixel.minesweeper.application
  (:require [co.uk.redpixel.minesweeper.core :refer [draw]]
            [clojure.string :refer [join split]])
  (:gen-class))

(defn -main [& args]
  (if-let [board (first args)]
    (println (draw (join (split board #"\\n"))))
    (do
      (println "usage: minesweeper [board]")
      (println (str "\n" "arguments:"))
      (println (str "\t" "board: the board of empty fields, special characters and mines, for example, \"***\\n* *\\n***\"")))))
