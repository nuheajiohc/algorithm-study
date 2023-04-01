import sys

T = int(input())
result=""
for i in range(T):
    a,b=map(int, sys.stdin.readline().split())
    print(a+b)
