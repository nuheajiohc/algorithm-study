n = int(input())
house = [list(map(int,input().split())) for _ in range(n)]
d=[[0]*3 for  _ in range(n)]

for i in range(n):
    if i==0:
        d[0]=house[0]
        continue
    d[i][0]= min(d[i-1][1],d[i-1][2]) + house[i][0]
    d[i][1]= min(d[i-1][0],d[i-1][2]) + house[i][1]
    d[i][2]= min(d[i-1][0],d[i-1][1]) + house[i][2]
    
print(min(d[n-1]))