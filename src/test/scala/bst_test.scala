package com.peacefulotter.leetcode

import org.scalatest.flatspec.AnyFlatSpec

import scala.annotation.tailrec
import scala.util.Random

class bst_test extends AnyFlatSpec {

  def bst(length: Int = 32): (BST, IndexedSeq[Int]) = {
    Random.setSeed(42)
    val values = Random.shuffle(Range(0, length))
    val tree = BST(values.head)
    for (v ← values) tree.insert(v)
    (tree, values)
  }

  it should "print" in {
    println(bst()._1.print())
  }

  it should "Remove all values from tree" in {
    val (tree, values) = bst()
    Random.setSeed(42)
    val removeElements = Random.shuffle(values)

    @tailrec
    def rec(l: IndexedSeq[Int]): Unit = l match {
      case x +: xs ⇒
        tree.remove(x)
        for (y ← xs) assert(tree.find(y).get !== None)
        rec(xs)
      case _ ⇒ None
    }
    rec(removeElements)
  }

}
