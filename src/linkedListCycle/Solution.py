class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None


class Solution:
	def hasCycle(self, head):
		ret = False
		ref = head
		cur = head
		if cur == None:
			return ret

		if cur.next == ref:
			ret = True
			return ret
		cur = cur.next

		while True:
			if cur == None:
				break

			if cur.next == ref:
				ret = True
				break

			next = cur.next
			cur.next = ref
			cur = next
		return ret


def main():

	su = Solution()

	head = ListNode(0)

	n1 = ListNode(1)
	head.next = n1
	n2 = ListNode(2)
	n1.next = n2
	n3 = ListNode(3)
	n2.next = n3
	n4 = ListNode(4)
	n3.next = n4

	n4.next = head



	print su.hasCycle(head)


if __name__ =='__main__':
	main()
