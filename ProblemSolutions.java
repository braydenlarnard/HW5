/******************************************************************
 *
 *   Brayden Larnard / 272-002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE
        // Initialize a hash table
        Map<Integer, Integer> table = new Hashtable<>();
        
        // Add all elements from list1 to hashtable
        for (int num : list1) {
            table.put(num, 1);
        }

        // Check if all elements in list2 are in hashtable
        for (int item : list2) {
            if (!table.containsKey(item)) {
                return false;
            }
        }

        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE
        // Initialize a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements to the priority queue
        for (int num : array) {
            pq.add(num);
            // If the size of the queue gets larger than k, remove the smallest element
            // This makes sure the queue only contains the largest k elements
            if (pq.size() > k) {
                pq.poll(); 
            }
        }

        // The root of the queue should be the kth largest element
        return pq.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE
        // Initialize a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add each item from both lists to the priority queue
        for (int item : array1) {
            pq.add(item);
        }
        for (int item : array2) {
            pq.add(item);
        }

        int[] result = new int[array1.length + array2.length]; // Initialize sorted to length of both arrays

        // Add the sorted elements to the result array
        for (int i = 0; i < result.length; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

}