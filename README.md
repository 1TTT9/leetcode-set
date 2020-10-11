Source codes (Java) for [leetcode](https://leetcode.com/)
---

[DOC]

#Description

Report to solved/unsolved algortithm problems on leetcode.com. Can Also check [my blog](http://danjog.blogspot.jp/) to see the tricks or pisfall while solving those problems.
Do not forget to categorize qustions by their types and chosen algorithms, moreover, analyze its solution, time complexity, approach(iteration/recursion), corner problem, etc.


#Records

- 2020/10/11
  ### [121 Best Time to Buy and Sell Stock](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)
    - 思路
     - 假設 a[i] 為 buy, 則 max{i+1,n} 為 sell 使得 profit 最大
     
  ### [122 Best Time to Buy and Sell Stock](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)
    - 注意
     - **根据题目的意思，当天卖出以后，当天还可以买入**，所以其实可以第三天卖出，第三天买入，第四天又卖出（（5-1）+ （6-5） === 6 - 1）。所以算法可以直接简化为只要今天比昨天大，就卖出。


- 2015/11/04
  ### #46 permutations
  - memo
    ### [47 permutation II]
    ### [46 try iteration solution, and pratice heap sort.]

- 2015/08/11
  ### valid palindrome
  ### is palindrome
  ### Validate Binary Search Tree
  ### two sum
  ### search for a range
  ### palindrome partitioning
  ### max points of a line
  ### maximum sub-array
  ### linked list cycle 2
  ### letter combinations of a phone number
  ### combination sum 2
  ### combination sum 3
  ### dungeon game
  ### invert binary tree
  ### balanced binary tree
  ### BST iterator

- 2015/07/30
  ### 142 Linked List Cycle II. [reference](http://blog.csdn.net/kenden23/article/details/13871699)

- 2015/03/23  
  ## [50 Pow(x,n), math, binary search]
  - memo
    ### [16  3sum Closest,  X + Y + Z ~ target]

- 2015/03/15
  ### [120 Triangle (medium), DP]
  ### [55 Jump Game (medium), Greedy]
  ### [78 Subset (medium)]
  ### [39 Combination Sum (medium)]
  - memo
    ### [4 Search for a Range (medium)]
    ### [16  3sum Closest,  X + Y + Z ~ target]
    ### [50   Pow(x,n), math, binary search]


#Comment

- 2015/03/15  From [StackOverFlow](http://stackoverflow.com/questions/3426843/what-is-the-default-initialization-of-an-array-in-java), it seems not to explicitly initialize the value to announced object, except local variable.