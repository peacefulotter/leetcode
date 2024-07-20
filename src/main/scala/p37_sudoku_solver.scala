package com.peacefulotter.leetcode

import scala.collection.mutable

object Note {
    import p37_sudoku_solver.Sudoku

    val notes: mutable.Map[(Int, Int), IndexedSeq[Char]] = mutable.Map()

    private def checkRow(board: Sudoku, r: Int): Array[Char] =
        board(r).filter(_ != '.')

    private def checkCol(board: Sudoku, c: Int): IndexedSeq[Char] =
        (0 until 9).map(r => board(r)(c)).filter(_ != '.')

    def checkSquare(board: Sudoku, r: Int, c: Int): IndexedSeq[Char] = {
        val sR = (r / 3) * 3;
        val sC = (c / 3) * 3
        for {
            r <- sR until sR + 3
            c <- sC until sC + 3
            if board(r)(c) != '.'
        } yield board(r)(c)
    }

    private def note(board: Sudoku, r: Int, c: Int): Boolean = {
        val candidates = ('1' to '9')
            .diff(checkRow(board, r))
            .diff(checkCol(board, c))
            .diff(checkSquare(board, r, c))
        if (candidates.length == 1) {
            board(r)(c) = candidates(0)
            return true
        }
        notes.addOne(((r, c), candidates))
        false
    }

    def takeNotes(board: Sudoku): Boolean = {
        var changed = false
        for (
            r <- 0 until 9;
            c <- 0 until 9;
            if board(r)(c) == '.'
        ) changed = changed || note(board, r, c);
        changed
    }
}

object p37_sudoku_solver {
    type Sudoku = Array[Array[Char]]
    def solveSudoku(board: Sudoku): Unit = {

        Note.takeNotes(board)
        // println(notes.foreach(println))
    }
}