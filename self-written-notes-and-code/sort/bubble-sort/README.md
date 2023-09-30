# Bubble Sort

## What is Bubble Sort
Bubble Sort is a **comparison-based, in-place, and stable** sorting algorithm that works by repeatedly swapping the adjacent elements if both these elements are in the wrong order.

## Worst-case Time Complexity
**O($N^2$)**, because the algorithm comprises of a nested loop. The outer loop iterates from the first element to the penultimate element of the array. Hence, the Time Complexity of the outer loop is O(N - 1) = O(N). The inner loop iterates from the second element to the last element of the array. Hence, the Time Complexity of the outer loop is O(N - 1) = O(N). Therefore, the Time Complexity of the nested loop is O(N * N) = O($N^2$).

## Space Complexity
**O(1)**, because only 1 variable is required as extra space.

## How to use this repository
1. Ensure that your local machine contains a Java Development Kit (JDK) from version 8 onwards.
2. Compile the program by entering `javac BubbleSort.java`.
3. Run the program by entering `java BubbleSort`.
4. The program creates an array randomly. The number of elements range from `7 to 12`, and the value elements range from `-10000 to 10000`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.
