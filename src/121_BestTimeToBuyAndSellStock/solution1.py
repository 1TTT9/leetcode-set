class Solution:

    def getmax(self, ss, i, j):
        smax = 0
        for s in ss[i:j]:
            if s>smax:
                smax = s
        return smax

    def maxProfit(self, prices: List[int]) -> int:

        n = len(prices)
        if n<2:
            return 0

        ptmax = 0
        for i in range(0, n):
            b = prices[i]
            pt = self.getmax(prices, i+1, n) - b
            if pt > ptmax:
                ptmax = pt

        return ptmax


    def maxProfit(self, prices: List[int]) -> int:

        n = len(prices)
        if n<2:
            return 0

        ptmax = 0
        for i in range(n-1):
            b = prices[i]
            s = max(prices[i+1:])
            ptmax = max(ptmax, s-b)

        return ptmax