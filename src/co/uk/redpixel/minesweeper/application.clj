(ns co.uk.redpixel.minesweeper.application
  (:require [co.uk.redpixel.minesweeper.core :refer [draw]]
            [clojure.java.io :as io]
            [clojure.string :refer [join]])
  (:gen-class))

(def board-file (io/resource "board.txt"))

(defn -main [& _]
  (println (draw (slurp board-file))))
