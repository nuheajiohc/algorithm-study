H,W = map(int,input().split())
N = int(input())
sticker = [list(map(int,input().split())) for _ in range(N)]
sticker.sort(key = lambda x:-(x[0]*x[1]))
result=0
for i in range(N):
    for j in range(i+1,N):
        r1,c1 = sticker[i]
        r2,c2 = sticker[j]

        if (r1+r2 <= H and max(c1,c2)<= W) or (max(r1,r2) <= H and c1 +c2 <=W):
            result = max(result,r1*c1 + r2*c2)
        if (c1+r2 <=H and max(r1,c2)<=W) or (max(c1,r2) <= H and r1+c2 <=W):
            result = max(result,r1*c1 + r2*c2)
        if (c1+c2 <=H and max(r1,r2)<=W) or (max(c1,c2) <= H and r1+r2 <=W):
            result = max(result,r1*c1 + r2*c2)
        if (r1+c2 <=H and max(r2,c1)<=W) or (max(c2,r1) <= H and r2+c1 <=W):
            result = max(result,r1*c1 + r2*c2)
print(result)