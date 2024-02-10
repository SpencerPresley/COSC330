#!/bin/bash

# Compile all java files in current directory (Lab1_TicTacToe)
javac *.java

# Navigate up to the parent directory to run the game
cd ..

# run Main class from Lab1_TicTacToe package
java -cp . Lab1_TicTacToe.Main