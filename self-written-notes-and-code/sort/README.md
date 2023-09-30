# Sorting

This repository contains sorting techniques that I implemented on my own.
Sorting Technique | Worst-case Time Complexity | Space Complexity | In-place? | Stable?
------------------| ---------------------------| ---------------- | ----------| -------
[Merge Sort](https://github.com/shumarb/online-learning/tree/main/self-written-notes-and-code/merge-sort/MergeSort.java)                | O(Nlog(N))  | O(N) | No  | Yes
[Bubble Sort](https://github.com/shumarb/online-learning/tree/main/self-written-notes-and-code/bubble-sort/BubbleSort.java)             | O(N^2)      | O(1) | Yes | Yes
[Insertion Sort](https://github.com/shumarb/online-learning/tree/main/self-written-notes-and-code/insertion-sort/InsertionSort.java)    | O(N^2)      | O(1) | Yes | Yes
[Quick Sort](https://github.com/shumarb/online-learning/tree/main/self-written-notes-and-code/quick-sort/QuickSort.java)                | O(N^2)      | O(1) | Yes | No
[Selection Sort](https://github.com/shumarb/online-learning/tree/main/self-written-notes-and-code/selection-sort/SelectionSort.java)    | O(N^2)      | O(1) | Yes | No

In-place sort: A sorting algorithm is an **in-place** sort if it requires only a **constant amount of time (O(1)) of extra space** during the sorting process.
Stable sort: A sorting algorithm is **stable** if the **relative order of elements with the same key value is preserved** by the algorithm.

## How to use this repository
1. Ensure that your local machine contains a Java Development Kit (JDK) from version 8 onwards.
2. Clone this repository on your local machine.
2. Open up terminal.
3. Navigate to the location that this repository is stored.
4. Navigate to a folder containing a sorting technique you are interested in. (Example: 'cd selection-sort').
5. Compile the Java code by entering 'javac [sorting-technique-name].java'. (Example: 'javac SelectionSort.java').
6. Run the program by entering 'java [sorting-technique-name]'. Example: 'javac SelectionSort'
7. The program creates an array randomly. This is to validate the correctness of the algorithm in all-possible cases. The elements are of type 'integer'. The number of elements range from '7 to 12 (both inclusive)', and the value elements range from '-10000 to 10000 (both inclusive)'. The program displays the array before the sort, the steps of the sorting algorithm that occur during during the iteration of the array, the array after the sort, and a side-by-side comparison of the array before and after the sort.