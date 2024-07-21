package com.peacefulotter.leetcode

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object p2392_matrix_with_conditions {

  case class Root(
      k: Int,
      var inDegree: Int = 0,
      to: ArrayBuffer[Int] = ArrayBuffer()
  )

  private def noIncomingEdges(
      positions: IndexedSeq[Root]
  ) =
    mutable
      .Queue()
      .addAll(positions filter { r => r.inDegree == 0 } map { _.k })

  def solveOrder(k: Int, conditions: Array[Array[Int]]): List[Int] = {
    val positions: IndexedSeq[Root] = Range.inclusive(1, k).map(Root(_))
    println(positions)

    for (cond <- conditions)
      cond map { p => positions(p - 1) } match {
        case Array(rootA, rootB) =>
          rootA.to.addOne(rootB.k)
          rootB.inDegree += 1
      }

    val queue = noIncomingEdges(positions)
    // Keep track of visited nodes using a set preserving the order in which items are inserted
    val track: mutable.LinkedHashSet[Int] =
      queue.toSet.to(collection.mutable.LinkedHashSet)
    while (queue.nonEmpty) {
      val nodeK = queue.dequeue()
      track.addOne(nodeK)
      for (
        destK <- positions(nodeK - 1).to; dest = positions(destK - 1);
        if !track(destK)
      ) {
        dest.inDegree -= 1
        if (dest.inDegree == 0) {
          queue.enqueue(destK)
        }
      }
    }
    track.toList
  }

  def buildMatrix(
      k: Int,
      rowConditions: Array[Array[Int]],
      colConditions: Array[Array[Int]]
  ): Array[Array[Int]] = {

    val rows = solveOrder(k, rowConditions)
    if (rows.length < k)
      return Array()

    val cols = solveOrder(k, colConditions).zipWithIndex.sortBy(_._1)
    if (cols.length < k)
      return Array()

    val mat = Array.fill(k)(Array.fill(k)(0))
    for ((r, i) <- rows.zipWithIndex)
      mat(i)(cols(r - 1)._2) = r

    mat
  }
}
