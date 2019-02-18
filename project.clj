(defproject minesweeper "1.0.0"
  :description "Minesweeper game"
  :url "https://github.com/aneksamun/minesweeper"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :aot [co.uk.redpixel.mine.sweeper.application]
  :main [co.uk.redpixel.mine.sweeper.application])
