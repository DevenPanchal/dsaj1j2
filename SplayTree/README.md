# Notes

1. We will splay, i.e cache for both insert or even find (find may be successful or unsuccessful). Delete can be implemented as you like. May be just normal BST deletion with 3 cases??

**Note** : We have implemented the recursiveInsert function to be as similar as possible to BST and AVL implementations. With that being said, you will be able to see where the changes are very easily. 

2. See the Node class for Splay tree. It has a pointer to its parent Node.
3. See how the SplayNode function itself performs all the adjustments of splaying and corrects the tree.
4. In the recursive approach, see how the recursion folds back taking only the 'most recent' node i.e the node on which the SplayNode function was called. 

5. See how the recursion is not responsible for setting any leftNode and RightNodes

6. See why we needed a parentNode variable. Reason: When the 'most recent' node was inserted, we needed to give it its parent. Hence we needed the parentNode variable. Alternatively, we could have passed along in the recursion a 3rd argument i.e parent of every Node, In that case insert would have looked like this-

	recursiveInsert(T newData, Node<T> node, Node<T> parentNode)


7. Also see how we need to tell its parent, whether the inserted node was left of right child of it. Why? Reason: becuase this parentNode.leftNode or parentNode.rightNode is used in the splayNode function.

So effectively, before passing the queried (found or newly inserted) node into the splayNode function, the following
design should be well defined.


        parentNode            parentNode           null             null
            \                     /                  \               /
            node                node                 node          node

If the parentNode of the queried (found or newly inserted) is null, then node is root node.


8. Verify all of these points 2-8 for the insert function  written using iterative approach. See how the while loop works in the find and iterativeInsert functions.

