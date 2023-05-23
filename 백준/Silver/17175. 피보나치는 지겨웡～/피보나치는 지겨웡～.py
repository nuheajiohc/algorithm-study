n = int(input())
d=[1,1,3]

for i in range(3,n+1):
    d.append(d[i-1]+d[i-2]+1)

print(d[n]%1000000007)