package com.peacefulotter.leetcode

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object p1605_valid_matrix_row_col_sum {
  def restoreMatrix(
      rowSum: Array[Int],
      colSum: Array[Int]
  ): Array[Array[Int]] = {
    val mat = Array.fill(rowSum.length)(Array.fill(colSum.length)(0))
    for (i <- rowSum.indices; j <- colSum.indices) {
      val r = rowSum(i)
      val c = colSum(j)
      val v = Math.min(r, c)

      mat(i).update(j, v)
      rowSum.update(i, r - v)
      colSum.update(j, c - v)
    }
    mat
  }
}
