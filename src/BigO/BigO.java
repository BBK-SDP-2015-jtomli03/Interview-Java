package BigO;

/*  Big O measures the efficiency of an algorithm based on the time it takes for the algorithm to run as a function of
    the input size, ie how well an algorithm scales according to the size of the dataset.
        http://bigocheatsheet.com/

    A hash table can insert and retrieve elements in O(1), ie constant time.
    An ArrayList can access objects in O(1).
    The input list could be 1 item or 1,000 items, but this function would still just require one "step".

    O(log n) - logarithmic complexity - occurs when the data size is roughly halved on each pass of the algorithm, eg binary search.
    V. efficient -> a large increase in data has little effect on the efficiency. So the time taken increases with the size
    of the data set, but not proportionately so. This means the algorithm takes longer per item on smaller data sets
    relative to larger ones, eg. 1 item takes 1s, 10 items take 2s, 100 items take 3s etc.
    A binary search tree can insert and retrieve elements in O(log(n)) -> still slower than O(1).

    O(n) is linear time, ie the time taken to run the algorithm increases in direct proportion to the number of input items.
    eg the retrieval of an item in a linked list.

    O(n log n) eg quicksort, mergesort;
        Comparisons = log n! //ie log n factorial
        Comparisons = log n + log(n - 1) + ....log(1)
        Comparisons = n log n // n times log n
    Usually where there's 2 parts to the sorting eg first part is O(n), and the second part is O(log n), combining to form O(n log n).
    eg mergesort; on each level of sorting (log n -> cos doubling the data only requires one extra level of sorting)
    a total of n operations takes place. This results in (n * log n) operations, e.g. O(n log n).


    O(n^2) - quadratic time - slow! eg two loops, eg bubblesort - we go through the list and compare each element with the one next
    to it, swapping the elements if they are out of order. At the end of the first iteration, we then start again from
    the beginning, with the caveat that we now know the last element is correct. However, best case of bubblesort is O(n)
    if the list to sort is already sorted.
        .....so O(n^3) would be if 3 "for" loops were nested, etc.

    O(2^n) - exponential growth - the algorithm takes twice as long for every new element added.

    ### ARRAYLIST VS LINKED LIST FOR GET ####

    ARRAYLIST = O(1)
    LINKED LIST = O(n)

    ### ARRAYLIST VS LINKED LIST FOR INSERTION ####

    ARRAYLIST - insertion at end of list average = O(1) because the computer already knows where the end of the list is
                          but worst case = O(n) because if the capacity of the arraylist has run out it will need to be
                                           resized prior to the insertion. If you know roughly how large your arraylist
                                           will be, then to try to improve performance so that insertions are O(1) by
                                           INITIALIZING the arraylist to the expected size so that it doesn't need to
                                           resize on insertion, or so that this will be an infrequent occurrence.
              - insertion anywhere else in the list = O(n)

    LINKED LIST - insertion at the beginning of the list = O(1) because we just need to change the pointer of the first
                        node to point to the new node, and the pointer of the new node to point to the old front node,
                        and move the "head" pointer.
                - insertion at the end of the list is exactly the same, O(1), ie change the node pointers, and move the
                        "tail" pointer to point to the new node.
                - insertion in the middle = O(n) as we have to search through the list to find the position.

    So, difference between ArrayList and LinkedList is that ArrayList is stored in a contiguous block of data, whereas
    the nodes of a linked list can be stored anywhere and we just need to change the pointers.

    ### ARRAYLIST VS LINKED LIST FOR DELETION ####

    ARRAYLIST - deletion at end of list = O(1), because we know the size of the arraylist and where the end is.
              - deletion of the first item = O(n) cos the other items need to be shifted down the list after.
              - deletion anywhere else = O(n) for the same reason.

    LINKED LIST - deletion at end of list = O(1), because no shifting needs to occur -> the pointers just need changing and
                    the "head" pointer needs to be moved.
                - deletion of the first item = O(1), for the same reason as deleting the first node.
                - deletion anywhere else = O(n) as we have to search through the list to find the node to delete.

LISTS AND SETS
Structure	        get	        add	        remove	    contains
ArrayList	        O(1)	    O(1)	    O(n)	    O(n)
LinkedList	        O(n)	    O(1)	    O(1)	    O(n)
HashSet	            O(1)	    O(1)	    O(1)	    O(1)
LinkedHashSet	    O(1)	    O(1)	    O(1)	    O(1)
TreeSet	            O(log n)	O(log n)	O(log n)	O(log n)

MAPS
Structure	        get	        put	        remove	    containsKey
HashMap	            O(1)	    O(1)	    O(1)	    O(1)
LinkedHashMap	    O(1)	    O(1)	    O(1)	    O(1)
TreeMap	            O(log n)	O(log n)	O(log n)	O(log n)
*/

public class BigO {





}
