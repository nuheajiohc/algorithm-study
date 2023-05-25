n = int(input())
d= [[0,0] for _ in range(41)]
d[0]=[1,0]
d[1]=[0,1]
nums = [int(input()) for _ in range(n)]
for i in range(2,41):
    d[i]=[d[i-1][0]+d[i-2][0], d[i-1][1]+d[i-2][1]]

for i in nums:
    print(*d[i])