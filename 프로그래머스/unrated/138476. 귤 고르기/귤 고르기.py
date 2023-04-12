from collections import Counter

def solution(k, tangerine):
    
    sums =Counter(tangerine)
    nums=[sums[t] for t in sums]
    nums.sort(reverse=True)
    answer = len(nums)
    st=0
    en=0
    s=nums[0]
    temp=0
    while st<len(nums) and en<len(nums):
        if s>=k:
            temp+=1
            answer=min(answer,temp)
            s-=nums[st]
            st+=1
            temp-=1
        else:
            temp+=1
            en+=1
            if en>=len(nums):
                break
            s+=nums[en]
    return answer