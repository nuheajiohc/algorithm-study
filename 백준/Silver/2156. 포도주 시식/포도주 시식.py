n = int(input())
nums = [0] + [int(input()) for _ in range(n)]
d = [0]*(n+1)
d[1] = nums[1]
if n>1:
    d[2] = nums[1] + nums[2]
if n>2:
    d[3] = max(nums[3]+nums[1],nums[3]+nums[2],d[2])

for i in range(4,n+1):
    d[i] = max(nums[i]+nums[i-1]+d[i-3],nums[i]+d[i-2],d[i-1])

print(d[n])