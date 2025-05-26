## Problem Statement 1

Given pointers to the heads of two sorted linked lists, merge them into a single, sorted linked list. Either head pointer may be null meaning that the corresponding list is empty.

Example
refers to
refers to

The new list is

Function Description

Complete the mergeLists function in the editor below.

mergeLists has the following parameters:

SinglyLinkedListNode pointer headA: a reference to the head of a list
SinglyLinkedListNode pointer headB: a reference to the head of a list
Returns

SinglyLinkedListNode pointer: a reference to the head of the merged list
Input Format

The first line contains an integer , the number of test cases.

The format for each test case is as follows:

The first line contains an integer , the length of the first linked list.
The next lines contain an integer each, the elements of the linked list.
The next line contains an integer , the length of the second linked list.
The next lines contain an integer each, the elements of the second linked list.

Constraints

, where is the element of the list.
Sample Input

1
3
1
2
3
2
3
4
Sample Output

1 2 3 3 4
Explanation

The first linked list is:

The second linked list is:

Hence, the merged linked list is:

## Problem Statement 2

A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest) is always the first one to be removed.

A basic queue has the following operations:

Enqueue: add a new element to the end of the queue.
Dequeue: remove the element from the front of the queue and return it.
In this challenge, you must first implement a queue using two stacks. Then process queries, where each query is one of the following types:

1 x: Enqueue element into the end of the queue.
2: Dequeue the element at the front of the queue.
3: Print the element at the front of the queue.
Input Format

The first line contains a single integer, , denoting the number of queries.
Each line of the subsequent lines contains a single query in the form described in the problem statement above. All three queries start with an integer denoting the query , but only query is followed by an additional space-separated value, , denoting the value to be enqueued.

Constraints

It is guaranteed that a valid answer always exists for each query of type .
Output Format

For each query of type , print the value of the element at the front of the queue on a new line.

Sample Input

STDIN Function

---

10 q = 10 (number of queries)
1 42 1st query, enqueue 42
2 dequeue front element
1 14 enqueue 42
3 print the front element
1 28 enqueue 28
3 print the front element
1 60 enqueue 60
1 78 enqueue 78
2 dequeue front element
2 dequeue front element
Sample Output

14
14
Explanation

Perform the following sequence of actions:

Enqueue ; .
Dequeue the value at the head of the queue, ; .
Enqueue ; .
Print the value at the head of the queue, ; .
Enqueue ; .
Print the value at the head of the queue, ; .
Enqueue ; .
Enqueue ; .
Dequeue the value at the head of the queue, ; .
Dequeue the value at the head of the queue, ;

## Problem Statement 3

A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.

Function Description

Complete the function isBalanced in the editor below.

isBalanced has the following parameter(s):

string s: a string of brackets
Returns

string: either YES or NO
Input Format

The first line contains a single integer , the number of strings.
Each of the next lines contains a single string , a sequence of brackets.

Constraints

, where is the length of the sequence.
All chracters in the sequences ∈ { {, }, (, ), [, ] }.
Output Format

For each string, return YES or NO.

Sample Input

STDIN Function ----- -------- 3 n = 3 {[()]} first s = '{[()]}' {[(])} second s = '{[(])}' {{[[(())]]}} third s ='{{[[(())]]}}'

Sample Output

YES
NO
YES
Explanation

The string {[()]} meets both criteria for being a balanced string.
The string {[(])} is not balanced because the brackets enclosed by the matched pair { and } are not balanced: [(]).
The string {{[[(())]]}} meets both criteria for being a balanced string.
