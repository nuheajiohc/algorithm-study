a,b = map(int,input().split())
cnt=1
temp=b
while a<=temp:
    if a==temp:
        print(cnt)
        break
    if temp%2==0:
        temp//=2
    else:
        if str(temp)[-1]=="1":
            temp=int(str(temp)[:-1])
        else:
            print(-1)
            break
    cnt+=1
else:
    print(-1)