def solution(n):
    answer = 0
    memo=[0,1]
    for i in range(2,n+1):
        memo.append(memo[i-1]+memo[i-2])
    answer=memo[n]%1234567
    return answer