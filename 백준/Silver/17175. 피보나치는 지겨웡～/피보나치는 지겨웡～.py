import sys
sys.setrecursionlimit(10**6)
n= int(input())
d={0:1,1:1,2:3}

def fibo(n):
    if n in d:
        return d[n]
    d[n]=fibo(n-1)+fibo(n-2)+1
    return d[n]

print(fibo(n)%1000000007)