from collections import deque

def solution(n):
    answer = 0
    dq = deque()
    sum=0
    for i in range(1, n+1):
        sum += i
        dq.append(i)
        if sum==n:
            answer+=1
        elif sum>n:
            while True:
                sum-=dq.popleft()
                if sum==n:
                    answer+=1
                    break
                elif sum<n:
                    break
                    
            
        
        
    return answer


