n,k = map(int,input().split())
coins = [int(input()) for _ in range(n)]
d = [0]*(k+1)
d[0]=1

for i in coins:
    for j in range(i,k+1):
        d[j]+=d[j-i]
print(d[-1])