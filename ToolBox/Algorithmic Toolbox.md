# Algorithmic Toolbox

## Week 2

### Fibonacci Number

#### Lemma

$$
F_{n}\geq 2^{\frac{n}{2}} \quad for \quad n\geq6
$$

#### Proof

$$
F_{n} = F_{n-1}+F_{n-2}\geq 2^{\frac{n-1}{2}}+2^{\frac{n-2}{2}} \geq 2\cdot2^{\frac{n-2}{2}} = 2^{\frac{n}{2}}
$$

#### Theorem

$$
F_{n}=\frac{1}{\sqrt{5}}\cdot((\frac{1+\sqrt{5}}{2})^{n}-(\frac{1-\sqrt{5}}{2})^{n})
$$

#### Compute $F_n$

Input: An integer $n\geq0$

Output: $F_n$

#### Definition


$$
F_{n} = 
\begin{cases}
0, & \text{n=0}\\
1, & \text{n=1}\\
F_{n-1}+F_{n-2}, & {n \geq 2 }
\end{cases}
$$

#### Algorithm

##### Recursion

```text
## FibRecurs(n)
if n<=1:
    return n
else:
    return FibRecurs(n-1) + FibRecurs(n-2)
```

##### Running Time

$$T(n) = 
\begin{cases}
2, & \text{if }{n\leq1}\\
T(n-1)+T(n-2)+3, & \text{else}
\end{cases}
$$

Therefore, $T(n)\geq F_n$ 

$T(100)\approx 1.77\times10^{21}$

##### ArrayList

```text
## FibList(n)
create an array F[0...n]
F[0] = 0
F[1] = 1
for i from 2 to n:
    F[i] = F[i-1] + F[i-2]
return F[n]
```

##### Running Time

$T(n) = 2n+2.$ So $T(100) = 202$.

Easy to compute

### Big-O Notation

<img src="C:\Users\百分之98\AppData\Roaming\Typora\typora-user-images\image-20230323174024154.png" alt="image-20230323174024154" style="zoom:33%;" />

<img src="C:\Users\百分之98\AppData\Roaming\Typora\typora-user-images\image-20230323174257972.png" alt="image-20230323174257972" style="zoom:53%;" />

#### Definition

$f(n)=O(g(n))$ ( if $f$ is Big-$O$ of $g$) or $f\preceq g$ if there exist constants N and c so that for all $n\geq N, f(n)\leq c\cdot g(n)$.

In other word, $f$ is bounded above by some constant multiple of $g$.

(Only asymptotic)

#### Common Rules

<img src="C:\Users\百分之98\AppData\Roaming\Typora\typora-user-images\image-20230323175804124.png" alt="image-20230323175804124" style="zoom:33%;" />

#### Big-$O$ Example

```text
## Operation                       ## Runtime
create an array F[0...n]            O(n)
F[0] = 0                            O(1)
F[1] = 1                            O(1)
for i from 2 to n:                  Loop O(n) times
    F[i] = F[i-1] + F[i-2]          O(n)
return F[n]                         O(1)
```

Total:

$O(n)+O(1)+O(1)+O(n)\cdot O(n) +O(1) = O(n^2)$

#### Other Notation

##### Definition

For functions $f, g: \mathbb{N} \rightarrow \mathbb{R^+}$ we say that:

- $f(n)=\Omega(g(n))$ or $f \succeq g$ if for some $c, f(n) \geq c\cdot g(n)$ ($f$ grows no slower than $g$)

-  $f(n)=\Theta(g(n))$ or $f \asymp g$ if $f=\Omega(g)$ and $f=O(g)$ ($f$ grows as the same rate as $g$)
- $f(n)=o(g(n))$ or $f \prec g$ if $f(n)/g(n) \rightarrow 0$ as $n \rightarrow \infty$ ($f$ grows slower than $g$)

### Pisano Period

In number theory, the *n*th **Pisano period**, written as **π**(*n*), is the period with which the sequence of Fibonacci numbers taken modulo *n* repeats. Pisano periods are named after Leonardo Pisano, better known as Fibonacci. 

