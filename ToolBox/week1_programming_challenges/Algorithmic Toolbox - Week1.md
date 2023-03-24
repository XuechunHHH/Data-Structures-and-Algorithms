# Algorithmic Toolbox - Week2

## Fibonacci Number

### Lemma

$$
F_{n}\geq 2^{\frac{n}{2}} \quad for \quad n\geq6
$$

###  Proof 

$$
F_{n} = F_{n-1}+F_{n-2}\geq 2^{\frac{n-1}{2}}+2^{\frac{n-2}{2}} \geq 2\cdot2^{\frac{n-2}{2}} = 2^{\frac{n}{2}}
$$

### Theorem

$$
F_{n}=\frac{1}{\sqrt{5}}\cdot((\frac{1+\sqrt{5}}{2})^{n}-(\frac{1-\sqrt{5}}{2})^{n})
$$

### Compute $F_n$

Input: An integer $n\geq0$

Output: $F_n$

### Definition


$$
F_{n} = 
\begin{cases}
0, & \text{n=0}\\
1, & \text{n=1}\\
F_{n-1}+F_{n-2}, & {n \geq 2 }
\end{cases}
$$

### Algorithm

#### Recursion

```text
## FibRecurs(n)
if n<=1:
    return n
else:
    return FibRecurs(n-1) + FibRecurs(n-2)
```

#### Running Time

$$T(n) = 
\begin{cases}
2, & \text{if }{n\leq1}\\
T(n-1)+T(n-2)+3, & \text{else}
\end{cases}
$$

Therefore, $T(n)\geq F_n$ 

$T(100)\approx 1.77\times10^{21}$

#### ArrayList

```text
## FibList(n)
create an array F[0...n]
F[0] = 0
F[1] = 1
for i from 2 to n:
    F[i] = F[i-1] + F[i-2]
return F[n]
```

#### Running Time

$T(n) = 2n+2.$ So $T(100) = 202$.

Easy to compute

## Big-O Notation

<img src="C:\Users\百分之98\AppData\Roaming\Typora\typora-user-images\image-20230323174024154.png" alt="image-20230323174024154" style="zoom:33%;" />

<img src="C:\Users\百分之98\AppData\Roaming\Typora\typora-user-images\image-20230323174257972.png" alt="image-20230323174257972" style="zoom:33%;" />

### Definition

$f(n)=O(g(n))$ ( if $f$ is Big-$O$ of $g$) or $f\preceq g$ if there exist constants N and c so that for all $n\geq N, f(n)\leq c\cdot g(n)$.

In other word, $f$ is bounded above by some constant multiple of $g$.

(Only asymptotic)

### Common Rules

<img src="C:\Users\百分之98\AppData\Roaming\Typora\typora-user-images\image-20230323175804124.png" alt="image-20230323175804124" style="zoom:33%;" />

### Big-$O$ Example

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

### Other Notation

#### Definition

For functions $f, g: \mathbb{N} \rightarrow \mathbb{R^+}$ we say that:

- $f(n)=\Omega(g(n))$ or $f \succeq g$ if for some $c, f(n) \geq c\cdot g(n)$ ($f$ grows no slower than $g$)

-  $f(n)=\Theta(g(n))$ or $f \asymp g$ if $f=\Omega(g)$ and $f=O(g)$ ($f$ grows as the same rate as $g$)
- $f(n)=o(g(n))$ or $f \prec g$ if $f(n)/g(n) \rightarrow 0$ as $n \rightarrow \infty$ ($f$ grows slower than $g$)
