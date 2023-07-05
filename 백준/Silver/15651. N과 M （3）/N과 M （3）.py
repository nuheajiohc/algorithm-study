n,m = map(int,input().split())
arr = [False] * m

def func(k):
    if k==m:
        print(*arr)
        return
    
    for i in range(1,n+1):
        arr[k]=i
        func(k+1)

func(0)