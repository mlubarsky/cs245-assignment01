# cs245-assignment01

Reading data file:
- While loop that reads in every line from the csv into an Array List. Then it takes out every individual tag and adds it into another Array List. Data structures used are the line list to store each line, and the tag list to store each tag. Run time O(n) because it is adding an element to a list for each line in the file. The end result is a list of all the tags from the file.

Frequency of tags:
- Calls quickSort function to sort the list of tags. Then it loops through this sorted list, and checks every tag. If the next tag encountered is new, adds it to a new list. If the next tag encountered is a duplicate, increments the count of the frequency list. Then it performs a series of for loop comparisons to find the tags with top 3 highest and lowest frequencies. Data structures used are the frequency list to store tag frequency, and the uniqueTags list to store each new tag. Run time O(n) due to the for loop which dominates the quick sort O(n log n) run time. The end result is a list of unique non-duplicate tags, and a list of that tags frequency with the indexes of both lists matching up.

Searching tags:
- Performs input validation, then asks for user input to search for the tag with the corresponding frequency, search for the tags with the specified count, or ends the  program. Data structures used are the frequency and uniqueTags lists passed in to the function call. Run time O(n) due to the for loop which compares each element in the list. End result varies on the user input.

Quick Sort:
- Creates a partition with a end pivot element to divide the list, and swap elements to sort them. Data structure used is the unsorted list passed into the function call. Run time O(n log n) due to the partition being made. End result is a sorted list.
