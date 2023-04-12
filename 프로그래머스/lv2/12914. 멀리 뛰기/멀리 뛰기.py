def solution(n):
    answer = 0
    memo={0:1,1:2}
    for i in range(2,n):
        if i not in memo:
            memo[i]=memo[i-1]+memo[i-2]
    answer=memo[n-1]%1234567
    return answer