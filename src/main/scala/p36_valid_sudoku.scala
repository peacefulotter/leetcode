package com.peacefulotter.leetcode

object p36_valid_sudoku {
    private type Sudoku = Array[Array[Char]]
    def isValidSudoku(board: Sudoku): Boolean = {
        def checkRow(v: Char, i: Int): Boolean =
            board(i).count(_ == v) == 1
        def checkCol(v: Char, i: Int): Boolean =
            (0 until 9).map(r => board(r)(i) ).count(_ == v) == 1
        def checkSquare(v: Char, i: Int, j: Int): Boolean = {
            val sI = (i / 3) * 3; val sJ = (j / 3) * 3
            println(i, j, sI, sJ, sI until sI + 3, sJ until sJ + 3)
            for {
                r <- sI until sI + 3
                c <- sJ until sJ + 3
                if (r != i || c != j) && board(r)(c) == v
            } return false
            true
        }

        def validate(v: Char, i: Int, j: Int): Boolean =
            checkRow(v, i) && checkCol(v, j) && checkSquare(v, i, j)

        for (
            row <- 0 until 9;
            col <- 0 until 9;
            v = board(row)(col)
            if v != '.' && !validate(v, row, col)
        ) return false;
        true;
    }
}