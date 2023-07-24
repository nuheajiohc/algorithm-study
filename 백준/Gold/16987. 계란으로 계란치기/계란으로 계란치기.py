n = int(input())
eggs = [list(map(int,input().split())) for _ in range(n)]
max_num = 0
def dfs(k,count):
    global max_num
    if k==n:
        max_num = max(max_num,count)
        return
    
    if count==n-1:
        max_num = max(max_num,n-1)
        return
    
    if eggs[k][0]<=0:
        dfs(k+1,count)
        return

    for i in range(n):
        if eggs[i][0]>0 and i!=k:
            eggs[k][0]-=eggs[i][1]
            eggs[i][0]-=eggs[k][1]
            dfs(k+1,count+(eggs[k][0]<=0)+(eggs[i][0]<=0))
            eggs[k][0]+=eggs[i][1]
            eggs[i][0]+=eggs[k][1]

dfs(0,0)
print(max_num)