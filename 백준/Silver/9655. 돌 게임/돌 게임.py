N = int(input())
memo = ["SK" for _ in range(1001)]
memo[1] = "CY"
for i in range(2, N):
    memo[i] = memo[i-2]
print(memo[N-1])