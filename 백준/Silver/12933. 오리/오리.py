sound = list(input())
duck = ["q","u","a","c","k"]

cnt=0
vis=0
idx={"q":0,"u":0,"a":0,"c":0,"k":0}
flag=False
while True:
    for i in range(len(sound)):
        if duck[vis]==sound[i]:
            idx[duck[vis]]=i
            vis+=1
        if vis==5:
            flag=True
            for z in duck:
                sound[idx[z]]="x"
                idx[z]=0
            vis=0
    if flag==False:
        break
    cnt+=1
    vis=0
    for z in duck:
        idx[z]=0
    flag=False

if sound.count("x")!=len(sound):
    print(-1)
else:
    print(cnt)