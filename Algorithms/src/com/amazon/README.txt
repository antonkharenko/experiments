=== Approach 1 (implemented, optimized for space) ===

Description:
See code and javadoc :)

Complexities:
Average and worst runtime complexity: O(n^2)
Average and worst space complexity: O(1)
Space complexity is constant because we do not create any additional 
arrays which depends from given array length. So it's always constant
space complexity (in our case: 1 long, 2 int, 1 boolean). 
Runtime complexity is n^2 because we always traverse all array elements
for every element in the array. Actually it's possible to make some 
tweaks in such case to improve performance for some special cases, but 
while this approach is optimized for space it's not necessary as for me.  


=== Approach 2 (described, optimized for runtime) ===

Description:
Create temporary copy of array (in case if we can't change passed array). 
Sort this copy using merge sort. Traverse sorted array calculating count 
of each new integer value on the way and storing value and count of most 
common integer. Return multiplication of value and count of most common 
integer.
 
Complexities:
Average and worst runtime complexity: O(n*log(n))
Average and worst space complexity: O(n)
Complexities mostly the same as for merge sort algorithm except the fact that
we need to create copy of array (I am considering case when we can't change 
original array).

Appendix: 
Actually in such case we can tweak complexities using different 
sorting algorithms. Even dynamically if we will provide 
sorting algorithm to our Excercise class as a Strategy.