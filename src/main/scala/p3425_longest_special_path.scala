package com.peacefulotter.leetcode

/**
  * The following file contains 2 (potential, not passing) solutions:
  *
  *  1. The uncommented one attempts to satisfy the definition of "downwards" while merging
  *  paths branching at the same depth. From the description, I assumed this should be a correct solution
  *  but then 2 tests conflicts:
  *    - The first one would be solved by doing 1 -> 2 and 1 -> 4, which is incorrect
  *    - the "MARKED" test in p3425_longest_special_path_test, which clearly uses two branches from the same depth...
  *
  *  2. The commented code contains a working version for a relaxed definition of "downwards", which is still unclear to me
  *
  */
object p3425_longest_special_path {

  private case class Path(
      len: Int,
      acc: Set[Int],
      visited: Set[Int]
  ) {
    val count: Int = visited.size

    def canMerge(root: Path, p: Path): Boolean =
      visited.intersect(p.visited).size > 1 || acc.intersect(p.acc) == root.acc

    def merge(root: Path, p: Path): Path = {
      val res = Path(len + p.len - root.len, acc ++ p.acc, visited ++ p.visited)
      println(s"Merging $this, $p => $res")
      res
    }

    // "this" is best if
    //  1. It is longer than "p"
    //  2. They're the same length but "p" contains fewer nodes
    // Otherwise they're either equivalent longest special path or "p" is better
    def best(p: Path): Path =
      if (len > p.len || (len == p.len && count < p.count)) this else p
  }

  private val SRC = -1

  /**
    * Builds a directed adjacency matrix with a special "src" node pointing to all other nodes
    */
  private def adjacency(edges: Array[Array[Int]]) =
    edges.foldLeft(Map[Int, Map[Int, Int]]())(
      (acc, cur) =>
        cur match {
          case Array(v_i, v_j, w) => {
            val row_src = acc.getOrElse(SRC, Map()) + (v_i -> 0) + (v_j -> 0)
            val row_i = acc.getOrElse(v_i, Map()) + (v_j -> w)
            acc + (SRC -> row_src) + (v_i -> row_i)
          }
          case _ => throw UnsupportedOperationException()
      }
    )

  implicit class Crossable[X](xs: Iterable[X]) {
    def crossDiagonal(): Iterable[(X, X)] =
      for { (x, i) <- xs.zipWithIndex; (y, j) <- xs.zipWithIndex; if i < j } yield
        (x, y)
  }

  private def findBestPath(root: Path, paths: IndexedSeq[Path]): Path = {
    paths.crossDiagonal().foldLeft(root) { (acc, ps) =>
      val (p1, p2) = ps
      if (p1.canMerge(root, p2)) p1.merge(root, p2).best(acc) else acc
    }
  }

  def longestSpecialPath(
      edges: Array[Array[Int]],
      nums: Array[Int]
  ): Array[Int] = {
    val adj = adjacency(edges)
    println(adj)
    println(nums.mkString("Array(", ", ", ")"))
    def dfs(
        node: Int,
        visited: Set[Int],
        acc: Set[Int],
        len: Int,
    ): Path = {

      /**
        * node: current index in edges
        * acc: nums in the current path
        * len: current path length (summing edges weight)
        * count: number of nodes taken in current path
        */
      val num_i = if (node >= 0) nums(node) else SRC
      println(s"$node, $acc, $num_i, $len")
      val paths = for {
        (neigh, w) <- adj.getOrElse(node, Map()).toIndexedSeq;
        if !(visited contains neigh);
        if !(acc contains nums(neigh));
        if (nums(neigh) != num_i)
      } yield
        dfs(
          neigh,
          visited + node,
          acc + num_i,
          len + w,
        )

      val cur = Path(len, acc + num_i, visited + node)
      println(s"cur=$cur, paths=$paths")
      val best = findBestPath(cur, paths)
      println(s"best=$best")
      best
    }

    val path = dfs(adj.keys.head, Set(), Set(), 0)
    println(s"FINAL $path")
    // Remove 1 in node count to account for the source
    Array(path.len, Math.max(path.count - 1, 1))
  }
}
// Works for a relaxed definition of "downwards" graph (up until test ~50)
// Which, IMO, is not well defined in the description
//
//object Solution {
//
//  private val SRC = -1
//
//  /**
//   * Builds an undirected adjacency matrix
//   */
//  private def adjacency(edges: Array[Array[Int]]) =
//    edges.foldLeft(Map[Int, Map[Int, Int]]())(
//      (acc, cur) =>
//        cur match {
//          case Array(v_i, v_j, w) => {
//            val row_src = acc.getOrElse(SRC, Map()) + (v_i -> 0) + (v_j -> 0)
//            val row_i = acc.getOrElse(v_i, Map()) + (v_j -> w)
//            val row_j = acc.getOrElse(v_j, Map()) + (v_i -> w)
//            acc + (SRC -> row_src) + (v_i -> row_i) + (v_j -> row_j)
//          }
//          case _ => throw UnsupportedOperationException()
//        }
//    )
//
//  // Return "acc" if
//  //  1. It is longer than "cur"
//  //  2. They're the same length but "acc" contains fewer nodes
//  // Otherwise they're either equivalent longest special path or "cur" is better
//  private def resolveBestPath(
//                               cur: (Int, Int, Set[Int]),
//                               paths: IndexedSeq[(Int, Int, Set[Int])]
//                             ): (Int, Int, Set[Int]) =
//    paths.foldLeft(cur)(
//      (acc, cur) =>
//        if (acc._1 > cur._1 || (acc._1 == cur._1 && acc._2 < cur._2)) acc
//        else cur
//    )
//
//  def longestSpecialPath(
//                          edges: Array[Array[Int]],
//                          nums: Array[Int]
//                        ): Array[Int] = {
//    val adj = adjacency(edges)
//
//    def dfs(
//             node: Int,
//             visited: Set[Int],
//             acc: Set[Int],
//             len: Int,
//             count: Int
//           ): (Int, Int, Set[Int]) = {
//
//      /**
//       * node: current index in edges
//       * acc: nums in the current path
//       * len: current path length (summing edges weight)
//       * count: number of nodes taken in current path
//       */
//      val num_i = if (node >= 0) nums(node) else SRC
//      val paths = for {
//        (neigh, w) <- adj.getOrElse(node, Map()).toIndexedSeq;
//        if !(visited contains neigh);
//        if !(acc contains nums(neigh));
//        if (nums(neigh) != num_i)
//      } yield
//        dfs(
//          neigh,
//          visited + node,
//          acc + num_i,
//          len + w,
//          count + 1
//        )
//
//      val cur = (len, count + 1, acc)
//      resolveBestPath(cur, paths)
//    }
//
//    val (len, nb, acc) = dfs(adj.keys.head, Set(), Set(), 0, 0)
//    // Remove 1 in node count to account for the source
//    Array(len, Math.max(nb - 1, 1))
//  }
//}
