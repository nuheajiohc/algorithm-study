def solution(stones, k):
    max_stone = max(stones)
    min_stone = min(stones)
    while min_stone<=max_stone:
        mid =(min_stone+max_stone)//2
        cnt=0
        for i in stones:
            if mid>=i:
                cnt+=1
            else:
                cnt=0
            if cnt>=k:
                max_stone=mid-1
                break
        else:
            min_stone=mid+1
    return min_stone



