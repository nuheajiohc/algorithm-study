T =int(input())
for _ in range(T):
    n = int(input())
    sticker = []
    sticker.append(list(map(int,input().split())))
    sticker.append(list(map(int,input().split())))

    for i in range(1,n):
        if i==1:
            sticker[0][1]+=sticker[1][0]
            sticker[1][1]+=sticker[0][0]
            continue
        sticker[0][i]+=max(sticker[1][i-1],sticker[1][i-2])
        sticker[1][i]+=max(sticker[0][i-1],sticker[0][i-2])
    print(max(sticker[0][n-1],sticker[1][n-1]))