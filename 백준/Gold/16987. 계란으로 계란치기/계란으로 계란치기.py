n = int(input())
eggs = [list(map(int,input().split())) for _ in range(n)]
max_num = 0
vis = [0]*n

def dfs(k):
    global max_num
    if k==n:
        max_num=max(max_num,vis.count(1))
        return
    
    if vis[k]:
        dfs(k+1)
        return

    for i in range(n):
        if not vis[i] and i!=k:
            if eggs[k][0]<=eggs[i][1]:
                vis[k]=1
                if eggs[i][0]<=eggs[k][1]:
                    vis[i]=1
                    dfs(k+1)
                    vis[i]=0
                else:
                    eggs[i][0]-=eggs[k][1]
                    dfs(k+1)
                    eggs[i][0]+=eggs[k][1]
                vis[k]=0
            else:
                eggs[k][0]-=eggs[i][1]
                if eggs[i][0]<=eggs[k][1]:
                    vis[i]=1
                    dfs(k+1)
                    vis[i]=0
                else:
                    eggs[i][0]-=eggs[k][1]
                    dfs(k+1)
                    eggs[i][0]+=eggs[k][1]
                eggs[k][0]+=eggs[i][1]

    if k==n-1:
        max_num=max(max_num,vis.count(1))
        return
dfs(0)
print(max_num)