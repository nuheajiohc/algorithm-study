# def solution(stones, k):
#     answer = 0
#     while True:
#         jump = 0
#         flag=True
#         for i in range(len(stones)):
#             if stones[i] > 0 and jump<k:
#                 stones[i]-=1
#                 jump=0
#             elif stones[i]==0 and jump>=k:
#                 flag=False
#                 break
#             else :
#                 jump+=1
#         if flag==True:
#             answer+=1
#         else:
#             break
#     return answer

def solution (stones,k):
    st = min(stones)
    en = max(stones)
    
    while st<=en:
        mid = (st+en)//2
        cnt=0
        for stone in stones:
            if stone <= mid:
                cnt+=1
            else:
                cnt=0
            if cnt>=k:
                en =mid-1
                break
        else:
            st=mid+1
    return st