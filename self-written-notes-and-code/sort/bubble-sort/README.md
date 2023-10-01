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

A constant amount of time of extra space is required.

## How to use this folder
1. Ensure that your local machine contains a `Java Development Kit (JDK) version 8 or later`.
2. Open up terminal.
3. Identify a location to clone this repository, and navigate to this location.
4. Clone this repository by entering `git clone git@github.com:shumarb/learning-and-hackathons.git`
5. Navigate to the `bubble-sort` folder by entering `cd bubble-sort`.
6. Compile the program by entering `javac BubbleSort.java`.
7. Run the program by entering `java BubbleSort`.
8. The program creates an array randomly. The elements are of type `integer`. The number of elements range from `5 to 12`, and the value elements range from `-10000 to 10000`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.
