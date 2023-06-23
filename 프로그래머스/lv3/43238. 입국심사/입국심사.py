def solution(n, times):
    answer = 0
    en = min(times)*n
    st = 0
    
    while st<=en:
        mid = (st+en)//2
        s=sum(map(lambda x:mid//x,times))
        if s>=n:
            en=mid-1
        else:
            st=mid+1
    
    return st