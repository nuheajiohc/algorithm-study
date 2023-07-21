n = int(input())
eggs = [list(map(int,input().split())) for _ in range(n)]
max_num = 0
def dfs(k,cnt):
    global max_num
    if k==n:
        max_num = max(max_num,cnt)
        return
    
    if eggs[k][0]<=0:
        dfs(k+1,cnt)
        return
    
    if cnt==n-1:
        max_num = max(max_num,cnt)
        return
    
    for i in range(n):
        if eggs[i][0]>0 and i!=k:
            eggs[i][0]-=eggs[k][1]
            eggs[k][0]-=eggs[i][1]
            temp=0
            if eggs[i][0]<=0:
                temp+=1
            if eggs[k][0]<=0:
                temp+=1
            dfs(k+1,cnt+temp)
            eggs[i][0]+=eggs[k][1]
            eggs[k][0]+=eggs[i][1]
dfs(0,0)
print(max_num)