package com.peacefulotter.leetcode

import scala.annotation.tailrec

object p450_bst_remove {
  class TreeNode(_value: Int = 0,
                 _left: TreeNode = null,
                 _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  @tailrec
  private def min(root: TreeNode): TreeNode = root.left match {
    case null => root
    case left => min(left)
  }

  def deleteNode(root: TreeNode, key: Int): TreeNode = {
    if (root == null)
      return null

    if (key < root.value)
      root.left = deleteNode(root.left, key)
    else if (key > root.value)
      root.right = deleteNode(root.right, key)
    else if (root.left == null)
      return root.right
    else if (root.right == null)
      return root.left
    else {
      if (root.right == null)
        return null

      val mr = min(root.right)
      if (mr == null)
        return null

      root.value = mr.value
      root.right = deleteNode(root.right, mr.value)
    }
    root
  }
}
