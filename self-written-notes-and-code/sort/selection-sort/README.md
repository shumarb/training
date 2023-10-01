# Selection Sort

## What is Selection Sort
Selection Sort is a **comparison-based, in-place, and unstable** sorting algorithm that works by selecting the smallest (or largest) element in the array and moves it to the sorted position for every iteration of the array.

## Worst-case Time Complexity
**O($N^2$)**.

Bubble Sort algorithm comprises of a nested loop. The outer loop iterates from the first element to the penultimate element of the array, and the inner loop iterates from the second element to the last element of the array. 

Hence, each loop iterates through `N - 1` elements.

Therefore, the Time Complexity is O((N - 1) * (N - 1)) = O($N^2$ - 2N + 1) = O($N^2$).

## Space Complexity
**O(1)**.

A constant amount of time of extra space is required.

## How to use this folder
1. Ensure that your local machine is configured with a `Java Development Kit (JDK) Version 8 or later`.
2. Compile the program by entering `javac SelectionSort.java`.
3. Run the program by entering `java SelectionSort`.
4. The program creates an array randomly. The elements are of type `integer`. The number of elements range from `5 to 12`, and the value elements range from `-10000 to 10000`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.
