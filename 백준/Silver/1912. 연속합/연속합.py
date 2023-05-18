n=int(input())
arr = list(map(int,input().split()))
d = [arr[0]]+[0]*(n-1)

for i in range(1,n):
  d[i] = max(arr[i],d[i-1]+arr[i])
print(max(d))