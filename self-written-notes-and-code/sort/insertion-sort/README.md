# Insertion Sort

## What is Insertion Sort
Insertion Sort is a **comparison-based, in-place, and stable** sorting algorithm that works by moving an element to its correct position for every iteration.

## Worst-case Time Complexity
**O(N^2)**.

The worst-case scenario is an array of elements initially in reverse order. Hence, every element is shifted to the other side `N -  1` times to the correct position. 

Therefore, the time complexity is O(N * (N - 1)) = O($N^2$ - N) = O($N^2$).

## Space Complexity
**O(1)**.

Only 1 variable is required as extra space.

## How to use this folder
1. Ensure that your local machine contains a `Java Development Kit (JDK)` from `version 8 onwards`.
2. Compile the program by entering `javac InsertionSort.java`.
3. Run the program by entering `java InsertionSort`.
4. The program creates an array randomly. The elements are of type `integer`. The number of elements range from `5 to 12`, and the value elements range from `-10000 to 10000`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.