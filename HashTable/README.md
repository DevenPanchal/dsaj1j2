
# Introduction:


See pics of differences between HashMap and HashTable provided by Java


<img src="HashMapvsHashTable.PNG" alt="drawing" />




<img src="HashMapvsHashTable2.PNG" alt="drawing" width="500" />


# Prime Numbers in Hashing

As you can see the examples: most of the hash-function implementations use the modulo (%) operator. This is how we make sure the index will be valid. But is it the best solution possible? The problem is a bit more complex. So if the data (distribution of keys) is random we are not able to reduce the number of collisions. So in these cases there is no point in using prime numbers.

Consider the set of keys K=[0,1,…,100] and the hashtable size is m=15. Ok let’s suppose we use mod (%) m as usual. Becasue 3 is a factor of 15, the keys that are multipliers of 3 will be hashed to buckets that are multipliers of 3.

keys [0,15,30…] will be hashed to bucket index 0

keys [3,18,33…] will be hashed to bucket index 3

keys [6,21,36…] will be hashed to bucket index 6

If the data is not random: we may reduce the number of collisions by using prime numbers. For example if the keys are more likely to be the multiplies of 3. In this case buckets that are not multipliers of 3 will be empty with high probability. Of course it is not good. We want to make sure the values are evenly distributed.

**Every key in K that shares a common factor with the number of buckets m will be hashed to a bucket that is a multiple of this factor**

So what can be the solution? We just have to **minimize the number of common factors between m and the elements of K.** Thats why we have to use prime numbers because it has very few factors. A large prime number is the best solution.
