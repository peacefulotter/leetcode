package com.peacefulotter.leetcode

class FunBST[K, V](implicit ord: Ordering[K]) {
  private sealed trait Tree[K_, V_]
  private case object Leaf extends Tree[K, V]

  private case class Branch[K_, V_](
      left: Tree[K, V],
      right: Tree[K, V],
      k: K,
      v: V
  ) extends Tree[K, V]

  @annotation.tailrec
  private def find(t: Tree[K, V], key: K): Option[V] = t match {
    case Leaf => None
    case Branch(l, r, k, v) =>
      if (ord.equiv(k, key)) Some(v)
      else if (ord.lt(key, k)) find(l, key)
      else find(r, key)
  }

  private def insert(t: Tree[K, V], key: K, value: V): Tree[K, V] = t match {
    case Leaf                                      => Branch(Leaf, Leaf, key, value)
    case Branch(l, r, k, v) if (ord.equiv(k, key)) => Branch(l, r, k, value)
    case Branch(l, r, k, v) if (ord.lt(key, k)) =>
      Branch(insert(l, key, value), r, k, v)
    case Branch(l, r, k, v) => Branch(l, insert(r, key, value), k, v)
  }
}
