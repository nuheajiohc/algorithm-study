import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int,input().split()))
nums.sort()
def check():
    st=0
    en=len(nums)-1
    min_s=2e9
    st_num=0
    en_num=0
    while st<en:
      s=nums[st]+nums[en]
      if min_s>abs(s):
          st_num=nums[st]
          en_num=nums[en]
          min_s=abs(s)
      if s<0:
          st+=1
      elif s>0:
          en-=1
      else:
          return (st_num,en_num)
    return (st_num,en_num)

print(*check())