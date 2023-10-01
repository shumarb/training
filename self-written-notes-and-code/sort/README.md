# Sort

This repository contains sorting techniques that I implemented on my own.
Sort Technique | Worst-case Time Complexity | Space Complexity | In-place? | Stable?
------------------| ---------------------------| ---------------- | ----------| -------
[Merge Sort](https://github.com/shumarb/online-learning-and-hackathons/tree/main/self-written-notes-and-code/sort/merge-sort)                | O(Nlog<sub>2</sub>N)  | O(N) | No  | Yes
[Bubble Sort](https://github.com/shumarb/online-learning-and-hackathons/tree/main/self-written-notes-and-code/sort/bubble-sort)             | O($N^2$)      | O(1) | Yes | Yes
[Insertion Sort](https://github.com/shumarb/online-learning-and-hackathons/tree/main/self-written-notes-and-code/sort/insertion-sort)    | O($N^2$)     | O(1) | Yes | Yes
[Quick Sort](https://github.com/shumarb/online-learning-and-hackathons/tree/main/self-written-notes-and-code/sort/quick-sort)                | O($N^2$)      | O(1) | Yes | No
[Selection Sort](https://github.com/shumarb/online-learning-and-hackathons/tree/main/self-written-notes-and-code/sort/selection-sort)    | O($N^2$)      | O(1) | Yes | No

In-place sort: A sorting algorithm is an **in-place** sort if it requires only a **constant amount of time O(1) of extra space** during the sorting process.

Stable sort: A sorting algorithm is **stable** if the **relative order of elements with the same key value is preserved** by the algorithm.

## How to use this repository
1. Ensure that your local machine contains a `Java Development Kit (JDK) version 8 or later`.
2. Open up terminal.
3. Identify a location to clone this repository, and navigate to this location.
4. Clone this repository by entering `git clone git@github.com:shumarb/learning-and-hackathons.git`
5. Navigate to the `sort` folder by entering `cd sort`.
6. Navigate to a folder containing the sorting technique you are interested in. (Example: `cd selection-sort`).
7. Compile the Java code by entering `javac sort-technique.java`. (Example: `javac SelectionSort.java`).
8. Run the program by entering `java sort-technique`. (Example: `javac SelectionSort`).
9. The program creates an array randomly. This is to validate the correctness of the algorithm in all-possible cases. The elements are of type `integer`. The number of elements range from `5 to 12`, and the value elements range from `-1000 to 1000`. The program displays the array before the sort, the steps of the sort technique that occur during the iteration of the array, the array after the sort, and a side-by-side comparison of the array before and after the sort.
