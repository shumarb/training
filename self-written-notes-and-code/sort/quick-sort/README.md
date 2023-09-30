# Quick Sort

## What is Quick Sort
Quick Sort is a **comparison-based, in-place, and unstable** divide-and-conquer sorting algorithm that works by selecting an element as a pivot, forming 2 partitions by shifting all elements smaller and larger than the pivot to the left and right of the pivot respectively, and recursively sorts these 2 partitions.

## Worst-case Time Complexity
**O(N^2)**.

The worst-case scenario is when the elements of the array are in reversed order. Hence, each of the N elements is selected as the pivot for each iteration, and a swap of elements occurs for each iteration. Hence, N elements are selected as the pivot N times.

Therefore, the time complexity is O(N * N) = O($N^2$).

## Space Complexity
**O(1)**.

Only 1 variable is required as extra space.

## How to use this folder
1. Ensure that your local machine contains a `Java Development Kit (JDK)` from `version 8 onwards`.
2. Compile the program by entering `javac QuickSort.java`.
3. Run the program by entering `java QuickSort`.
4. The program creates an array randomly. The elements are of type `integer`. The number of elements range from `5 to 12`, and the value elements range from `-10000 to 10000`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.
