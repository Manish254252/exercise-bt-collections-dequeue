package com.stackroute.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class UniqueNumbersCounter {
    //write logic to find maximum unique numbers count from given array in the sub array of certain length
    public String findUniqueNumbersCount(int[] inputArray, int subArrayLength) {

//        if (inputArray == null || inputArray.length == 0 || subArrayLength <= 0 || subArrayLength > inputArray.length) {
//            return null;
//        }

        if(inputArray == null)
            return "Give proper input not null array";
        if(inputArray.length == 0)
            return "Give proper input not empty array";
        if(subArrayLength <= 0)
            return "Give proper input, sub array length can not be negative or zero";
        if(subArrayLength > inputArray.length)
            return "Give proper input, sub array length exceeds array length";

        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int maxCount = 0;

        for (int num : inputArray) {
            // Add the current element to the deque
            deque.offerLast(num);

            // Add the current element to the set
            set.add(num);

            // Remove elements from the front of the deque if the size exceeds k
            if (deque.size() > subArrayLength) {
                int removed = deque.pollFirst();
                if (!deque.contains(removed)) {
                    set.remove(removed);
                }
            }

            // Update the maximum count of unique numbers
            maxCount = Math.max(maxCount, set.size());
        }

        return "Count of Unique Numbers is "+maxCount;
    }
}
