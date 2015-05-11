


- for small arrays, use the insertion sort algorithm
- choose two pivot elements, p1 and p2
- if p1 is greater than p2, the two elements are swapped.
-

sort( array, leftPivotIndex, rightPivotIndex, work, workBase, workLenght)
	if (array.length < maximum_threshold_for_quicksort){
		quicksort(array);
        return;
    }
	int[] run = new int[MAX_RUN_COUNT + 1];
    //value of run[i] represents the starting index of the i'th run.
    		int count = 0; run[0] = left;


    if (rightPivotIndex - leftPivotIndex < 27){
        insertionSort(array);
        return;
    }

    int leftMedianIndex = (rightPivotIndex = leftPivorIndex) /
	check if the array is nearly sorted:

    if (array[currentIndex] != array[currentIndex + 1])
        increment currentIndex to the the last point <= rightPivotIndex
        at which array[currentIndex] >= array[currentIndex - 1]

    if (array[currentIndex] >  array[currentIndex + 1])


	if (value at current index < value at next index)
        two terms are ascending
        increment current index to the the last point at which its value is >= the preceding term

    if (value at current index > value at next index)
        two terms are descending
        increment current index to the the last point at which its value is >= the preceding term

	else
        two terms are equal


    merge subarrays:




int length = rightPivotIndex - leftPivotIndex + 1;

if (length < maximum_array_length_for_isertion_sort)
    insertionSort(array)

int seventhOfArrayLength = length / 7;

//select 7 evenly-spaced elements from the array
int index3 = midpoint of array
int index2 = index3 - seventhOfArrayLength;
int index1 = index2 - seventhOfArrayLength;
int index4 = index3 + seventhOfArrayLength;
int index5 = index4 + seventhOfArrayLength;

sort all elements in a temporary array using insertion sort.

int firstElementOfMiddlePartition = leftIndex;
int lastElementOfMiddlePartition  = rightIndex;

if (no two values of seven indecies are the same)
    let array[index2] and array[index4] be pivot points:
    pivot1 = array[index2];
    pivot2 = array[index4];

iterate through array, skipping values less than pivot1 and greater than pivot2:
    while (a[++firstElementOfMiddlePartition] < pivot1);
    while (a[--lastElementOfMiddlePartition]  > pivot2);
