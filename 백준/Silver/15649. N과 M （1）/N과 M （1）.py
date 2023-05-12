n,m = map(int,input().split())

vis= [0]*9
arr= [0]*8
def dfs(k):
    if k==m:
        print(*arr[:m],sep=" ")

    for i in range(1, n+1):
        if vis[i]:
            continue
        arr[k]=i
        vis[i]=1
        dfs(k+1)
        vis[i]=0
dfs(0)