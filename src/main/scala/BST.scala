package com.peacefulotter.leetcode

import scala.annotation.tailrec

class BST(var v: Int,
          var left: Option[BST] = None,
          var right: Option[BST] = None) {

  def find(elem: Int): Option[BST] = find(elem, this)
  def insert(elem: Int): BST = insert(elem, this)
  def remove(elem: Int): Option[BST] = remove(Some(this), elem)
  def print(): String = print(Some(this), depth = 1)

  @tailrec
  private def find(elem: Int, root: BST): Option[BST] =
    if (root.v == elem) Some(root)
    else if (root.v > elem && root.left.isDefined) find(elem, root.left.get)
    else if (root.v < elem && root.right.isDefined) find(elem, root.right.get)
    else None

  private def insert(elem: Int, root: BST): BST = {
    if (elem > root.v) root.right match {
      case Some(r) ⇒ insert(elem, r)
      case None ⇒ root.right = Some(BST(elem))
    } else if (elem < root.v) root.left match {
      case Some(l) ⇒ insert(elem, l)
      case None ⇒ root.left = Some(BST(elem))
    }
    this
  }

  @tailrec
  private def min(root: BST): Option[BST] = root.left match {
    case Some(l) => min(l)
    case None    => Some(root)
  }

//  @tailrec
//  private def findWithParent(parent: BST,
//                             node: Option[BST],
//                             elem: Int): (BST, Option[BST]) = {
//    node match {
//      case _ if parent.v == elem ⇒ (parent, Some(parent))
//      case Some(n) if n.v == elem ⇒ (parent, node)
//      case Some(n) if n.v < elem ⇒ findWithParent(n, n.right, elem)
//      case Some(n) if n.v > elem ⇒ findWithParent(n, n.left, elem)
//      case _ ⇒ (parent, None)
//    }
//  }

  private def remove(root: Option[BST], elem: Int): Option[BST] = root match {
    case None ⇒ None
    case Some(node) ⇒
      if (elem < node.v)
        node.left = remove(node.left, elem)
      else if (elem > node.v)
        node.right = remove(node.right, elem)
      else {
        if (node.left.isEmpty)
          return node.right
        else if (node.right.isEmpty)
          return node.left

        node.right match {
          case Some(r) ⇒
            min(r) match {
              case Some(mr) ⇒
                node.v = mr.v
                node.right = remove(node.right, mr.v)
              case _ ⇒ return None
            }
          case _ ⇒ return None
        }
      }
      root
  }

  private val DEPTH_INCREASE = 4

  def print(root: Option[BST], depth: Int): String =
    root match {
      case Some(r) ⇒
        val d = depth + r.v.toString.length
        val top = print(r.right, d + DEPTH_INCREASE)
        val mid = "-".repeat(depth) + f" ${r.v}"
        val bot = print(r.left, d + DEPTH_INCREASE)
        (if (top != "") then(top + "\n") else top) + mid + (if (bot != "")
                                                              then("\n" + bot)
                                                            else bot)
      case None ⇒ ""
    }

  override def toString: String = f"v=${v}"
}
