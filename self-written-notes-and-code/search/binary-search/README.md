# Binary Search

## What is Binary Search
Binary Search is an efficient search algorithm that checks whether element is available in a `data structure (array or list)` by disregarding elements greater than or less than the key.

## How Binary Search Works
1. Ensure the `data structure (array or list)` is `searched`, and the element to search be denoted as `key`.
2. Check the `middle` element of the data structure.
3. If the `middle element == key`, the key exists in the data structure.
3. If the `middle element < key`, disregard `all elements <= middle element`, which is the `left half` of the data structure.
4. If the `middle element > key`, disregard `all elements >= middle element`, which is the `right half` of the data structure.
5. Repeat steps `2 to 5` until either the key is found or all elements have been discarded (meaning the key does not exist).

## Worst-case Time Complexity
**O(log<sub>2</sub>N)**.

This is because the portion of the list that could contain the element is repeatedly `divided` into half until it is of size `1`.

## How to use this folder
1. Ensure that your local machine contains a `Java Development Kit (JDK) Version 8 or later`.
2. Open up `terminal` of your local machine.
3. Identify a location to clone this repository, and navigate to this location.
4. Clone this repository by entering `git clone git@github.com:shumarb/learning-and-hackathons.git`.
5. Navigate to a folder containing the binary search technique by entering `cd binary-search`.
6. Compile the Java code by entering `javac BinarySearch.java`.
6. Run the program by entering `java BinarySearch`.
7. The program creates an array randomly. This is to validate the correctness of the algorithm in all-possible cases. The elements are of type `integer`, stored in an `array`, and `sorted`. They number to search for is denoted `key`, which ranges from `-10 to 10`. The number of elements range from `5 to 12`, and the value elements range from `-10 to 10`. The program displays the array before the search, the steps of the binary search that occurs during during the iteration of the array, and the outcome on whether the key is found, and if found, which index in the `data structure (array or list)`it was found.
