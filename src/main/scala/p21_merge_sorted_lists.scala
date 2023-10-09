package com.peacefulotter.leetcode

object p21_merge_sorted_lists {
    def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = (list1, list2) match {
        case (null, null) => null
        case (null, m) => new ListNode(m.x, mergeTwoLists(null, m.next))
        case (n, null) => new ListNode(n.x, mergeTwoLists(n.next, null))
        case (n, m) => (n.x, m.x) match {
            case (a, b) if a <= b => new ListNode(a, mergeTwoLists(n.next, m))
            case (_, b) => new ListNode(b, mergeTwoLists(n, m.next))
        }
    }
}
