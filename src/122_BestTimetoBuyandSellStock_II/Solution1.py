class Solution:

    def maxProfit(self, prices: List[int]) -> int:

        n = len(prices)
        if n <2:
            return 0

        mps = [0 for i in range(n)]

        mmps = 0
        for i in range(1,n):
            for j in range(i):
                mps_j1 =  [ 0 if j-1<0 else mps[j-1]][0]
                p = max(prices[j+1:i+1]) - prices[j]
                if p>0:
                    mps[i] = max(mps[i], mps_j1+p)
            mmps = max(mps[i], mmps)
        return mmps

        
    def maxProfit(self, prices: List[int]) -> int:

        n = len(prices)
        if n <2:
            return 0

        mps = 0
        for j in range(1,n):
            r = prices[j]-prices[j-1]
            mps = [mps+r if r>0 else mps][0]
        return mps
