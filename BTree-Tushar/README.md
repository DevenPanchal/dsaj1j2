# BTree

<iframe width="560" height="315" src="https://www.youtube.com/embed/aZjYr87r1b8?controls=0&amp;start=1515&end=1640" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>


## Introduction

https://www.geeksforgeeks.org/introduction-of-b-tree-2/

## Insertion

Refer to https://www.geeksforgeeks.org/insert-operation-in-b-tree/

1) Initialize x as root.

2) While x is not leaf, do following

..a) Find the child of x that is going to be traversed next. Let the child be y.

..b) If y is not full, change x to point to y.

..c) If y is full, split it and change x to point to one of the two parts of y. If k is smaller than mid key in y, then set x as the first part of y. Else second part of y. When we split y, we move a key from y to its parent x.

3) The loop in step 2 stops when x is leaf. x must have space for 1 extra key as we have been splitting all nodes in advance. So simply insert k to x.


<img src="BTreeSplit.jpg" alt="drawing" width="500" rotate="90"/>

## Deletion
 Deletion Not discussed in this code.
 
 But Refer to https://www.geeksforgeeks.org/delete-operation-in-b-tree/ for Algorithm and C++ code