| **$n$** | $\pi(n)$ | **cycle**                                                    |
| ------- | -------- | ------------------------------------------------------------ |
| 1       | 1        | 0                                                            |
| 2       | 3        | 011                                                          |
| 3       | 8        | 0112 0221                                                    |
| 4       | 6        | 011231                                                       |
| 5       | 20       | 01123 03314 04432 02241                                      |
| 6       | 24       | 011235213415 055431453251                                    |
| 7       | 16       | 01123516 06654261                                            |
| 8       | 12       | 011235 055271                                                |
| 9       | 24       | 011235843718 088764156281                                    |
| 10      | 60       | 011235831459437 077415617853819 099875279651673 033695493257291 |
| 11      | 10       | 01123582A1                                                   |
| 12      | 24       | 011235819A75 055A314592B1                                    |

The cycle is in range $[n,n^2]$

When $n=10$, the Pisano period is 60. The last digit of the sum of Fibonacci $S_n = (\sum\limits_{i=0}^n (F_i \quad mod \quad 10))  \quad mod \quad 10 = (\sum\limits_{i=0}^n F_i)  \quad mod \quad 10$ also has a period of 60. The last digit of the square sum of Fibonacci $S_n^{'} = (\sum\limits_{i=0}^n (F_i^2 \quad mod \quad 10)) \quad mod \quad 10 = (\sum\limits_{i=0}^n F_i^2)  \quad mod \quad 10$ also has a period of 60 too.

## Week 3

### Greedy Algorithm

#### Example

#### Queue Arrangement

**Input:** n patients have come to the doctor's office at 9:00AM. They can be treated in any order. For $i^{th}$ patient, the time needed for treatment is $t_i$. You need to arrange the patients in such a queue that the total waiting time is minimized.

**Output: ** The minimum total waiting time

###### Optimal Queue Arrangement

$t_1=15, t_2 = 20, t_3=10.$

Arrangement $(3,1,2)$:

- The first patient doesn't wait.
- The second patient waits for 10 minutes.
- The third patient waits for 10+15=25 minutes.
- The total waiting time is 10+25=35 minutes.

##### Greedy strategy

- Make some greedy choice.
- Reduce to a smaller problem.
- Iterate.

##### Subproblem

**Definition**: Subproblem is a similar problem of smaller size.

Minimum total waiting time for the $n^{th}$ patient: $(n-1)\cdot t_{min}$

##### Safe Choice

**Definition: ** A greedy choice is called a safe choice if there is an optimal solution consistent with this first choice.

##### Proof Idea

Is it possible for an optimal arrangement to have two consecutive patient in order with treatment time $t_1$ and $t_2$ such that $t_1>t_2$?

It is impossible. Assume there is such an optimal arrangement and consider that happens if we swap these two patients.

If we swap two consecutive patients with waiting time $t_1>t_2$:

- Waiting time for all the patients before and after these two don't change.
- Waiting time for the patient which was first increase by $t_2$, and for the second one it decrease by $t_2$.
- Total waiting time increases by $t_2-t_1<0,$ so it actually decreases.

We have just proved a **Lemma:**

In any optimal arrangement of the patients, first of any two consecutive patients has smaller treatment time.

**Safe choice proof:**

- Assume the patient with the treatment time $t_{min}$ is not the first.  
- Let $i>1$ be the position of the first patient with treatment time $t_{min}$ in the optimal arrangement.
- Then the patient at position $i-1$ has a bigger treatment time $\rightarrow$ **a contradiction**                         $\square$     

**Conclusion**

Now we know the following greedy algorithm works correctly:

- First treat the patient with the minimum treat time.
- Remove this patient from the queue.
- Treat all the remaining patients in such order as to minimize their total waiting time.  

##### Code

```text
## MinTotalWaitingTime(t,n)
waitingTime = 0
treated = array of n zeros
for i from 1 to n:
    t_min = MAX_INTEGER
    minIndex = 0
    for j from 1 to n:
        if treated[j] == 0 and t[j] < t_min:
            t_min = t[j]
            minIndex = j
     waitingTime += (n-1)*t_min
     treated[minIndex] = 1
return waitingTime
```

**Running time: $O(n^2)$**

**#**This problem can be solved in $O(nlogn)$ by sorting the patients by increasing treatment time.

##### General Strategy

- Make a greedy choice
- Prove that it is a safe choice
- Reduce to a subproblem

#### Celebration Party Problem

Many children come to a celebration party. Organize them into the minimum possible number of groups such that the age of any two children in the same group differs by at most two years.

##### Covering points by segments

**Input: ** A set of n points $x_1,x_1...,x_n \in \mathbb{R}.$

**Output: ** The minimum number of segments of length at most 2 needed to cover all the points.

##### Safe choice

Cover the leftmost point with a segment of length 2 which starts in this point.

<img src="C:\Users\百分之98\AppData\Roaming\Typora\typora-user-images\image-20230324165358507.png" alt="image-20230324165358507" style="zoom:43%;" />

#####  Greedy Algorithm

- Cover the leftmost point with a segment of length 2.
- Remove all the points within this segment.
- Solve the same problem with the remaining points.

##### Code

Assume $x_1<x_2<...<x_n$

```
## PointsCoveredSorted(x_1,x_2,...,x_n)
segmets = empty list
left = 1
while left <= n:
    (l,r) = (x_left,x_{left+2})
    segments.append((l,r))
    left ++
    while left <= n and x_left <= r:
    left++
return segments
```

**Running time: **$O(n)$ for PointsCoveredSorted and $O(nlogn)$ for sort the points.

Sort + PointsCoveredSorted is $O(nlogn)$.

#### Maximum Loot

A burglar breaks in a store with a bag can carry a maximum of 15 kilograms. How to take the goods to maximize the benefits?

##### Fractional knapsack

**Input: ** Weights $w_1,w_2,...,w_n$

**Output:**  The maximum total value of fractions of items that fit into a knapsack of capacity W.

### **Safe choice**

Take as much as possible of an item with the maximal value per unit of weight.

### **Greedy Algorithm**

- While knapsack is not full
- Choose item i with maximum $\frac{v_i}{w_i}$
- If item fits into knapsack, take all of it
- Otherwise, take as much as possible to fill the knapsack
- Return total value and amounts taken

### **Code**

```
## BestItem(w_1,v_1,w_2,v_2,...,w_n,v_n)
maxValuePerWeight = 0
bestItem = 0
for i from 1 to n:
    if w_i > 0:
        if v_i/w_i > maxValuePerWeight:
            maxValuePerWeight = v_i/w_i
            bestItem = i
return bestItem

## Knapsack(W,w_1,v_1,...,w_n,v_n)
amounts = [0,0,...,0]
totalValue = 0
repeat n times:
    if W==0:
        return (totalValue,amounts)
    i = BestItem(w_1,v_1,w_2,v_2,...,w_n,v_n)
    a = min(w_i,W)
    totalValue = totalValue + a*v_i/w_i
    w_i -= a
    amount[i] += a
    W -= a
return (totalValue,amounts)
```

**Running time:**  BestItem is $O(n)$ , Knapsack is $O(n^2)$ .

**Optimize:**  Sort $\frac{v_i}{w_i}$by decreasing which is $O(logn)$ . In this way, Knapsack is$O(nlogn).$

### Linear Search

#### Recursive Solution

```
## LinearSearch(A,low,high,key)
if high < low:
    return NOT_FOUND
if A[low] == key:
    return low
return LinearSearch(A,low+1,high,key)
```

##### Running Time

Recurrence defining worst-case time

$T(n) = T(n-1) + c$, $T(0) = c$

$T(n) = n\cdot c = O(n)$

#### Iterator version

```
## LinearSearchIt(A,low,high,key)
for i from low to high:
    if A[i] == key:
        return i
return NOT_FOUND
```

### Binary Search

#### Searching in a sorted array

**Input: **A sorted array $A[low,...,high]\quad\forall low\leq i <high: A[i]\leq A[i+1].$ A key k.

**Output: **An index, $i$ ,$low\leq i\leq high$ where $A[i]=k.$ Otherwise, the greatest index $i$, where $A[i]<k.$ Otherwise, $k<A[low]$, the result is $low-1.$ 

#### Recursive Solution

```
## BinarySearch(A,low,high,key)
if high < low:
	return NOT_FOUND
mid = roundDown((low + high) / 2)
if key = A[mid]:
    return mid
else if key < A[mid]:
    return BinarySearch(A,low,mid-1,key)
else:
    return BinarySearch(A,mid+1,high,key)
```

##### Running Time

Binary Search Recurrence Relationship:

$T(n) = T(\lfloor \frac{n}{2}\rfloor) + c = T(log_2n\cdot c) = T(logn)$

#### Iterator version

```
## BinarySearchIt(A,low,high,key)
while low <= high:
	mid = roundDown((low + high) / 2)
	if key = A[mid]:
    	return mid
    else if key < A[mid]:
    	high = mid - 1
    else:
    
```

### Polynomial Multiplication

#### Example

$A(x) = 3x^2+2x+5$

$B(x) = 5x^2+x+2$

$A(x)B(x) = 15x^4+13x^3+33x^2+9x+10$

#### Multiplying Polynomials

**Input: **Two $n-1$ degree polynomials: 

​            $a_{n-1}x^{n-1}+a_{n-2}x^{n-2}+...+a_1x+a_0$ and $b_{n-1}x^{n-1}+b_{n-2}x^{n-2}+...+b_1x+b_0$.

**Output:** The product polynomial:

​                $c_{2n-2}x^{2n-2}+c_{2n-3}x^{2n-3}+...+c_1x+c_0.$

​                where $c_{2n-2} = a_{n-1}b_{n-1}$,  $c_{2n-3}=a_{n-1}b_{n-2}+a_{n-2}b_{n-1}$, ... , $c_2 = a_2b_0+a_1b_1+a_0b_2$,                       	            $c_1=a_1b_0+a_0b_1$, $c_0=a_0b_0$.

##### Example

**Input: ** $n=3,A=(3,2,5), B=(5,1,2)$

##### Naïve Algorithm

```
## MultPoly(A,B,n)
product = array[2n-1]
for i from 0 to 2n-2:
	product[i] = 0
for i from 0 to n-1：
	for j from 0 to n-1:
		product[i+j] += A[i]*B[j]
return product
```

##### Running time

$O(n^2)$ 

##### Naïve Divide and Conquer Algorithm 

- Let $A(x) = D_1(x)x^{\frac{n}{2}}+D_0(x)$ where $D_1(x) = a_{n-1}x^{\frac{n}{2}-1}+a_{n-2}x^{\frac{n}{2}-2}+...+a_{\frac{n}{2}}$ and $D_0=a_{\frac{n}{2}-1}x^{\frac{n}{2}-1}+a_{\frac{n}{2}-2}x^{\frac{n}{2}-2}+...+a_0.$
- Let $B(x) = E_1(x)x^{\frac{n}{2}}+E_0(x)$ where $E_1(x) = b_{n-1}x^{\frac{n}{2}-1}+b_{n-2}x^{\frac{n}{2}-2}+...+b_{\frac{n}{2}}$ and $E_0=b_{\frac{n}{2}-1}x^{\frac{n}{2}-1}+b_{\frac{n}{2}-2}x^{\frac{n}{2}-2}+...+b_0.$
- $A(x)B(x) = (D_1(x)x^{\frac{n}{2}}+D_0(x))*(E_1(x)x^{\frac{n}{2}}+E_0(x))$ $= (D_1(x)E_1(x))x^n+(D_1(x)E_0(x)+D_0(x)E_1(x))x^{\frac{n}{2}}+D_0(x)E_0(x).$ 
- Calculate $D_1E_1,D_1E_0,D_0E_1,D_0E_0$

##### Recurrence

$T(n) = 4T(\frac{n}{2})+kn$

##### Example

$A(x) = 4x^3+3x^2+2x+1,$  $B(x)= x^3+2x^2+3x+4.$

$D_1(x) = 4x+3,$  $D_0(x) = 2x+1.$

$E_1(x) = x+2,$  $E_0(x) = 3x+4.$

$D_1E_1 = 4x^2+11x+6,$  $D_1E_0 = 12x^2+25x+12,$  $D_0E_1 = 2x^2+5x+2,$  $D_0E_0 = 6x^2+11x+4.$

$AB = (4x^2+11x+6)x^4+(12x^2+25x+12+2x^2+5x+2)x^2+6x^2+11x+4$

​        $=4x^6+11x^5+20x^4+30x^3+20x^2+11x+4$

##### Divide and Conquer Algorithm

```
## Mult2(A,B,n,a_l,b_l)
R = array[0,...,2n-1]
if n = 1:
	R[0] = A[a_l]*B[b_l]
	return R
D_1E_1 = R[0,...,n-2] = Mult2(A,B,n/2,a_l,b_l)
D_0E_0 = R[n-1,...,2n-2] = Mult2(A,B,n/2,a_l+n/2,b_l+n/2)
D_0E_1 = Mult2(A,B,n/2,a_l,b_l+n/2)
D_1E_0 = Mult2(A,B,n/2,a_l+n/2,b_l)
R[n/2,...,n+n/2-2] = D_0E_1 + D_1E_0
```

##### Running time

<img src="../AppData/Roaming/Typora/typora-user-images/image-20230329233006925.png" alt="image-20230329233006925" style="zoom:50%;" />

$O(n^2)$

#### Karatsuba Approach

$A(x) = a_1x+a_0$

$B(x)=b_1x+b_0$

$AB = a_1b_1x^2+(a_1b_0+a_0b_1)x+a_0b_0 = a_1b_1x^2+((a_1+a_0)(b_1+b_0)-a_1b_1-a_0b_0)x+a_0b_0$

4 Multiplication $\rightarrow$ 3 Multiplication

### Master Theorem

$T(n) = T(\frac{n}{2})+O(1) \rightarrow T(n) = O(logn)$

$T(n) = 4T(\frac{n}{2})+O(n)\rightarrow T(n) = O(n^2)$

#### Theorem

If $T(n)=aT(\lceil\frac{n}{b}\rceil)+O(n^d)$ for constant $a>0,b>1,d\geq0$​, then:
$$
T_{n} = 
\begin{cases}
O(n^d), & {if\quad d>log_ba}\\
O(n^dlogn), & {if \quad d=log_ba}\\
O(n^{log_ba}), & {if \quad d<log_ba}
\end{cases}
$$

#### Proof

$T(n) = O(n^d)+aO(\frac{n}{b})^d+...+a^iO(\frac{n}{b^i})^d+...+a^{log_bn} = O(n^d)+O(n^d)(\frac{a}{b^d})+...+O(n^d)(\frac{a}{b^d})^i+...+O(n^{log_ba})$

​          $= \sum_{i=0}^{log_bn}O(n^d)(\frac{a}{b^d})^i$ 

1. $d>log_ba\rightarrow \frac{a}{b^d}<1: T(n) = O(n^d)$
2. $d=log_ba\rightarrow \frac{a}{b^d}=1: T(n) = \sum_{i=0}^{log_bn}O(n^d)= O(n^dlogn)$
3. $d<log_ba\rightarrow \frac{a}{b^d}>1: T(n) = O(n^d)\cdot O(\frac{a}{b^d})^{log_bn} = O(a^{log_bn})=O(n^{log_ba})$

### Sorting Problem

**Input: ** Sequence $A[1,2,...,n].$

**Output: ** Permutation $A'[1,2,...n]$ of $A[1,2,...,n]$ in non-decreasing order.

#### Selection sort

- Find a minimum by scanning the array
- Swap it with the first element
- Repeat with the remaining part of the array

##### Properties

- not stable
- $O(1)$ extra space
- $O(n^2)$ comparisons

##### Running time

$O(n^2)$

#### Merge sort

- split the array into two halves
- sort the halves recursively
- merge the sorted halves into one array

##### Code

```
## MergeSort(A[1,2,...,n])
if n == 1:
	return A
m = n/2
L = MergeSort(A[1,2,...,m])
R = MergeSort(A[m+1,...,n])
A' = Merge(L,R)
return A'
```

##### Properties

- $O(n)$ extra space
- $O(nlogn)$ comparisons

##### Running time

$T(n) \leq 2T(\frac{n}{2}) + O(n)$

$O(n^2)$

#### Lowest bound for Comparison based sorting

- The tree leaf (minimum of comparisons) is $n!$
- The depth of tree is d
- The minimum of d is $log_2n!$ (Balanced Binary Search Tree)

$log_2n!  = log_21+log_22+...+log_2n \geq log_2\frac{n}{2}+...+log_2n\geq \frac{n}{2}log_2{\frac{n}{2}} = \Omega(nlogn)$

#### Non-comparison based Sorting Algorithm

Count the occurrences of each number in the array (we already know what the array contains)

##### Running time

$O(n)$

#### Quick sort

##### Properties

- comparison base algorithm
- running time $O(nlogn)$ (on average)
- efficient in practice

##### Coding

```
## QuickSort(A,l,r)
if l >= r:
	return
m = Partition(A,l,r)
// A[m] is in the final position
QuickSort(A,l,m-1)
QuickSort(A,m+1,r)
```

```
## Partition(A,l,r)
x = A[l]  // pivot
j = l
for i from l+1 to r:
	if A[i] <= x:
		j += 1
		swap A[j] and A[i]
		//   A[l+1,...,j] <= x, A[j+1,...,i] > x
swap A[j] and A[l]
return j
```

##### Running time

**Unbalanced partition**

- In ascending or descending order:

$T(n) = n+T(n-1) = n+(n-1)+(n-2)+...=O(n^2)$

**Balanced partition**

- In arbitrary order：

$T(n) = 2T(\frac{n}{2})+n = O(nlogn)$

##### Select the pivot randomly to make the partition more balanced

```
## RandomizedQuickSort(A,l,r)
if l >= r:
	return
k = random number between l and r
swap A[l] and A[k]
m = Partition(A,l,r)
// A[m] is in the final position
QuickSort(A,l,m-1)
QuickSort(A,m+1,r)
```

##### Running time analysis

- Let, for $i<j$,
  $$
  \chi_{ij} = 
  \begin{cases}
  
  1, & {A'[i]\quad and\quad A'[j] \quad are \quad compared}\\
  0, & {otherwise}
  \end{cases}
  $$

- For all $i$ and $j$, A'[i] and A'[j] are either compared exactly once or not compared at all (as we just compare with a pivot)

- This, in particular, implies that the worst case running time is $O(n^2)$

- Crucial observation: $\chi_{ij}=1$ if the first selected pivot in A'[i...j] is A'[i] or A'[j]

- Then $Prob(\chi_{ij})= \frac{2}{j-i+1}$ and $E(\chi_{ij})= \frac{2}{j-i+1}$

- The expected value of the running time is 
  $$
  \begin{aligned}
  E\sum_{i=1}^n\sum_{j=i+1}^n\chi_{ij} &= \sum_{i=1}^n\sum_{j=i+1}^nE(\chi_{ij})\\
  &=\sum_{i<j}\frac{2}{j-i+1}\leq2n\cdot (\frac{1}{2}+\frac{1}{3}+...+\frac{1}{n})\\
  &=O(nlonn)
  \end{aligned}
  $$

##### Equal elements

If there are few unique elements in the array, the running order is nearly $O(n^2)$

**Optimize:**

$(m_1,m_2) \leftarrow Partition3(A,l,r)$ such that:

- for all $l\leq k\leq m_1-1, A[k]<x$
- for all $m_1\leq k\leq m_2, A[k]=x$
- for all $m_2+1\leq k\leq r, A[k]>x$

