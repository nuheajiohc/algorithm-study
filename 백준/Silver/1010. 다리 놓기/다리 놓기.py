T= int(input())
for _ in range(T):
    a,b = map(int,input().split())
    up=1
    for i in range(b-a+1,b+1):
        up*=i
    down=1
    for i in range(1,a+1):
        down*=i
    print(up//down)