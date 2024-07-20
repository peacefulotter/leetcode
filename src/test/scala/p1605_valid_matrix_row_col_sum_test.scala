package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.mutable.ListBuffer

class p1605_valid_matrix_row_col_sum_test extends AnyFlatSpec {
  private def test(rowSum: Array[Int], colSum: Array[Int]) = {
    val mat = p1605_valid_matrix_row_col_sum.restoreMatrix(rowSum.clone(), colSum.clone())

    val rowS = ListBuffer.fill(rowSum.length)(0)
    val colS = ListBuffer.fill(rowSum.length)(0)

    for (i <- rowSum.indices; j <- colSum.indices) {
      rowS(i) += mat(i)(j)
      colS(j) += mat(i)(j)
    }
    assert(rowS === rowSum && colS === colSum)
  }

  it should "[5,7,10], [8,6,8]" in {
    test(Array(5, 7, 10), Array(8, 6, 8))
  }
}
