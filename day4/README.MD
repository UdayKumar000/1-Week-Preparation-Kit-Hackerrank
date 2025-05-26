## Problem Statement 1

Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending. Determine if the columns are also in ascending alphabetical order, top to bottom. Return YES if they are or NO if they are not.

Example

The grid is illustrated below.

a b c
a d e
e f g
The rows are already in alphabetical order. The columns a a e, b d f and c e g are also in alphabetical order, so the answer would be YES. Only elements within the same row can be rearranged. They cannot be moved to a different row.

Function Description

Complete the gridChallenge function in the editor below.

gridChallenge has the following parameter(s):

string grid[n]: an array of strings
Returns

string: either YES or NO
Input Format

The first line contains , the number of testcases.

Each of the next sets of lines are described as follows:

- The first line contains , the number of rows and columns in the grid.
- The next lines contains a string of length

Constraints

Each string consists of lowercase letters in the range ascii[a-z]

Output Format

For each test case, on a separate line print YES if it is possible to rearrange the grid alphabetically ascending in both its rows and columns, or NO otherwise.

Sample Input

STDIN Function

---

1 t = 1
5 n = 5
ebacd grid = ['ebacd', 'fghij', 'olmkn', 'trpqs', 'xywuv']
fghij
olmkn
trpqs
xywuv
Sample Output

YES
Explanation

The x grid in the test case can be reordered to

abcde
fghij
klmno
pqrst
uvwxy
This fulfills the condition since the rows 1, 2, ..., 5 and the columns 1, 2, ..., 5 are all alphabetically sorted.

## Problem Statement 2

We define super digit of an integer using the following rules:

Given an integer, we need to find the super digit of the integer.

If has only digit, then its super digit is .
Otherwise, the super digit of is equal to the super digit of the sum of the digits of .
For example, the super digit of will be calculated as:

    super_digit(9875)   	9+8+7+5 = 29
    super_digit(29) 	2 + 9 = 11
    super_digit(11)		1 + 1 = 2
    super_digit(2)		= 2

Example

The number is created by concatenating the string times so the initial .

    superDigit(p) = superDigit(9875987598759875)
                  9+8+7+5+9+8+7+5+9+8+7+5+9+8+7+5 = 116
    superDigit(p) = superDigit(116)
                  1+1+6 = 8
    superDigit(p) = superDigit(8)

All of the digits of sum to . The digits of sum to . is only one digit, so it is the super digit.

Function Description

Complete the function superDigit in the editor below. It must return the calculated super digit as an integer.

superDigit has the following parameter(s):

string n: a string representation of an integer
int k: the times to concatenate to make
Returns

int: the super digit of repeated times
Input Format

The first line contains two space separated integers, and .

## Problem Statement 3

It is New Year's Day and people are in line for the Wonderland rollercoaster ride. Each person wears a sticker indicating their initial position in the queue from to . Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker. One person can bribe at most two others.

Determine the minimum number of bribes that took place to get to a given queue order. Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.

Example

If person bribes person , the queue will look like this: . Only bribe is required. Print 1.

Person had to bribe people to get to the current position. Print Too chaotic.

Function Description

Complete the function minimumBribes in the editor below.

minimumBribes has the following parameter(s):

int q[n]: the positions of the people after all bribes
Returns

No value is returned. Print the minimum number of bribes necessary or Too chaotic if someone has bribed more than people.
Input Format

The first line contains an integer , the number of test cases.

Each of the next pairs of lines are as follows:

- The first line contains an integer , the number of people in the queue
- The second line has space-separated integers describing the final state of the queue.

Constraints

Subtasks

For score
For score

Sample Input

STDIN Function

---

2 t = 2
5 n = 5
2 1 5 3 4 q = [2, 1, 5, 3, 4]
5 n = 5
2 5 1 3 4 q = [2, 5, 1, 3, 4]
Sample Output

3
Too chaotic
Explanation

Test Case 1

The initial state:

pic1(1).png

After person moves one position ahead by bribing person :

pic2.png

Now person moves another position ahead by bribing person :

pic3.png

And person moves one position ahead by bribing person :

pic5.png

So the final state is after three bribing operations.

Test Case 2

No person can bribe more than two people, yet it appears person has done so. It is not possible to achieve the input state.
