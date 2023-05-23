import sys
n = int(sys.stdin.readline())
d=[[0,0,0] for _ in range(100000)]
d[0]=[1,0,0]
d[1]=[0,1,0]
d[2]=[1,1,1]

for i in range(3,100000):
    d[i]=[(d[i-1][1]+d[i-1][2])%1000000009,(d[i-2][0]+d[i-2][2])%1000000009, (d[i-3][0]+d[i-3][1])%1000000009]

for _ in range(n):
    k=int(sys.stdin.readline())
    print(sum(d[k-1])%1000000009)