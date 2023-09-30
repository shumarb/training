# Bubble Sort

## What is Bubble Sort
Bubble Sort is a **comparison-based, in-place, and stable** sorting algorithm that works by repeatedly swapping the adjacent elements if both these elements are in the wrong order.

## Worst-case Time Complexity
**O($N^2$)**.

Bubble Sort algorithm comprises of a nested loop. The outer loop iterates from the first element to the penultimate element of the array, and the inner loop iterates from the second element to the last element of the array. 

Hence, each loop iterates through `N - 1` elements.

Therefore, the Time Complexity is O((N - 1) * (N - 1)) = O($N^2$ - 2N + 1) = O($N^2$).

## Space Complexity
**O(1)**.

Only 1 variable is required as extra space.

## How to use this folder
1. Ensure that your local machine contains a `Java Development Kit (JDK)` from `version 8 onwards`.
2. Compile the program by entering `javac BubbleSort.java`.
3. Run the program by entering `java BubbleSort`.
4. The program creates an array randomly. The elements are of type `integer`. The number of elements range from `5 to 12`, and the value elements range from `-10000 to 10000`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.
