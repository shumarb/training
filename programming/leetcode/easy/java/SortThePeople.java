class Solution {

    public void swap(String[] names, int[] heights, int i, int j) {
        int tempHeight = heights[i];
        String tempName = names[i];
        heights[i] = heights[j];
        names[i] = names[j];
        heights[j] = tempHeight;
        names[j] = tempName;
    }

    public void minHeapify(String[] names, int[] heights, int numberOfElements, int currentIndex) {
        int parentIndex = currentIndex;   
        int leftChildIndex = (2 * parentIndex) + 1;        
        int rightChildIndex = (2 * parentIndex) + 2;  
        
        // 1. Finds largest value between a parent and its children
        // First part of expression is to ensure no array out of bounds exception thrown
        if (leftChildIndex < numberOfElements && heights[leftChildIndex] < heights[parentIndex]) {
            parentIndex = leftChildIndex;
        }
        if (rightChildIndex < numberOfElements && heights[rightChildIndex] < heights[parentIndex]) {
            parentIndex = rightChildIndex;
        }

        // 2. If any of the children are larger than the parent, swap that child with the parent,
        // and MinHeapify the the array based on the largest element found so far
        if (parentIndex != currentIndex) {
            swap(names, heights, currentIndex, parentIndex);
            minHeapify(names, heights, numberOfElements, parentIndex);
        }
    }
    
    public String[] sortPeople(String[] names, int[] heights) {
        for (int i = heights.length - 1; i >= 0; i--) {
            minHeapify(names, heights, heights.length, i);
        }
        for (int i = heights.length - 1; i > 0; i--) {
            swap(names, heights, i, 0);
            minHeapify(names, heights, i, 0);
        }
        return names;
    }

}

