n,m = map(int,input().split())

vis = [0]*9
arr = [0]*8
ans = []
def dfs(k):
    if k==m:
        ans.append(arr[:m])

    for i in range(1,n+1):
        if vis[i] or i<arr[k-1]:
            continue
        vis[i]=1
        arr[k]=i
        dfs(k+1)
        vis[i]=0
        arr[k]=0
dfs(0)
ans.sort()
for i in ans:
    print(*i)