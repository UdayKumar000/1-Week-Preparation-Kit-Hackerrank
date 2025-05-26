## Problem Statement 1

Implement a simple text editor. The editor initially contains an empty string, . Perform operations of the following types:

append - Append string to the end of .
delete - Delete the last characters of .
print - Print the character of .
undo - Undo the last (not previously undone) operation of type or , reverting to the state it was in prior to that operation.
Example

operation
index S ops[index] explanation

---

0 abcde 1 fg append fg
1 abcdefg 3 6 print the 6th letter - f
2 abcdefg 2 5 delete the last 5 letters
3 ab 4 undo the last operation, index 2
4 abcdefg 3 7 print the 7th characgter - g
5 abcdefg 4 undo the last operation, index 0
6 abcde 3 4 print the 4th character - d
The results should be printed as:

f
g
d
Input Format

The first line contains an integer, , denoting the number of operations.
Each line of the subsequent lines (where ) defines an operation to be performed. Each operation starts with a single integer, (where ), denoting a type of operation as defined in the Problem Statement above. If the operation requires an argument, is followed by its space-separated argument. For example, if and , line will be 1 abcd.

Constraints

The sum of the lengths of all in the input .
The sum of over all delete operations .
All input characters are lowercase English letters.
It is guaranteed that the sequence of operations given as input is possible to perform.
Output Format

Each operation of type must print the character on a new line.

Sample Input

STDIN Function

---

8 Q = 8
1 abc ops[0] = '1 abc'
3 3 ops[1] = '3 3'
2 3 ...
1 xy
3 2
4
4
3 1
Sample Output

c
y
a
Explanation

Initially, is empty. The following sequence of operations are described below:

. We append to , so .
Print the character on a new line. Currently, the character is c.
Delete the last characters in (), so .
Append to , so .
Print the character on a new line. Currently, the character is y.
Undo the last update to , making empty again (i.e., ).
Undo the next to last update to (the deletion of the last characters), making .
Print the character on a new line. Currently, the character is a.

## Problem Statement 2

You have an infinite number of 4 types of lego blocks of sizes given as (depth x height x width):

d h w
1 1 1
1 1 2
1 1 3
1 1 4
Using these blocks, you want to make a wall of height and width . Features of the wall are:

- The wall should not have any holes in it.
- The wall you build should be one solid structure, so there should not be a straight vertical break across all rows of bricks.
- The bricks must be laid horizontally.

How many ways can the wall be built?

Example

The height is and the width is . Here are some configurations:

image

These are not all of the valid permutations. There are valid permutations in all.

Function Description

Complete the legoBlocks function in the editor below.

legoBlocks has the following parameter(s):

int n: the height of the wall
int m: the width of the wall
Returns

- int: the number of valid wall formations modulo

Input Format

The first line contains the number of test cases .

Each of the next lines contains two space-separated integers and .

Constraints

Sample Input

STDIN Function

---

4 t = 4
2 2 n = 2, m = 2
3 2 n = 3, m = 2
2 3 n = 2, m = 3
4 4 n = 4, m = 4
Sample Output

3  
7  
9  
3375
Explanation

For the first case, we can have:

image

For the second case, each row of the wall can contain either two blocks of width 1, or one block of width 2. However, the wall where all rows contain two blocks of width 1 is not a solid one as it can be divided vertically. Thus, the number of ways is and .

## Problem Statement 3

Jesse loves cookies and wants the sweetness of some cookies to be greater than value . To do this, two cookies with the least sweetness are repeatedly mixed. This creates a special combined cookie with:

sweetness Least sweet cookie 2nd least sweet cookie).

This occurs until all the cookies have a sweetness .

Given the sweetness of a number of cookies, determine the minimum number of operations required. If it is not possible, return .

Example

The smallest values are .
Remove them then return to the array. Now .
Remove and return to the array. Now .
Remove , return and .
Finally, remove and return to . Now .
All values are so the process stops after iterations. Return .

Function Description
Complete the cookies function in the editor below.

cookies has the following parameters:

int k: the threshold value
int A[n]: an array of sweetness values
Returns

int: the number of iterations required or
Input Format

The first line has two space-separated integers, and , the size of and the minimum required sweetness respectively.

The next line contains space-separated integers, .

Constraints

Sample Input

STDIN Function

---

6 7 A[] size n = 6, k = 7
1 2 3 9 10 12 A = [1, 2, 3, 9, 10, 12]  
Sample Output

2
Explanation

Combine the first two cookies to create a cookie with sweetness =
After this operation, the cookies are .
Then, combine the cookies with sweetness and sweetness , to create a cookie with resulting sweetness =
Now, the cookies are .
All the cookies have a sweetness .

Thus, operations are required to increase the sweetness.
