t = int(input())

for _ in range(t):
    n = input()
    nums = list(map(int,input().split()))
    m = int(input())

    memo=[1]+[0]*m

    for num in nums:
        for i in range(num,m+1):
                memo[i] += memo[i-num]

    print(memo[m])