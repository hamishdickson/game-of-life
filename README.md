[![Build Status](https://travis-ci.org/hamishdickson/game-of-life.svg?branch=master)](https://travis-ci.org/hamishdickson/game-of-life)

Conway's Game of Life
=====================

Some java TDD practice with Conway's Game of Life as the end target

Game of life: http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

* Any live cell with fewer than two live neighbours dies, as if caused by under-population.
* Any live cell with two or three live neighbours lives on to the next generation.
* Any live cell with more than three live neighbours dies, as if by overcrowding.
* Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

Implementations
===============

There are two implementations here - a finite version and an "infinite" version (actually it's limited by the size of 
ArrayList and the size of int)