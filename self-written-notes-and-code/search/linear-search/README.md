# Linear Search

## What is Linear Search
Linear Search, also known as `Sequential Search`, is a search algorithm that works by iterating through the data structure in `linear progression` and checking whether an element is equal to the element being searched.

## How Linaer Search Works
1. The element to search for is denoted as `key`.
2. Iterate through the `data stucture (array or list)`, and check one-by-one whether the element of the data structure is equal to the key.
3. If the `current element == key`, the key is found.
4. If the `current element != key`, proceed to the next element.

## Worst-case Time Complexity
`O(N)`.

This is because the worst-case scenario is to compare all elements of the list to the key.

## How to use this folder
1. Ensure that your local machine contains a `Java Development Kit (JDK) Version 8 or later`.
2. Open up `terminal` of your local machine.
3. Identify a location to clone this repository, and navigate to this location.
4. Clone this repository by entering `git clone git@github.com:shumarb/learning-and-hackathons.git`.
5. Navigate to a folder containing the binary search technique by entering `cd linear-search`.
6. Compile the Java code by entering `javac LinearSearch.java`.
6. Run the program by entering `java LinearSearch`.
7. The program creates an array randomly. This is to validate the correctness of the algorithm in all-possible cases. The elements are of type `integer`. They number to search for is denoted `key`, which ranges from `-10 to 10`. The number of elements range from `5 to 12`, and the value elements range from `-10 to 10`. The program displays the array before the search, the steps of the binary search that occurs during during the iteration of the array, and the outcome on whether the key is found, and if found, which index in the `data structure (array or list)`it was found.
