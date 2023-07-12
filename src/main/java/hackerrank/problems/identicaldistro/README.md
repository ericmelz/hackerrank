# Identical Distribution
An e-commerce company specializes in cards with sports figures on them. Each sport has different categories of cards.
For instance, there might be more desirable cards with the most popular sports personalities, others with small pieces
of a player's jersey attached, and so on. They have a number of each category of card and want to make some number of
packets greater than 1 that each contain equal numbers of each type of card. To do this, they will add more cards of
each type until each type can be divided equally among some number of packets. Determine the minimum number of
additional cards needed to create a number of packets with equal type distribution.

## Example
```text
n = 5
cardTypes = [4, 7, 5, 11, 15]
```

In order to make 2 matching packets, the following numbers of additional cards of each type must be added: 
`[0, 1, 1, 1, 1]`. This sums to 4 additional cards. The numbers of cards are `[4, 8, 6, 12, 16]` and they can be divided
evenly among 2 packets. If 3 packets are created, an additional `[2, 2, 1, 1, 0]` cards are needed, sum = 6 items. This 
yields quantities `[6, 9, 6, 12, 15]`. Any number of packets ≥ 2 can be created, but creating 2 packets requires the
minimum number of additional cards.

## Function Description
Complete the function cardPackets in the editor below.

`cardPackets` has the following parameter(s):

`int cardTypes[n]:  the quantity available of card type`

## Constraints
* 1 <= n <= 10^5
* 1 <= cardTypes[i] <= 500

## Input format for Custom Testing
The first line contains an integer, n, the size of the cardTypes array.

Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer cardTypes[i].

## Sample Case 0
### Sample Input for Custom Testing
```text
STDIN    Function
-----    --------
5    →   cardTypes[] size n = 5
3    →   cardTypes = [3, 8, 7, 6, 4]
8
7
6
4
```

### Sample Output
```text
2
```

### Explanation
For 2 packets add: `[1, 0, 1, 0, 0]` (2 cards) to get `[4, 8, 8, 6, 4]`.



For 3 add `[0, 1, 2, 0, 2]` (5 cards) to get `[3, 9, 9, 6, 6]`.

## Sample Case 1
### Sample Input for Custom Testing
```text
STDIN    Function
-----    --------
6    →   cardTypes[] size n = 6
3    →   cardTypes = [3, 9, 7, 6, 5, 2]
9
7
6
5
2
```

### Sample Output
```text
4
```

### Explanation

To make 2 packets, add `[1, 1, 1, 0, 1, 0]` (4 additional cards) to get `[4, 10, 8, 6, 4]`.

For 3 packets, add `[0, 0, 2, 0, 1, 1]` (4 additional cards) to get `[3, 9, 9, 6, 6, 3]`.

Either of these solutions is minimal.
