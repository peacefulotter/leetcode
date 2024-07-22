package com.peacefulotter.leetcode

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object p2418_sort_people {
  def sortPeople(names: Array[String], heights: Array[Int]): Array[String] = {
    names zip heights sortBy { -_._2 } collect { case (n, _) => n }
  }
}
