def func(n):
    if len(arr)==6:
        print(*arr)
    
    for i in range(n,k):
        arr.append(s[i])
        func(i+1)
        arr.pop()

while True:
    k,*s = map(int,input().split())
    if k==0:
        break
    arr = []
    func(0)
    print()