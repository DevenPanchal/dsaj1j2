# Introduction

#### Heap Properties

Read about Heap Properties, Max Heap, Min Heap from Holczer balazs ppt, watch videos.

#### Max Heap

#### Min Heap

#### Clarifications


What we have implemented here is the MAX Heap.
We have implemented the Heap Abstract Data Structure using an Array. So please think of insert/delete from an Array


<img src="Heap-Array.JPG" alt="drawing" />

Valid Heap is checked using HEAPIFY.
HEAPIFY is implemented here using fixUp() and fixDown(). Both implement HEAPIFY.
In cases of insertion, we HEAPIFY using fixUp() starting with the newly inserted node and then moving up.
In cases of deletion - i.e deletion of root, we HEAPIFY using fixDown() starting with the replacement root. By the way- if the root gets deleted, the new replacement root is the last element.


The Heap Sort which has been implemented as -

- HEAPIFY(fix Down)  -> this will not be needed for a valid heap uptil that point.
- SWAP LAST ITEM WITH ROOT
- NEGLECT THE LAST ITEM i.e that is the item bubbling out. This neglecting leads to sorting
- REPEAT


The fixUp and fixDown methods have both been written in a recursive fashion. 

For iterative approach for fixUp, fixDown see LinkedIn Learning code. But that does not yield accurate results. So we haven't included it here.

#### Functions

  - Insert - Insert an item. Inserts always happen to fill top-down, left to right.
 
  
 - Delete root - gets the root. root is Max in case of Max heap. and Min in case of Min heap.
 
 
 - Delete any item - mostly heaps are implemented for the very purpose that you will need to delete/get the root which is the max in max heap. So more important here is to delete the root.
 But any item can also be deleted by searching for it and deleting it. And following the same procedure we follow for Deleting the root. In the fixDown function pass the appropriate index of the deleted node.
 
 
 - getMax/getRoot- only gets the Max. more like peeking. does not delete it.
 
 
 - heapSort - Discussed above

#### Time Complexities of various Heaps


<img src="image0.JPG" alt="drawing" />

#### Code: Read Holczer Comments too.

<img src="image1.png" alt="drawing" />


<img src="image2.png" alt="drawing" />


<img src="image3.png" alt="drawing" />


<img src="image4.png" alt="drawing" />


<img src="image5.png" alt="drawing"/>



#### Results


<img src="image6.JPG" alt="drawing" />


<img src="image7.JPG" alt="drawing" />





