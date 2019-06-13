# Debugging algorithm

####Getting to know the neighbours
```  
(def neighbours
  [[-1, 1][0, 1][1, 1]
   [-1, 0]      [1, 0]
   [-1,-1][0,-1][1,-1]])
   
(defn neighbours-of [x y]
  (set (map (fn [[x-offs y-offs]] [(+ x-offs x) (+ y-offs y)]) neighbours)))   
```
Determines coordinates of neighbourhood cells.
```
(neighbours-of 2 2)
=> [2 3] [3 3] [1 1] [1 3] [3 1] [2 1] [1 2] [3 2]
```
####Constructing a board
```
(defn generate-cell [neighbours y x]
  (if (contains? neighbours [x y]) 1 0))
```
Constructs cell by checking if any neighbour cell is within coordionates. If so returns 1, otherwise 0.
```
(generate-cell (neighbours-of 2 2) 2 3) 
=> 1
```
Constructs a line with dynamic width constant y.  
For example, for width of 5 and y of 1 will produces coordinates of [0 1] [1 1] [2 1]  [3 1] [4 1].  
If generated line matches neighbour coordinates value is set to one.
```
(generate-line (neighbours-of 2 2) 5 1)
=> (0 1 1 1 0)
```
Constructs a board specifying width and height, i.e., changing x and y will produce following coordinates:  
[0 0] [0 1] [0 2] [0 3] [0 4]  
[1 0] [1 1] [1 2] [1 3] [1 4]  
[2 0] [2 1] [2 2] [2 3] [2 4]  
[3 0] [3 1] [3 2] [3 3] [3 4]  
[4 0] [4 1] [4 2] [4 3] [4 4]
```
(generate-board {:h 5 :w 5} (neighbours-of 2 2))
=> (0 0 0 0 0 0 1 1 1 0 0 1 0 1 0 0 1 1 1 0 0 0 0 0 0)
```
Generates board for a single cell. For none mine cell neighbour coordinates will be set to `nill` which would produce board of zero values. 
```
(board-for-cell {:w 5 :h 5} 1 1 \*)
=> (1 1 1 0 0 1 0 1 0 0 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0)
```
Generates board for each cell within given line.
```
(boards-for-line {:w 3 :h 3} "*  " 0)
=> ((0 1 0 1 1 0 0 0 0) (0 0 0 0 0 0 0 0 0) (0 0 0 0 0 0 0 0 0))
```
1. For each all line and y
2. For each x and pos within line
3. Generate neighbours coordinates
4. For each y within board 
5. For each x within board
6. If x,y == neigbour cell set 1 or 0
7. Sum up boards
