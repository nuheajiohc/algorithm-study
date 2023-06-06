def solution(n):
    answer = []
    def hanoi(k,s,t):
        if k==0:
            return
        hanoi(k-1,s,6-s-t)
        answer.append([s,t])
        hanoi(k-1,6-s-t,t)
    hanoi(n,1,3)
    return answer