# Debugging throw the algorithm

Determines coordinates of the neighbours around given cell.
```  
(neighbours-of 2 2)
=> [2 3] [3 3] [1 1] [1 3] [3 1] [2 1] [1 2] [3 2]
```
Constructs cell. If cell to be generated happens to be a adjacent of existing, function returns 1, otherwise returns 0.
```
(generate-cell (neighbours-of 2 2) 2 3) 
=> 1
```
Constructs line. The 5 here is a width (y axis) which would generate following coordinates [0 1] [1 1] [2 1]  [3 1] [4 1]. 
```
(generate-line (neighbours-of 2 2) 5 1)
=> (0 1 1 1 0)
```
Constructs board defining width and height, and sets 1 if generated cell matches neighbour coordinates.
```
(generate-board {:h 5 :w 5} (neighbours-of 2 2))
=> (0 0 0 0 0 0 1 1 1 0 0 1 0 1 0 0 1 1 1 0 0 0 0 0 0)
```
Generates board for single cell.
```
(board-for-cell {:w 5 :h 5} 1 1 \*)
=> (1 1 1 0 0 1 0 1 0 0 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0)
```
Generates board for given line.
```
(boards-for-line {:w 3 :h 3} "*  " 0)
=> ((0 1 0 1 1 0 0 0 0) (0 0 0 0 0 0 0 0 0) (0 0 0 0 0 0 0 0 0))
```
