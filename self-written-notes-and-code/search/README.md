# Search
This folder contains the search techniques that I implemented on my own.

Search Technique | Worst-case Time Complexity   | Sort elements before executing Search Technique?
-----------------|------------------------------|--------------------------------
[Binary Search](https://github.com/shumarb/learning-and-hackathons/tree/main/self-written-notes-and-code/search/binary-search)    | O(log<sub>2</sub>N)          | Yes
[Linear Search](https://github.com/shumarb/learning-and-hackathons/tree/main/self-written-notes-and-code/search/linear-search)    | O(N)                         | No

## How to use this folder
1. Ensure that your local machine contains a `Java Development Kit (JDK) Version 8 or later`.
2. Open up `terminal` of your local machine.
3. Identify a location to clone this repository, and navigate to this location.
4. Clone this repository by entering `git clone git@github.com:shumarb/learning-and-hackathons.git`.
5. Navigate to a folder containing a searching technique you are interested in by entering `cd search-technique-folder` (Example: `cd binary-search`).
6. Compile the Java code by entering `javac [search-technique-name].java`. (Example: `javac BinarySearch.java`).
6. Run the program by entering `java [search-technique-name]`. Example: `javac BinarySearch`.
7. The program creates an array randomly. This is to validate the correctness of the algorithm in all-possible cases. The elements are of type `integer`, and stored in an `array` (For `Binary Search`, the elements are `sorted` after being stored in the array). They number to search for is denoted `key`, which ranges from `-10 to 10`. The number of elements range from `5 to 12`, and the value elements range from `-10 to 10`. The program displays the array before the search, the steps of the binary search that occurs during during the iteration of the array, and the outcome on whether the key is found, and if found, which index in the `data structure (array or list)`it was found.
