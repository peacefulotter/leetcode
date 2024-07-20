package com.peacefulotter.leetcode

import java.util.Optional
import scala.collection.mutable.ListBuffer
import scala.annotation.tailrec

object heapsort {

  def iLeftChild(i: Int): Int  = 2*i + 1
  def iRightChild(i: Int): Int = 2*i + 2
  def parent(i: Int): Int = Math.floor((i-1) / 2).toInt

  def swap(arr: ListBuffer[Int], i: Int, j: Int): Unit = {
    println("swapping", i, j, arr(i), arr(j))
    val temp = arr(i)
    arr.update(i, arr(j))
    arr.update(j, temp)
    println("swapping", arr.toList)
    println("swapping", Range(0, arr.length).toList)
  }

  private def checkIndex(arr: ListBuffer[Int], i: Int, j: Int, maxI: Option[Int] = None): Unit = {
    if (j >= arr.length || (maxI.isDefined && i >= maxI.get))
        return
    if (arr(j) > arr(i)) {
      swap(arr, i, j)
      heapify(arr, j)
    }
  }

  @tailrec
  private def heapify(arr: ListBuffer[Int], i: Int, maxI: Option[Int] = None): Unit = {
    if (i < 0)
      return

    checkIndex(arr, i, iLeftChild(i), maxI)
    checkIndex(arr, i, iRightChild(i), maxI)
    heapify(arr, i - 1)
  }

  @tailrec
  private def reconstruct(arr: ListBuffer[Int], i: Int): Unit = {
    if (i <= 0)
      return
    swap(arr, 0, i)
    println("Reconstruct", i, arr)
    heapify(arr, parent(i), Some(i))
    reconstruct(arr, i - 1)
  }

  def sort(arr: ListBuffer[Int]): ListBuffer[Int] = {
    println("input", arr.length, arr)
    val i = parent(arr.length - 1) + 1
    println(i)
    heapify(arr, i)
    println(arr)
    println("RECONSTRUCTING =================================")
    reconstruct(arr, arr.length - 1)
    println(arr)
    arr
  }
}
