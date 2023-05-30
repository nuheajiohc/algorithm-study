import sys
a,b = map(int,input().split())

def change(a,b,n):
    if a==b:
        print(n)
        sys.exit()
    if a>b:
        return
    change(a*2,b,n+1)
    temp=int(str(a)+"1")
    change(temp,b,n+1) 

change(a,b,1)
print(-1)