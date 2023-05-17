n = int(input())
s = [int(input()) for _ in range(n)]
d = [[0,0] for _ in range(n)]

for i in range(n):
    if i==0:
        d[i][0]=s[i]
        continue
    if i==1:
        d[i][0]=s[1]
        d[i][1]=s[0]+s[1] 
        continue
    d[i][0] = max(d[i-2][0],d[i-2][1]) + s[i]
    d[i][1] = d[i-1][0]+s[i]

print(max(d[n-1]))