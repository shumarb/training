# Quick Sort

## What is Quick Sort
Quick Sort is a **comparison-based, in-place, and unstable** divide-and-conquer sorting algorithm that works by selecting an element as a pivot, forming 2 partitions by shifting all elements smaller and larger than the pivot to the left and right of the pivot respectively, and recursively sorts these 2 partitions.

## Worst-case Time Complexity
**O(N^2)**, because the worst-case scenario is when the elements of the array are in reversed order, hence Quick Sort has to be implemented on N elements.

## Space Complexity
**O(1)**, because 1 variable is required as extra space.

## How to use this repository
1. Ensure that your local machine contains a Java Development Kit (JDK) from version 8 onwards.
2. Compile the program by entering 'javac QuickSort.java'.
3. Run the program by entering 'java QuickSort'.
4. The program creates an array randomly. The number of elements range from '7 to 12 (both inclusive)', and the value elements range from '-10000 to 10000 (both inclusive)'. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.