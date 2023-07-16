n = int(input())
isused1 = [False]*n
isused2 = [False]*((2*n)-1)
isused3 = [False]*((2*n)-1)
res=0

def func(x):
    global res
    
    if x==n:
        res+=1
        return

    for y in range(n):
        if isused1[y] or isused2[x+y] or isused3[x-y+n-1]:
            continue
        isused1[y]=1
        isused2[x+y]=1
        isused3[x-y+n-1]=1
        func(x+1)
        isused1[y]=0
        isused2[x+y]=0
        isused3[x-y+n-1]=0
        
func(0)
print(res)