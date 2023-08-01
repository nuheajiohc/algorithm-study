n = int(input())
nums = [0]+[int(input()) for _ in range(n)]
d=[[0,0] for _ in range(n+1)]

d[1]=[nums[1],nums[1]]
if n>1:
    d[2][0] = nums[2]
    d[2][1] = nums[2] + nums[1] 

for i in range (3,n+1):
    d[i][0] = nums[i] + max(*d[i-2],*d[i-3])
    d[i][1] = nums[i] + d[i-1][0]

print(max(*d[n],*d[n-1]))