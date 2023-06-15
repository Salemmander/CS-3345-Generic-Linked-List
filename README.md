# CS-3345-Generic-Linked-List

### Description

This is my implementation of a singly linked list with no sentinal nodes.  

Included methods are:  

**addFront(T d)** - Adds item d to the front of the list  
**addEnd(T d)** - adds item d to the end of the list  
**removeFront()** - removes the item at the front of the list  
**removeEnd()** - removes the item at the end of the list  
**toString()** - returns the list represented as a string  
**set(T d, int i)** - sets the value of the item at index i to d  
**get(int i)** - returns the value at index i  
**swap(int i, int j)** - swaps the items at indexs i and j  
**shift(int i)** - shifts the list i places to the right; If negative it will shift left.  
**removeMatching(T d)** - removes all instances of d from the list  
**erase(int index, int x)** - removes x number of items starting from the given index   
**insertList(List<T> list, int index)** - inserts the given list item into the list at the given index  

### How to Use

1. Download GenLinkedList.java
2. Open commandline
3. go to directory storing GenLinkedList.java
4. Use the following command to compile: javac GenLinkedList.java
5. Use the following command to run: java GenLinkedList

### Expected Output
Starting list: [ 0 ]  
Add End: [ 0 1 ]  
Add Front: [ 2 0 1 ]  
Remove End: [ 2 0 ]  
Remove Front: [ 0 ]  
___________________________________  

New Starting List: [ 0 1 2 3 4 5 6 7 8 9 ]  
Set: [ 60 1 2 3 4 5 6 7 8 9 ]  
Get: 60  
Swap: [ 1 60 2 3 4 5 6 7 8 9 ]  
___________________________________  

New Starting List: [ 1 2 3 4 5 6 7 8 9 ]  
Shift: [ 6 7 8 9 1 2 3 4 5 ]  
Shift: [ 1 2 3 4 5 6 7 8 9 ]  
___________________________________  

New Starting List: [ 0 5 1 5 2 5 3 5 4 5 5 5 6 5 7 5 8 5 9 ]  
Remove Matching: [ 0 1 2 3 4 6 7 8 9 ]  
Erase: [ 6 7 8 9 ]  
List to Insert: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]  
Insert List: [ 6 9 8 7 6 5 4 3 2 1 0 7 8 9 ]  
