package com.peacefulotter.leetcode

import scala.collection.immutable.Set

object p2045_min_time_dest {

  // DFS With pruning too slow and too memory-intensive
//  def dfs(vertex: Int, visited: Set[Int], times: Set[Int], maxTime: Int, totalTime: Int): Set[Int] =
//    // println((vertex, visited, totalTime))
//    if (vertex == n)
//      Set(totalTime)
//    else if (times.size > 1 && (totalTime + time) > maxTime)
//      // println("pruning")
//      Set()
//    else
//      neighbors.get(vertex) match {
//        case Some(neigh) =>
//          val newTime = step(totalTime)
//          val paths = neigh
//            .foldLeft((times, maxTime)) { case ((times, maxTime), n) =>
//              if visited.contains(n) then (times, maxTime) else
//              val newTimes = times ++ dfs(n, visited + n, times, maxTime, newTime)
//              (newTimes, Math.max(maxTime, if newTimes.nonEmpty then newTimes.max else 0))
//            }
//          //              .withFilter(!visited.contains(_))
//          //              .flatMap(n => dfs(n, visited + n, newTime))
//          // println((vertex, visited, neigh, totalTime, paths))
//          paths._1
//        case _ => Set()
//      }

  def secondMinimum(n: Int,
                    edges: Array[Array[Int]],
                    time: Int,
                    change: Int): Int = {

    val neighbors = edges
      .flatMap(edge => List((edge(0), edge(1)), (edge(1), edge(0))))
      .groupBy(_._1)
      .view
      .mapValues(_.map(_._2).toSet)
    println(neighbors.toMap)

    def step(totalTime: Int): Int =
      val shouldWait = (totalTime / change) % 2 == 1
      val waitTime = if shouldWait then change - totalTime % change else 0
      totalTime + waitTime + time

    def shortestPath(v: Int, visited: Set[Int]): Set[Int] = ???

    val costs = shortestPath(1, Set(1)).toList
    println(f"Final costs: ${costs}")
    if (costs.length == 1)
      step(step(costs.head))
    else {
      println(f"Sorted ${costs.sortWith(_ < _)}")
      costs.sortWith(_ < _)(1)
    }
  }
}
