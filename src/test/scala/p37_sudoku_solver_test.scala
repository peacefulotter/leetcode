package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

class p37_sudoku_solver_test extends AnyFlatSpec {
    private def test(board: Array[Array[Char]], expected: Boolean) = {
        assert(p37_sudoku_solver.solveSudoku(board) === expected)
    }

    it should "board1 => true" in {
        val board = Array(
            Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        test(board, true)
    }

    it should "board2 => false" in {
        val board = Array(
            Array('8', '3', '.', '.', '7', '.', '.', '.', '.'),
            Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        test(board, false)
    }
}
