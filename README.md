# Minesweeper

![Build status](https://github.com/aneksamun/minesweeper/actions/workflows/clojure.yml/badge.svg)

Minesweeper is a game which objective is to clear a board containing hidden "mines" or bombs without detonating any of them, with help from clues about the number of neighboring mines in each field. 

![minesweeper](doc/minesweeper.png?raw=true "Minesweeper")

## About

The repository is created being inspired by [Functional Style](https://codurance.com/2018/11/02/the-functional-style-part-6/) article written by Richard Wild. The author is describing currying by example of minesweeper where it been used to calculate a number indicating how many of current square adjacents contains mines.  

## Build and run instructions
1. Build JAR   
`$ lein compile`   
`$ lein uberjar`   
2. Run   
`$ cd target/`   
`$ java -jar minesweeper-1.0-standalone.jar "** **"`   

## License

Copyright © 2019 Red Pixel Limited

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
