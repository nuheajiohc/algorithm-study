T = int(input())
for _ in range(T):
    n = int(input())
    stk=[list(map(int,input().split())) for __ in range(2)]
    if n>1:
        stk[0][1]+=stk[1][0]
        stk[1][1]+=stk[0][0]
    for i in range(2,n):
        stk[1][i]+= max(stk[0][i-2],stk[0][i-1])
        stk[0][i]+= max(stk[1][i-2],stk[1][i-1])
    print(max(stk[0][n-1],stk[1][n-1]))