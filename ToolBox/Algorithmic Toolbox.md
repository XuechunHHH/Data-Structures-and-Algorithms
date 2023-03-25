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

A burglar breaks in a store with a bag has a maximum capacity of 15 kilograms and the items are all fractional. How to take the items to maximize the benefits?

##### Fractional knapsack

**Input: ** Weights $w_1,w_2,...,w_n$ and values $v_1,v_2,...,v_n$ of n items; capacity W.

**Output: ** The maximum total value of fractions of items that fit into a knapsack of capacity W.

##### Safe choice

Take as much as possible of an item with the maximal value per unit of weight.

##### Greedy Algorithm

- While knapsack is not full
- Choose item $i$ with maximum $\frac{v_i}{w_i}$
- If item fits into knapsack, take all of it
- Otherwise, take as much as possible to fill the knapsack
- Return total value and amounts taken

##### Code

```text
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

**Running time: ** BestItem is $O(n)$, Knapsack is $O(n^2).$

**Optimize: ** Sort $\frac{v_i}{w_i}$ by decreasing which is $O(logn)$. In this way, Knapsack is $O(nlogn).$
