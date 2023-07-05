n,m = map(int,input().split())
arr = []

def func(k):
    if len(arr)==m:
        print(*arr)
        return
    
    for i in range(k,n+1):
        arr.append(i)
        func(i)
        arr.pop()

func(1)