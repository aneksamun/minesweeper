(ns co.uk.redpixel.mine.sweeper.core)

(def neighbours
  [[-1, 1][0, 1][1, 1]
   [-1, 0]      [1, 0]
   [-1,-1][0,-1][1,-1]])

(defn neighbours-of [x, y]
  (set (map (fn [[x-offs y-offs]] [(+ x-offs x) (+ y-offs y)]) neighbours)))

(defn generate-cell [neighbours x y]
  (if (contains? neighbours [x y]) 1 0))

(defn generate-line [neighbours width y]
  ((map (partial generate-cell neighbours y)
        (range 0 width))))

(defn generate-board [dimensions neighbours]
  (mapcat (partial generate-line neighbours (dimensions :w))
          (range 0 (dimensions :h))))

(defn mine? [cell]
  (= \* cell))

(defn board-for-cell [dimensions y x cell]
  (generate-board dimensions (if (mine? cell) (neighbours-of x y))))

(defn boards-for-line [dimensions line y]
  (map (partial board-for-cell dimensions y)
       (range 0 (dimensions :w)) line))

(let [input-board "* \n * \n *"
      lines (clojure.string/split-lines input-board),
      dimensions {:h (count lines), :w (count (first lines))}]
  (mapcat (partial boards-for-line dimensions)
          lines
          (range 0 (dimensions :h))))
