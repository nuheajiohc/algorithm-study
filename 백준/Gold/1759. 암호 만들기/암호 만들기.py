l,c = map(int,input().split())
alpha = sorted(input().split())
moeum = {"a","e","i","o","u"}
vis = [0]*c

def func(depth,k,moeum_num,jaeum_num,result):
    if depth==l and moeum_num>0 and jaeum_num>1:
        print(result)
        return
    
    for i in range(k,c):
        if not vis[i]:
            vis[i]=1
            if alpha[i] in moeum:
                func(depth+1,i+1,moeum_num+1,jaeum_num,result+alpha[i])
            else:
                func(depth+1,i+1,moeum_num,jaeum_num+1,result+alpha[i])
            vis[i]=0

func(0,0,0,0,"")